package com.countryside_culture.controller;


import com.countryside_culture.service.userinfoService;
import com.countryside_culture.service.videoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/mahout")
public class VideoRecommenderController {
    final private int RECOMMENDER_NUM = 10;    //推荐结果个数
    @Autowired
    private videoService productService;


    @RequestMapping(value = "/recommend")
    public ModelAndView recommendlist(@RequestParam(value = "userid", defaultValue = "1") int userID, ModelAndView mv) {
        List productsRBU=productService.recommendProductsBasedUser(userID, RECOMMENDER_NUM);
        // List productsRBI=productService.recommendProductsBasedItem(userID, RECOMMENDER_NUM);
        List lookedProducts=productService.queryLookedProductsByUser(userID);
        mv.setViewName("/recommendlist");
        mv.addObject("lookedProducts",lookedProducts);
        //mv.addObject("productsRBU",productsRBU);
        mv.addObject("productsRBU",productsRBU);
        return mv;
    }


}
