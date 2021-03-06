package com.countryside_culture.controller;

import com.countryside_culture.entity.activity;
import com.countryside_culture.service.activityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlzkj.core.util.Fn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins = "*",maxAge = 3600,allowCredentials = "true",allowedHeaders = "*")
@RequestMapping("activity")
public class activityController {
    @Autowired
    private activityService activityservice;

    //显示所有活动
    @RequestMapping(value = "/showall",method = RequestMethod.GET)
    public String showAllNews(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,
                              @RequestParam(required = false,defaultValue = "6",value = "pagesize")Integer pagesize,
                              HttpServletResponse response, Map<String,Object> map, Model model) throws ParseException {
        PageHelper.startPage(pn,pagesize);//第pn页，6条记录
        List<activity> activity = activityservice.showall();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        for (int i=0;i<activity.size();i++){
            Date date = simpleDateFormat.parse(activity.get(i).getEndtime());
            Date date2 = simpleDateFormat.parse(activity.get(i).getStarttime());
            Date d = new Date();
            if(date.getTime()>d.getTime()&&d.getTime()>date2.getTime()) {
                activity.get(i).setStatus("正在进行");
                activityservice.update(activity.get(i));
            }else if (d.getTime()<date2.getTime()){
                activity.get(i).setStatus("未开始");
                activityservice.update(activity.get(i));
            }else if(d.getTime()>date.getTime()){
                activity.get(i).setStatus("已结束");
                activityservice.update(activity.get(i));
            }
        }
        PageInfo pageInfo = new PageInfo<>(activity,5);
        List<activity> activity2 = activityservice.showhot();
        model.addAttribute("hot",activity2);
        model.addAttribute("ans",pageInfo);
        map.put("pageInfo",pageInfo);
        return "active";
    }

    //显示不同的活动
    @RequestMapping(value = "/showdoing")
    public String showdoing(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,
                              @RequestParam(required = false,defaultValue = "6",value = "pagesize")Integer pagesize,
                              HttpServletResponse response,String status) throws ParseException {
        PageHelper.startPage(pn,pagesize);//第pn页，6条记录
        List<activity> activity = activityservice.showall();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        for (int i=0;i<activity.size();i++){
            Date date = simpleDateFormat.parse(activity.get(i).getEndtime());
            Date date2 = simpleDateFormat.parse(activity.get(i).getStarttime());
            Date d = new Date();
            if(date.getTime()>d.getTime()&&d.getTime()>date2.getTime()) {
                activity.get(i).setStatus("正在进行");
                activityservice.update(activity.get(i));
            }else if (d.getTime()<date2.getTime()){
                activity.get(i).setStatus("未开始");
                activityservice.update(activity.get(i));
            }else if(d.getTime()>date.getTime()){
                activity.get(i).setStatus("已结束");
                activityservice.update(activity.get(i));
            }
        }
        List<activity> ans=activityservice.showdoing(status);
        PageInfo pageInfo = new PageInfo<>(ans,5);
        Fn.ajaxReturn(response,pageInfo);
        return "";
    }

    //具体活动
    @RequestMapping(value = "/selectone",method = RequestMethod.GET)
    public String selectOne(HttpServletResponse response, HttpServletRequest request, Model model) {
        int id=Integer.parseInt(request.getParameter("id"));
        activity activity = activityservice.selectid(id);
        activity.setHits(activity.getHits()+1);
        activityservice.update(activity);
        model.addAttribute("ans",activity);
//        Fn.ajaxReturn(response,activity);
        return "activeDetails";
    }

    //热门活动
    @RequestMapping(value = "/showhot")
    public String Showhot(HttpServletResponse response, HttpServletRequest request) {
        List<activity> activity = activityservice.showhot();
        Fn.ajaxReturn(response,activity);
        return "";
    }

}
