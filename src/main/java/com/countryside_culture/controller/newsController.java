package com.countryside_culture.controller;

import com.countryside_culture.entity.news;
import com.countryside_culture.service.newsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
@CrossOrigin(origins = "*",maxAge = 3600,allowCredentials = "true",allowedHeaders = "*")
@RequestMapping("news")
public class newsController {
    @Autowired
    private newsService newsservice;
//    所有资讯
    @RequestMapping(value = "/showall",method = RequestMethod.GET)
    public String showAllNews(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,
                              @RequestParam(required = false,defaultValue = "6",value = "pagesize")Integer pagesize,
                              Map<String,Object> map, Model model) {
        PageHelper.startPage(pn,pagesize);//第pn页，6条记录
        List<news> news = newsservice.showall();
        PageInfo pageInfo = new PageInfo<>(news,5);
        model.addAttribute("ans",pageInfo);
        map.put("pageInfo",pageInfo);
//        Fn.ajaxReturn(response,pageInfo);
    return "news";
    }

//    具体资讯
    @RequestMapping(value = "/selectone",method = RequestMethod.GET)
    public String selectOne(HttpServletResponse response, Model model, HttpServletRequest request) throws ParseException {
        int id=Integer.parseInt(request.getParameter("id"));
        news news = newsservice.selectOne(id);
        news.setClickNum(news.getClickNum()+1);
        newsservice.update(news);
        model.addAttribute("news", news);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        List<news> a = newsservice.showall();
        List<news> latestnews=new ArrayList<news>();
        Date d = new Date();
        Long time=d.getTime()- (3 * 24 * 60 * 60 * 1000L);
        for (int i=0;i<a.size();i++){
            Date b = simpleDateFormat.parse(a.get(i).getPublishTime());
            if (b.getTime()>time){
                latestnews.add(a.get(i));
            }else {
                break;
            }
        }
        model.addAttribute("latestnews", latestnews);
        return "newsDetails";
    }

}
