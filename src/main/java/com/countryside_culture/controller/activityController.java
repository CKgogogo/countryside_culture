package com.countryside_culture.controller;

import com.countryside_culture.entity.activity;
import com.countryside_culture.service.activityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlzkj.core.util.Fn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("activity")
public class activityController {
    @Autowired
    private activityService activityservice;

    //显示所有活动
    @RequestMapping(value = "/showall")
    public String showAllNews(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,
                              @RequestParam(required = false,defaultValue = "6",value = "pagesize")Integer pagesize,
                              HttpServletResponse response) {
        PageHelper.startPage(pn,pagesize);//第pn页，6条记录
        List<activity> activity = activityservice.showall();
        PageInfo pageInfo = new PageInfo<>(activity,5);
        Fn.ajaxReturn(response,pageInfo);
        return "";
    }

    //具体活动
    @RequestMapping(value = "/selectone")
    public String selectOne(HttpServletResponse response, HttpServletRequest request) {
        int id=Integer.parseInt(request.getParameter("id"));
        activity activity = activityservice.selectid(id);
        Fn.ajaxReturn(response,activity);
        return "";
    }
}
