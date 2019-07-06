package com.countryside_culture.controller;

import com.countryside_culture.entity.museum;
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
    //    越剧博物馆所有信息
    @RequestMapping(value = "/showall",method = RequestMethod.POST)
    public String showAllMuseum(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn, HttpServletResponse response, Model model) {
        PageHelper.startPage(pn,6);//第pn页，6条记录
        List<museum> museum = museumservice.showall();
//        model.addAttribute("museum", museum);
        PageInfo pageInfo = new PageInfo<>(museum,5);
        Fn.ajaxReturn(response,pageInfo);
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
