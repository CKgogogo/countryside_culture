package com.countryside_culture.controller;

import com.countryside_culture.entity.news;
import com.countryside_culture.service.newsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("news")
public class newsController {
    @Autowired
    private newsService newsservice;
//    所有资讯
    @RequestMapping(value = "/showall",method = RequestMethod.POST)
    public String showAllNews(HttpServletResponse response, Model model) {
    List<news> news = newsservice.showall();
    model.addAttribute("news", news);
    return "yueju_infomation";
    }

//    具体资讯
    @RequestMapping(value = "/selectone",method = RequestMethod.POST)
    public String selectOne(HttpServletResponse response, Model model, HttpServletRequest request) {
        int id=Integer.parseInt(request.getParameter("id"));
        news news = newsservice.selectOne(id);
        model.addAttribute("news", news);
        return "blog_single";
    }

}
