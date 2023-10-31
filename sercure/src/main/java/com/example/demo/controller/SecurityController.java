package com.example.demo.controller;


import com.example.demo.dao.CacheDao;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/security")
@ResponseBody
public class SecurityController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String login(String name, String pwd){
        return this.loginService.login(name, pwd);
    }

    @PostMapping("/logout")
    public String logout(String name, String pwd){
        return this.loginService.logout(name, pwd);
    }

    @PostMapping("/test")
    @PreAuthorize("hasAnyAuthority('expert')")
    public String test(){
        return CacheDao.userInfoList.toString();
    }

    @PostMapping("/admin")
    @PreAuthorize("hasAnyAuthority('admin')")
    public String admin(){
        return "admin";
    }
}
