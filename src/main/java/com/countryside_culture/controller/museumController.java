package com.countryside_culture.controller;

import com.countryside_culture.entity.museum;
import com.countryside_culture.entity.museum_class;
import com.countryside_culture.mapper.museum_classMapper;
import com.countryside_culture.service.museumService;
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
@RequestMapping("museum")
public class museumController {
    @Autowired
    private museumService museumservice;
    @Autowired
    private museum_classMapper museum_classmapper;
    //    越剧博物馆各个种类所有信息
    @RequestMapping(value = "/showkind",method = RequestMethod.POST)
    public String showAllMuseum(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,@RequestParam(required = false,defaultValue = "6",value = "pagesize")Integer pagesize, HttpServletResponse response, Model model,int kind) {
        PageHelper.startPage(pn,pagesize);//第pn页，每页pagesize记录
        List<museum> museum = museumservice.showkind(kind);
        model.addAttribute("museum", museum);
        PageInfo pageInfo = new PageInfo<>(museum,5);
        Fn.ajaxReturn(response,pageInfo);
        return "";
    }
    //越剧博物馆所有分类
    @RequestMapping(value = "/showclass",method = RequestMethod.POST)
    public String showAllKind( HttpServletResponse response, Model model) {
        List<museum_class> museum_class=museum_classmapper.selectall();
        Fn.ajaxReturn(response,museum_class);
        return "";
    }

    //    越剧博物馆具体信息
    @RequestMapping(value = "/selectone",method = RequestMethod.POST)
    public String selectOne(HttpServletResponse response, Model model, HttpServletRequest request) {
        int id=Integer.parseInt(request.getParameter("id"));
        museum museum = museumservice.selectOne(id);
        model.addAttribute("museum", museum);
        Fn.ajaxReturn(response,museum);
        return "";
    }
}
