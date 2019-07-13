package com.countryside_culture.controller;

import com.countryside_culture.entity.news;
import com.countryside_culture.service.newsService;
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
import java.util.List;


@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("news")
public class newsController {
    @Autowired
    private newsService newsservice;
//    所有资讯
    @RequestMapping(value = "/showall",method = RequestMethod.POST)
    public String showAllNews(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,@RequestParam(required = false,defaultValue = "6",value = "pagesize")Integer pagesize, HttpServletResponse response, Model model) {
        PageHelper.startPage(pn,pagesize);//第pn页，6条记录
        List<news> news = newsservice.showall();
//      model.addAttribute("news", news);
        PageInfo pageInfo = new PageInfo<>(news,5);
        Fn.ajaxReturn(response,pageInfo);
    return "";
    }

//    具体资讯
    @RequestMapping(value = "/selectone",method = RequestMethod.POST)
    public String selectOne(HttpServletResponse response, Model model, HttpServletRequest request) {
        int id=Integer.parseInt(request.getParameter("id"));
        news news = newsservice.selectOne(id);
        news.setClickNum(news.getClickNum()+1);
        model.addAttribute("news", news);
        Fn.ajaxReturn(response,news);
        return "";
    }

}
