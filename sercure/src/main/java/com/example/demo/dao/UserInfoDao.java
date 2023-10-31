package com.example.demo.dao;

import com.example.demo.entity.UserInfo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserInfoDao {

    // 模拟从数据库中获取用户信息
    public UserInfo getUserInfo(String userName){

        // 模拟数据库中的用户信息
        List<UserInfo> userInfoList = new ArrayList<>();
        // 密码是 1223456
        // 注意：此处密码必须使用BCryptPasswordEncoder加密
        UserInfo userInfo = new UserInfo();
        userInfo.setId("1");
        userInfo.setUsername("zhangsan");
        userInfo.setPassword("$2a$10$csDT9rGTLPtFkMg7OgMsuOOrPQ8wmRlb2fPlGJBi/lz0bR.MfKPKG");
        userInfo.setAuthorities(new ArrayList<>());
        userInfoList.add(userInfo);

        userInfo = new UserInfo();
        userInfo.setId("2");
        userInfo.setUsername("lisi");
        userInfo.setPassword("$2a$10$csDT9rGTLPtFkMg7OgMsuOOrPQ8wmRlb2fPlGJBi/lz0bR.MfKPKG");
        userInfo.setAuthorities(new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority("admin"), new SimpleGrantedAuthority("expert"))));
        userInfoList.add(userInfo);

        userInfo = new UserInfo();
        userInfo.setId("3");
        userInfo.setUsername("wangwu");
        userInfo.setPassword("$2a$10$csDT9rGTLPtFkMg7OgMsuOOrPQ8wmRlb2fPlGJBi/lz0bR.MfKPKG");
        userInfo.setAuthorities(new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority("expert"))));
        userInfoList.add(userInfo);

        // 查找用户信息
        for (UserInfo userInfoItem: userInfoList ) {
            if(userInfoItem.getUsername().equals(userName)){
                return userInfoItem;
            }
        }

        return null;
    }
}


