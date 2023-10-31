package com.example.demo.service;

import com.example.demo.dao.CacheDao;
import com.example.demo.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("ps")
public class PermissionService {

    public boolean permission(String permission) {
        System.out.println("permission = " + permission);
        System.out.println("(CharSequence) SecurityContextHolder.getContext().getAuthentication().getAuthorities() = " + (CharSequence) SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        if (permission.contains((CharSequence) SecurityContextHolder.getContext().getAuthentication().getAuthorities())){
            System.out.println("对的");
            return true;
        }

        return false;
    }
}
