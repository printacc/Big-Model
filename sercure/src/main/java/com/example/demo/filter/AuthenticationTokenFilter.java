package com.example.demo.filter;

import com.auth0.jwt.interfaces.Claim;
import com.example.demo.dao.CacheDao;
import com.example.demo.util.JwtUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class AuthenticationTokenFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        // 获取请求头中的token
        String token = httpServletRequest.getHeader("YjlTOKEN");
        if(StringUtils.isEmpty(token)){
            // 没有携带token，传递给Security验证
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        // 验证token是否合法
        Map<String, Claim> userInfoMap = JwtUtil.parseToken(token);
        System.out.println("userInfoMap = " + userInfoMap);

        if(userInfoMap == null){
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        String userId = String.valueOf(userInfoMap.get("userid"));

        // 判断token是否在缓存中，实际中可使用redis替代
        boolean isExistToken = false;

        // 设置权限，从缓存中获取用户信息
        List<GrantedAuthority> authorityList = null;
        for (Map<String, Object> item: CacheDao.userInfoList) {
            if(item.get("token").equals(token)){
                isExistToken = true;
                authorityList = (List<GrantedAuthority>) item.get("authority");
                break;
            }
        }

        if(!isExistToken){
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        // 验证id，并设置权限
        // 注意：此处是为了通过检验，不能添加密码
        Authentication authentication = new UsernamePasswordAuthenticationToken(userId,null, authorityList);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 放行action
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}

