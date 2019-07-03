package com.countryside_culture.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class test {

    @RequestMapping("/")
    public String helloworld(Model model, HttpServletRequest request) {
        return "index";
    }
}
