package com.countryside_culture.controller;

import com.countryside_culture.entity.troupe;
import com.countryside_culture.service.troupeService;
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
import java.util.Map;

@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("troupe")
public class troupeController {
    @Autowired
    private troupeService troupeservice;
    //    所有剧团
    @RequestMapping(value = "/showall",method = RequestMethod.POST)
    public String showAllTroupe(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,HttpServletResponse response, Model model) {
        PageHelper.startPage(pn,6);//第pn页，6条记录
        List<troupe> troupe = troupeservice.showall();
//        model.addAttribute("troupe", troupe);
        PageInfo pageInfo = new PageInfo<>(troupe,5);
        Fn.ajaxReturn(response,pageInfo);
        return "";
    }

    //    剧团具体信息
    @RequestMapping(value = "/selectone",method = RequestMethod.POST)
    public String selectOne(HttpServletResponse response, Model model, HttpServletRequest request) {
        int id=Integer.parseInt(request.getParameter("id"));
        troupe troupe = troupeservice.selectOne(id);
        model.addAttribute("troupe", troupe);
        Fn.ajaxReturn(response,troupe);
        return "";
    }
}
