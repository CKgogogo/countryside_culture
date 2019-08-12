package com.countryside_culture.controller;

import com.countryside_culture.dao.StatDao;
import com.countryside_culture.entity.MsgEntity;
import com.countryside_culture.entity.userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/6/14.
 */
@Controller
public class LiveController {
//    @Autowired
//    private UserDao userDao;
    @Autowired
    private StatDao statDao;

//    @RequestMapping(value = "/live_room",method = RequestMethod.GET)
//    public String hello(HttpServletRequest request, Model model){
//        //根据用户ip判断用户是否访问过本站
//        String ip = IpUtil.getIp(request);
//        Random random = new Random(20);
//        HttpSession session = request.getSession();
//        userinfo user;
//        if (userDao.findOne(ip) != null){
//            //用户曾经访问过
//            System.out.println("用户曾经访问过");
//            user = userDao.findOne(ip);
//        }else {
//            //用户未访问过，存储用户信息
//            System.out.println("用户未访问过");
//            user = new userinfo();
//            user.setIp(ip);
//            user.setRandomName(NameGenerator.generate());
//            System.out.println("ip="+ip+"name="+user.getRandomName());
//            userDao.save(user);
//        }
//        //System.out.println("ip="+ip+"name="+user.getRandomName());
//        session.setAttribute("user",user);
//
//        return "live";
//        判断用户是手机还是电脑端
//        if (UserAgentUtil.JudgeIsMoblie(request)){
//            //移动端访问
//            return "live_m";
//        }else {
//            model.addAttribute("online_guests",getOnlineUser());
//            model.addAttribute("history_guests",getHistoryGuests());
//            return "live";
//        }
//    }
    @RequestMapping(value = "/online_guests",method = RequestMethod.GET)
    @ResponseBody
    public Set getOnlineUser(){
        return  statDao.getAllUserOnline();
    }

    @RequestMapping(value = "/history_guests",method = RequestMethod.GET)
    @ResponseBody
    public List getHistoryGuests(){
        return statDao.getGuestHistory();
    }

    @MessageMapping(value = "/chat")
    @SendTo("/topic/group")
    public MsgEntity testWst(String message , @Header(value = "simpSessionAttributes") Map<String,Object> session){
        userinfo user = (userinfo) session.get("user");
        String username = user.getUsername();

        MsgEntity msg = new MsgEntity();
        msg.setCreator(username);
        msg.setsTime(Calendar.getInstance());
        msg.setMsgBody(message);
        return msg;
    }

}
