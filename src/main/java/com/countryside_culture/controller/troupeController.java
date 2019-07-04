package com.countryside_culture.controller;

import com.countryside_culture.entity.troupe;
import com.countryside_culture.service.troupeService;
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
@RequestMapping("troupe")
public class troupeController {
    @Autowired
    private troupeService troupeservice;
    //    所有剧团
    @RequestMapping(value = "/showall",method = RequestMethod.POST)
    public String showAllTroupe(HttpServletResponse response, Model model) {
        List<troupe> troupe = troupeservice.showall();
        model.addAttribute("troupe", troupe);
        return "yueju_museum_troupe";
    }

    //    剧团具体信息
    @RequestMapping(value = "/selectone",method = RequestMethod.POST)
    public String selectOne(HttpServletResponse response, Model model, HttpServletRequest request) {
        int id=Integer.parseInt(request.getParameter("id"));
        troupe troupe = troupeservice.selectOne(id);
        model.addAttribute("troupe", troupe);
        return "";
    }
}
