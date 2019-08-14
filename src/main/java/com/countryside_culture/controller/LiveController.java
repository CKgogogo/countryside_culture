package com.countryside_culture.controller;

import com.countryside_culture.dao.StatDao;
import com.countryside_culture.entity.MsgEntity;
import com.countryside_culture.entity.userinfo;
import com.countryside_culture.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by Administrator on 2017/6/14.
 */
@Controller
@CrossOrigin(origins = "*",maxAge = 3600,allowCredentials = "true",allowedHeaders = "*")
public class LiveController {
//    @Autowired
//    private UserDao userDao;
    @Autowired
    private StatDao statDao;

    @RequestMapping(value = "/live_room",method = RequestMethod.GET)
    public String hello(HttpServletRequest request, Model model ){
        //根据用户ip判断用户是否访问过本站
        String ip = IpUtil.getIp(request);
        Random random = new Random(20);
        HttpSession session = request.getSession();
        if (session.getAttribute("user")==null){
            userinfo user=new userinfo();
            user.setLastLoginIp(ip);
            user.setNickname("游客"+random.nextInt(100));
            session.setAttribute("user",user);
            System.out.println("ip="+ip+"name="+user.getNickname());
        }

//        session.setAttribute("user",user);

        model.addAttribute("online_guests",getOnlineUser());
        model.addAttribute("history_guests",getHistoryGuests());
        return "live2";

    }

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
        String username = user.getNickname();

        MsgEntity msg = new MsgEntity();
        msg.setCreator(username);
        msg.setsTime(Calendar.getInstance());
        msg.setMsgBody(message);
        return msg;
    }

}
