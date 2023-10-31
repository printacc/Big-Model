package com.example.demo.service;

import com.example.demo.dao.CacheDao;
import com.example.demo.entity.UserInfo;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    // 调用WebSecurityConfig中的authenticationManagerBean方法返回值
    @Autowired
    private AuthenticationManager authenticationManager;

    public String login(String name, String pwd) {

        // 设置登录的验证信息
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(name, pwd);

        /*
         * （1）自动调用UserDetailsService接口的实现类UserDetailsServiceImp;
         * （2）自动验证UserDetailsServiceImp类中loadUserByUsername方法的返回值UserDetails接口的实现类UserInfo；
         * （3）鉴权失败，返回403
         */

        Authentication authentication = null;
        try {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication =  this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (Exception e) {
            System.out.println("账号或密码错误！");
        }

        if(authentication != null){
            // 获取用户信息
            UserInfo userInfo = (UserInfo) authentication.getPrincipal();
            System.out.println(userInfo.getId()+" "+userInfo.getUsername());

            // 生成token
            String token = JwtUtil.createToken(userInfo.getId());



            // 将用户信息添加到缓存中，可用redis替代
            // 注意：此处的信息会在filter中用到
            Map<String, Object> cacheUserInfo = new HashMap<>();
            cacheUserInfo.put("userId", userInfo.getId());
            cacheUserInfo.put("token", token);
            cacheUserInfo.put("authority", userInfo.getAuthorities());
            CacheDao.userInfoList.add(cacheUserInfo);

            return token;
        }else {
            System.out.println("登录失败！");
            return "-1";
        }

    }

    // 退出
    public String logout(String name, String pwd){
        return "logout";
    }

}


