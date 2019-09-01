package com.countryside_culture.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.countryside_culture.entity.*;
import com.countryside_culture.service.*;
import com.countryside_culture.util.IpUtil;
import com.countryside_culture.util.RedisUtil;
import com.countryside_culture.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin(origins = "*",maxAge = 3600,allowCredentials = "true",allowedHeaders = "*")
@RequestMapping("user")
public class userController {
    @Autowired
    private userinfoService userinfoservice;
    @Autowired
    private videoService videoservice;
    @Autowired
    private focusService focusservice;
    @Autowired
    private reviewService reviewservice;
    //    用户登录
    @ResponseBody
    @RequestMapping(value = "/login")
    public String checkLogin(HttpServletRequest request,
                             @RequestParam(required = false,defaultValue = "index",value = "url")String url){
        String username=request.getParameter("username").toString();
        String password=request.getParameter("password").toString();
        userinfo  userinfo = userinfoservice.checkLogin(username,password);
        if (userinfo!=null) {//设置用户信息到session里面。
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
            String ip = IpUtil.getIp(request);
            userinfo.setLastLoginTime(sdf.format(d));
            userinfo.setLastLoginIp(ip);
            userinfoservice.update(userinfo);


            request.getSession().setAttribute("user",userinfo);
            request.getSession().setAttribute("picture", userinfo.getPicture());
            request.getSession().setAttribute("user_id", userinfo.getUserId());
            request.getSession().setAttribute("nickname",userinfo.getNickname());
            return url;
        }
        else
            return "no";
    }

    //    用户注册
    @ResponseBody
    @RequestMapping(value = "/register")
    public String Register(HttpServletRequest request){
        userinfo userinfo = new userinfo();
        userinfo.setPassword(request.getParameter("password").toString());
        userinfo.setUsername(request.getParameter("username").toString());
        userinfo.setNickname(request.getParameter("username").toString());
        userinfo.setEmail(request.getParameter("email").toString());
        userinfo.setPicture("default.jpg");
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
        int uid=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
        userinfo userinfo=userinfoservice.select(uid);
        if (userinfo.getPassword().equals(oldpassword)){
            userinfo.setPassword(newpassword);
            userinfoservice.update(userinfo);
            return "ok";
        }
        return "no";
    }
    //修改资料
    @ResponseBody
    @RequestMapping("update")
    public String Update(HttpServletRequest request,String nickname,String phone,String email){
        int uid=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
        String oldnickname=request.getSession().getAttribute("nickname").toString();
        List<userinfo> ans=userinfoservice.all(oldnickname);
        Boolean pd=false;
        if (!oldnickname.equals(nickname))
            pd=true;
        for (int i=0;i<ans.size();i++){
            if (ans.get(i).getNickname().equals(nickname))
                return "no";
        }
        userinfo userinfo=userinfoservice.select(uid);
        userinfo.setNickname(nickname);
        userinfo.setEmail(email);
        userinfo.setPhone(phone);
        userinfoservice.update(userinfo);
        request.getSession().setAttribute("user",userinfo);
        request.getSession().setAttribute("nickname",userinfo.getNickname());

        if (pd){
            List<review> reviews=reviewservice.all();
            for (int k=0;k<reviews.size();k++){
                if (reviews.get(k).getPlname().equals(oldnickname)){
                    reviews.get(k).setPlname(nickname);
                }
                if (reviews.get(k).getRname().equals(oldnickname)){
                    reviews.get(k).setRname(nickname);
                }
            }
        }
        return "ok";
    }

    @RequestMapping("/show")
    public String show(HttpServletRequest request, Model model
            , @RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn
            , @RequestParam(required = false,defaultValue = "8",value = "pagesize")Integer pagesize) throws ParseException {
        int uid=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
//        PageHelper.startPage(pn,pagesize);//第pn页，每页pagesize记录
        //查看当前用户所有收藏视频
        List<video_collect> video_collect=videoservice.showcollect(uid);
//        PageInfo pageInfo = new PageInfo<>(video_collect,5);
//        Fn.ajaxReturn(response,pageInfo);
        model.addAttribute("collect",video_collect);


        //查看当前用户所关注的所有演员
        List<focus> focus=focusservice.showfocus(uid);
        model.addAttribute("focus",focus);

        //历史记录
        history history=null;
        List<video> today = new ArrayList<video>();
        List<video> tomorrow = new ArrayList<video>();
        List<video> earlier = new ArrayList<video>();
        String historyValue = null;
        RedisUtil redisUtil = null;
        redisUtil = (RedisUtil) SpringUtil.applicationContext.getBean("redisUtil");//从spring容器里面得到一个对象
        historyValue = redisUtil.get(request.getSession().getAttribute("user_id").toString());
        if(historyValue == null){
             history=new history();
        }else {
            history = JSON.parseObject(historyValue, new TypeReference<history>() {});
            Date now = new Date();
            SimpleDateFormat a = new SimpleDateFormat("yyyy/MM/dd");
            int index=0;
            for (int i = 0; i+index < history.getItems().size(); i++) {
                Long xc = a.parse(a.format(now)).getTime() - a.parse(history.getItems().get(i+index).getHistorytime()).getTime();
                if (xc == 0) {
                    today.add(history.getItems().get(i+index));
                } else if ((xc > 86400000||xc==86400000) && (xc < 172800000||xc==172800000)) {
                    tomorrow.add(history.getItems().get(i+index));
                } else {
                    Boolean pd=false;
                    if (earlier.size()==0) {
                        earlier.add(history.getItems().get(i + index));
                        continue;
                    }
                    for (int k=0;k<earlier.size();k++){
                        if (earlier.get(k).getId()==history.getItems().get(i+index).getId()){
                            history.removeItem(i+index);
                            index--;
                            pd=true;
                            break;
                        }
                    }
                    if (pd==false)
                        earlier.add(history.getItems().get(i+index));
                }
            }
        }
        String fromObject = JSON.toJSONString(history);
        redisUtil.set(request.getSession().getAttribute("user_id").toString(), fromObject.toString());
        model.addAttribute("today",today);
        model.addAttribute("tomorrow",tomorrow);
        model.addAttribute("earlier",earlier);
        return "profile";
    }

    //用户退出
    @ResponseBody
    @RequestMapping("/logout")
    public String  Logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "ok";
    }
}
