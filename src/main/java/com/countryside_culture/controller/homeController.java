package com.countryside_culture.controller;

import com.countryside_culture.entity.*;
import com.countryside_culture.service.*;
import com.zlzkj.core.util.Fn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("home")
public class homeController {
    @Autowired
    private museumService museumservice;
    @Autowired
    private newsService newsservice;
    @Autowired
    private headlinesService headlinesservice;
    @Autowired
    private typeService typeservice;
    @Autowired
    private activityService activityservice;
    @Autowired
    private videoService videoservice;
    //    首页越剧名家
    @RequestMapping("/famous")
    public String showMuseum(HttpServletResponse response, Model model
            ,@RequestParam(required = false,defaultValue = "4",value = "amount")Integer amount) {
        List<museum> famous = museumservice.showfamous(amount);
        model.addAttribute("famous", famous);
        Fn.ajaxReturn(response,famous);
        return "index";
    }

    //    首页最新资讯
    @RequestMapping("/news")
    public String showNews(HttpServletResponse response, Model model
            ,@RequestParam(required = false,defaultValue = "4",value = "amount")Integer amount){
        List<news> news = newsservice.show(amount);
        model.addAttribute("news", news);
        Fn.ajaxReturn(response,news);
        return "index";
    }

    //    首页越剧团
    @RequestMapping("/troupe")
    public String showTrouope(HttpServletResponse response, Model model
            ,@RequestParam(required = false,defaultValue = "5",value = "amount")Integer amount){
        List<museum> troupe = museumservice.showtroupe(amount);
        model.addAttribute("troupe", troupe);
        Fn.ajaxReturn(response,troupe);
        return "index";
    }

    //    首页轮播图
    @RequestMapping("/headlines")
    public String showHeadlines(HttpServletResponse response, Model model
            ,@RequestParam(required = false,defaultValue = "5",value = "amount")Integer amount){
        List<headlines> headlines = headlinesservice.show(amount);
        model.addAttribute("headlines", headlines);
        Fn.ajaxReturn(response,headlines);
        return "index";
    }

    //点击轮播图
    @RequestMapping("/goto")
    public String Goto(HttpServletResponse response, Model model,int id){
        headlines headlines=headlinesservice.selectid(id);
        type type=typeservice.selectid(headlines.getKind());
        String url=type.getUrl();
        if (type.getName().equals("活动")) {
            activity ans=activityservice.selectid(headlines.getPid());
            model.addAttribute("ans", ans);
        }else if (type.getName().equals("新闻")){
            news ans=newsservice.selectOne(headlines.getPid());
            model.addAttribute("ans", ans);
        }else if (type.getName().equals("视频")){
            video ans=videoservice.selectone(headlines.getPid());
            model.addAttribute("ans", ans);
        }else if (type.getPid()==1){
            museum ans=museumservice.selectOne(headlines.getPid());
            model.addAttribute("ans", ans);
            url=url.substring(0,url.length()-5)+"_details.html";
        }
        return url;
    }

}