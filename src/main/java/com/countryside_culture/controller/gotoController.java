package com.countryside_culture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String gotologin(String url, Model model){
        model.addAttribute("url",url);
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
    @RequestMapping("historicalSite")
    public String gotohistoricalSite(){
        return "historicalSite";
    }
    @RequestMapping("scenery")
    public String gotoscenery(){
        return "scenery";
    }
    @RequestMapping("famousPeopleDetails4")
    public String gotofamousPeopleDetails4(){
        return "famousPeopleDetails4";
    }
    @RequestMapping("famousPeopleDetails3")
    public String gotofamousPeopleDetails3(){
        return "famousPeopleDetails3";
    }
    @RequestMapping("famousPeopleDetails2")
    public String gotofamousPeopleDetails2(){
        return "famousPeopleDetails2";
    }
    @RequestMapping("famousPeopleDetails1")
    public String gotofamousPeopleDetails1(){
        return "famousPeopleDetails1";
    }
    @RequestMapping("deliciousFood")
    public String gotodeliciousFood(){
        return "deliciousFood";
    }
    @RequestMapping("mapDemo")
    public String gotomapDemo(){
        return "mapDemo";
    }
    @RequestMapping("townIntroduce1")
    public String gototownIntroduce1(){
        return "townIntroduce1";
    }
    @RequestMapping("townIntroduce2")
    public String gototownIntroduce2(){
        return "townIntroduce2";
    }
    @RequestMapping("townIntroduce3")
    public String gototownIntroduce3(){
        return "townIntroduce3";
    }
    @RequestMapping("townIntroduce4")
    public String gototownIntroduce4(){
        return "townIntroduce4";
    }
    @RequestMapping("townIntroduce5")
    public String gototownIntroduce5(){
        return "townIntroduce5";
    }
    @RequestMapping("townIntroduce6")
    public String gototownIntroduce6(){
        return "townIntroduce6";
    }

}
