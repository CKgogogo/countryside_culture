package com.countryside_culture.controller;

import com.countryside_culture.entity.userinfo;
import com.countryside_culture.service.userinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("index")
public class indexController {
    @Autowired
    private userinfoService userinfoservice;
//    用户登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String checkLogin(HttpServletRequest request){
        userinfo userinfo = new userinfo();
        userinfo.setPassword(request.getParameter("password").toString());
        userinfo.setUsername(request.getParameter("username").toString());
        int i = userinfoservice.checkLogin(userinfo);
        if (i > 0) {//设置用户信息到session里面。
            request.getSession().setAttribute("username", userinfo.getUsername());
            request.getSession().setAttribute("user_id", userinfo.getUserId());
            return "ok";
        }
        else
            return "no";
    }

//    用户注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String Register(HttpServletRequest request){
        userinfo userinfo = new userinfo();
        userinfo.setPassword(request.getParameter("password").toString());
        userinfo.setUsername(request.getParameter("username").toString());
        userinfo.setEmail(request.getParameter("email").toString());
        userinfo.setStatus(1);
        int i = userinfoservice.register(userinfo);
        if (i > 0){
            return "ok";
        } else {
            return "no";
        }
    }


}
