package com.countryside_culture.controller;

import com.countryside_culture.entity.focus;
import com.countryside_culture.entity.userinfo;
import com.countryside_culture.entity.video_collect;
import com.countryside_culture.service.focusService;
import com.countryside_culture.service.userinfoService;
import com.countryside_culture.service.videoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlzkj.core.util.Fn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("user")
public class userController {
    @Autowired
    private userinfoService userinfoservice;
    @Autowired
    private videoService videoservice;
    @Autowired
    private focusService focusservice;
    //    用户登录
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String checkLogin(HttpServletRequest request){
        String username=request.getParameter("username").toString();
        String password=request.getParameter("password").toString();
        userinfo  userinfo = userinfoservice.checkLogin(username,password);
        if (userinfo!=null) {//设置用户信息到session里面。
            request.getSession().setAttribute("picture", userinfo.getPicture());
            request.getSession().setAttribute("user_id", userinfo.getUserId());
            request.getSession().setAttribute("nickname",userinfo.getNickname());
            return "ok";
        }
        else
            return "no";
    }

    //    用户注册
    @ResponseBody
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

    //修改密码
    @ResponseBody
    @RequestMapping("modifypwd")
    public String Modifypwd(HttpServletRequest request,String oldpassword,String newpassword){
        String username=request.getSession().getAttribute("username").toString();
        userinfo userinfo=userinfoservice.checkLogin(username,oldpassword);
        if (userinfo!=null){
            userinfo.setPassword(newpassword);
            userinfoservice.update(userinfo);
            return "ok";
        }
        return "no";
    }

        //查看当前用户所有收藏视频
    @RequestMapping("/showcollect")
    public String showAllCollect(HttpServletRequest request, HttpServletResponse response
            , @RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn
            , @RequestParam(required = false,defaultValue = "8",value = "pagesize")Integer pagesize){
        int uid=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
        PageHelper.startPage(pn,pagesize);//第pn页，每页pagesize记录
        List<video_collect> video_collect=videoservice.showcollect(uid);
        PageInfo pageInfo = new PageInfo<>(video_collect,5);
        Fn.ajaxReturn(response,pageInfo);
        return "";
    }

    //查看当前用户所关注的所有演员
    @RequestMapping("showfocus")
    public String showAllFocus(HttpServletRequest request, HttpServletResponse response
            , @RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn
            , @RequestParam(required = false,defaultValue = "8",value = "pagesize")Integer pagesize){
        int uid=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
        PageHelper.startPage(pn,pagesize);//第pn页，每页pagesize记录
        List<focus> focus=focusservice.showfocus(uid);
        PageInfo pageInfo = new PageInfo<>(focus,5);
        Fn.ajaxReturn(response,pageInfo);
        return "";
    }

}
