package com.countryside_culture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class gotoController {
    @RequestMapping("index")
    public String gotoindex(){
        return "index";
    }
    @RequestMapping("live")
    public String gotolive(){
        return "live";
    }
    @RequestMapping("famousPeople")
    public String gotofamousPeople(){
        return "famousPeople";
    }
    @RequestMapping("yueJuTown")
    public String gotoyueJuTown(){
        return "yueJuTown";
    }
    @RequestMapping("costume")
    public String gotocostume(){
        return "costume";
    }
    @RequestMapping("prop")
    public String gotoprop(){
        return "prop";
    }
    @RequestMapping("culture")
    public String gotoculture(){
        return "culture";
    }
    @RequestMapping("login")
    public String gotologin(){
        return "login";
    }
    @RequestMapping("famousPeopleGame")
    public String gotofamousPeople1Game(){
        return "famousPeopleGame";
    }
    @RequestMapping("video")
    public String gotovideo(){
        return "video";
    }

}
