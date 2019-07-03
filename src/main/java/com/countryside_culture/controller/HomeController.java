package com.countryside_culture.controller;

import com.countryside_culture.entity.museum;
import com.countryside_culture.mapper.museumMapper;
import com.countryside_culture.service.museumService;
import com.zlzkj.core.util.Fn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.text.AttributedString;
import java.util.List;

@Controller
@RequestMapping("home")
public class HomeController {
    @Autowired
    private museumService museumservice;

    @RequestMapping(value = "/museum",method = RequestMethod.POST)
    public String showMuseum(HttpServletResponse response, Model model) {
        List<museum> museum = museumservice.show();
        model.addAttribute("museum", museum);
        return "index";
    }
}