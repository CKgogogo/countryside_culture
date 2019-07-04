package com.countryside_culture.controller;

import com.countryside_culture.entity.headlines;
import com.countryside_culture.entity.museum;
import com.countryside_culture.entity.news;
import com.countryside_culture.entity.troupe;
import com.countryside_culture.mapper.museumMapper;
import com.countryside_culture.service.headlinesService;
import com.countryside_culture.service.museumService;
import com.countryside_culture.service.newsService;
import com.countryside_culture.service.troupeService;
import com.zlzkj.core.util.Fn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.text.AttributedString;
import java.util.List;

@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("home")
public class HomeController {
    @Autowired
    private museumService museumservice;
    @Autowired
    private newsService newsservice;
    @Autowired
    private troupeService troupeservice;
    @Autowired
    private headlinesService headlinesservice;
//    首页越剧名家
    @RequestMapping("/museum")
    public String showMuseum(HttpServletResponse response, Model model) {
        List<museum> museum = museumservice.show();
        model.addAttribute("museum", museum);
        Fn.ajaxReturn(response,museum);
        return "index";
    }

//    首页最新资讯
    @RequestMapping("/news")
    public String showNews(HttpServletResponse response, Model model){
        List<news> news = newsservice.show();
        model.addAttribute("news", news);
        Fn.ajaxReturn(response,news);
        return "index";
    }

//    首页越剧团
    @RequestMapping("/troupe")
    public String showTrouope(HttpServletResponse response, Model model){
        List<troupe> troupe = troupeservice.show();
        model.addAttribute("troupe", troupe);
        Fn.ajaxReturn(response,troupe);
        return "index";
    }

//    首页轮播图
    @RequestMapping("/headlines")
    public String showHeadlines(HttpServletResponse response, Model model){
        List<headlines> headlines = headlinesservice.show();
        model.addAttribute("headlines", headlines);
        Fn.ajaxReturn(response,headlines);
        return "index";
    }




}