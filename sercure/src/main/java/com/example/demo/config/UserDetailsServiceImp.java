package com.example.demo.config;


import com.example.demo.dao.UserInfoDao;
import com.example.demo.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // 根据用户名获取用户的权限信息
        UserInfo userInfo = this.userInfoDao.getUserInfo(userName);

        return userInfo;
    }

}
