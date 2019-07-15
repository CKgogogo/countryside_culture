package com.countryside_culture.controller;

import com.countryside_culture.service.reviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("review")
public class reviewController {
    @Autowired
    private reviewService reviewservice;


}
