package com.example.demo.config;


import com.example.demo.filter.AuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 自动调用config.UserDetailsServiceImp
    // 按照byType注入
    @Autowired
    private UserDetailsService userDetailsService;

    // 设置权限
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    // 未登录
    @Autowired
    private AuthenticationEntryPoint authEntryPoint;


    @Autowired
    private AuthenticationTokenFilter authenticationTokenFilter;

    // 将BCryptPasswordEncoder对象注入Spring容器中，
    // SpringSecurity会使用PasswordEncoder自动密码校验
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // 用户权限管理器，进行用户认证，配置用户签名服务和用户权限控制
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    // 用户认证，配置用户签名服务和用户权限控制
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 会自动调用UserDetailsServiceImp下的loadUserByUsername()方法
        auth.userDetailsService(this.userDetailsService).passwordEncoder(this.passwordEncoder());
    }

    // 用户授权，配置拦截请求、请求验证、异常处理
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 不通过Session获取SecurityContext
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //关闭csrf
        http.csrf().disable();

        // 解决跨域
        http.cors();

        // 未登录
        http.exceptionHandling().authenticationEntryPoint(authEntryPoint);

        // 设置权限，对应hasAnyAuthority
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);

        // 设置认证的action
        http.authorizeRequests()
                // 不拦截以下action
                .antMatchers("/security/login").permitAll()

                // 具有admin和expert权限的可以访问此路径
//                .antMatchers("/security/admin").hasAnyAuthority("admin", "expert")

                // 处了上面的action，都需要鉴权认证
                .anyRequest().authenticated();


        // 设置过滤器
        http.addFilterBefore(this.authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

}

