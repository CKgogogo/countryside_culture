package com.countryside_culture.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.countryside_culture.entity.*;
import com.countryside_culture.service.*;
import com.countryside_culture.util.RedisUtil;
import com.countryside_culture.util.SpringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlzkj.core.util.Fn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins = "*",maxAge = 3600,allowCredentials = "true",allowedHeaders = "*")
@RequestMapping("video")
public class videoControlle {
    @Autowired
    private videoService videoservice;
    @Autowired
    private museumService museumservice;
    @Autowired
    private focusService focusservice;
    @Autowired
    private reviewService reviewservice;

    //所有视频中热门的6个
    @RequestMapping("/allhot")
    public String showAllhot(HttpServletResponse response){
        List<video> video = videoservice.allhot();
        Fn.ajaxReturn(response,video);
        return "";
    }

    //各个种类最新的视频
    @RequestMapping("/newest")
    public String showNewest(HttpServletResponse response,int kind
            ,@RequestParam(required = false,defaultValue = "10",value = "amount")Integer amount){
        List<video> video = videoservice.newest(kind,amount);
        Fn.ajaxReturn(response,video);
        return "";
    }

    //各个种类播放量高的视频
    @RequestMapping("/hot")
    public String showHot(HttpServletResponse response,int kind
            ,@RequestParam(required = false,defaultValue = "5",value = "amount")Integer amount){
        List<video> video = videoservice.hot(kind,amount);
        Fn.ajaxReturn(response,video);
        return "";
    }

    //各个种类所有视频  按时间排序
    @RequestMapping("/tkind")
    public String showTkind(HttpServletResponse response, int kind,
                            @RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,
                            @RequestParam(required = false,defaultValue = "8",value = "pagesize")Integer pagesize){
        PageHelper.startPage(pn,pagesize);//第pn页，每页pagesize记录
        List<video> video = videoservice.tkind(kind);
        PageInfo pageInfo = new PageInfo<>(video,5);
        Fn.ajaxReturn(response,pageInfo);
        return "";
    }

    //各个种类所有视频  按播放量排序
    @RequestMapping("/pkind")
    public String showPkind(HttpServletResponse response, int kind,
                            @RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,
                            @RequestParam(required = false,defaultValue = "8",value = "pagesize")Integer pagesize){
        PageHelper.startPage(pn,pagesize);//第pn页，每页pagesize记录
        List<video> video = videoservice.pkind(kind);
        PageInfo pageInfo = new PageInfo<>(video,5);
        Fn.ajaxReturn(response,pageInfo);
        return "";
    }
    //某个视频
    @RequestMapping(value ="/selectone",method = RequestMethod.GET)
    public String showSelectone(HttpServletResponse response, HttpServletRequest request, int id, Model model) throws ParseException {
        video video = videoservice.selectone(id);
        video.setPlayNum(video.getPlayNum()+1);
        if(request.getSession().getAttribute("user_id")!=null){
            int uid=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
            video_collect ans=videoservice.select(uid,id);
            if(ans!=null) {
                video.setIs_collect(ans.getStatus());
            }
        }
        Date d = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        video.setHistorytime(simpleDateFormat.format(d));
        if(request.getSession().getAttribute("user_id")!=null){
            String readhistoryValue = null;
            RedisUtil redisUtil = null;
            history readhistory=null;
            redisUtil = (RedisUtil) SpringUtil.applicationContext.getBean("redisUtil");//从spring容器里面得到一个对象
            readhistoryValue = redisUtil.get(request.getSession().getAttribute("user_id").toString());
            if (readhistoryValue==null){
                readhistory=new history();
                readhistory.addItem(video);
            }else {
                    readhistory = JSON.parseObject(readhistoryValue, new TypeReference<history>() {});
                    for (int i=readhistory.getItems().size()-1;i>=0;i--){
                    Date date =simpleDateFormat.parse(readhistory.getItems().get(i).getHistorytime());
                    if (d.getTime()-date.getTime()>86400000) {
                        readhistory.addItem(video);
                        break;
                    }else {
                        if (video.getId()==readhistory.getItems().get(i).getId()){
                            break;
                        }else {
                            readhistory.addItem(video);
                            break;
                        }
                    }
                }
            }
            //序列化成字符串。
            String fromObject = JSON.toJSONString(readhistory);
            redisUtil.set(request.getSession().getAttribute("user_id").toString(), fromObject.toString());
        }
        videoservice.update(video);
        List<video> video2 = videoservice.allhot();

        //显示所有评论
        List<review> ans=reviewservice.selectvid(id);
        if (request.getSession().getAttribute("user_id")!=null){
            int uid=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
            for (int i=0;i<ans.size();i++){
                if (uid==ans.get(i).getUid())
                    ans.get(i).setIs_delete(1);
                userlike userlike=reviewservice.selectlike(uid,ans.get(i).getId());
                if (userlike!=null)
                    ans.get(i).setIs_like(userlike.getStatus());
                //评论子内容的是否点赞删除处理
                int pid=ans.get(i).getId();
                List<review> reviewList=reviewservice.selectpid(pid);
                for (int j=0;j<reviewList.size();j++){
                    if (uid==reviewList.get(j).getUid())
                        reviewList.get(j).setIs_delete(1);
                    userlike userlike2=reviewservice.selectlike(uid,reviewList.get(j).getId());
                    if (userlike!=null)
                        reviewList.get(j).setIs_like(userlike2.getStatus());
                }
                ans.get(i).setList(reviewList);
            }
        }else{
            for (int i=0;i<ans.size();i++){
                int pid=ans.get(i).getId();
                List<review> reviewList=reviewservice.selectpid(pid);
                ans.get(i).setList(reviewList);
            }
        }
        model.addAttribute("review",ans);
        model.addAttribute("video2",video2);
        model.addAttribute("video",video);
//        Fn.ajaxReturn(response,video);
        return "videoPlay";
    }
    //某个视频 返回json格式
    @RequestMapping(value ="/selectone2")
    public String showSelectone2(HttpServletResponse response, HttpServletRequest request, int id) throws ParseException {
        video video = videoservice.selectone(id);
        video.setPlayNum(video.getPlayNum()+1);
        if(request.getSession().getAttribute("user_id")!=null){
            int uid=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
            video_collect ans=videoservice.select(uid,id);
            if(ans!=null) {
                video.setIs_collect(ans.getStatus());
            }
        }
        Date d = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        video.setHistorytime(simpleDateFormat.format(d));
        if(request.getSession().getAttribute("user_id")!=null){
            String readhistoryValue = null;
            RedisUtil redisUtil = null;
            history readhistory=null;
            redisUtil = (RedisUtil) SpringUtil.applicationContext.getBean("redisUtil");//从spring容器里面得到一个对象
            readhistoryValue = redisUtil.get(request.getSession().getAttribute("user_id").toString());
            if (readhistoryValue==null){
                readhistory=new history();
                readhistory.addItem(video);
            }else {
                readhistory = JSON.parseObject(readhistoryValue, new TypeReference<history>() {});
                for (int i=readhistory.getItems().size()-1;i>=0;i--){
                    Date date =simpleDateFormat.parse(readhistory.getItems().get(i).getHistorytime());
                    if (d.getTime()-date.getTime()>86400000) {
                        readhistory.addItem(video);
                        break;
                    }else {
                        if (video.getId()==readhistory.getItems().get(i).getId()){
                            break;
                        }else {
                            readhistory.addItem(video);
                            break;
                        }
                    }
                }
            }
            //序列化成字符串。
            String fromObject = JSON.toJSONString(readhistory);
            redisUtil.set(request.getSession().getAttribute("user_id").toString(), fromObject.toString());
        }
        videoservice.update(video);
        Fn.ajaxReturn(response,video);
        return "";
    }

    //收藏或取消收藏视频
    @ResponseBody
    @RequestMapping("/collect")
    public String showCollect(HttpServletRequest request, int id, int status){
        if(request.getSession().getAttribute("user_id")==null)
            return "no";
        int uid=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
        video_collect a=videoservice.select(uid,id);
        if(a!=null){
            a.setStatus(status);
            videoservice.updatecollect(a);
        }else{
            video video=videoservice.selectone(id);
            video_collect ans=new video_collect();
            ans.setVid(id);
            ans.setUid(uid);
            ans.setStatus(status);
            ans.setCollectNum(video.getCollectNum());
            ans.setPicture(video.getPicture());
            ans.setPlayNum(video.getPlayNum());
            ans.setTitle(video.getTitle());
            ans.setUrl(video.getUrl());
            videoservice.collect(ans);
        }
        return "ok";
    }

    //显示视频演员表
    @RequestMapping("/actor")
    public String showActor(HttpServletRequest request,HttpServletResponse response,String actor){
        String[] a=request.getParameter("actor").split("-");
        List<museum> museums=new ArrayList<>();
        for(int i=0;i<a.length;i++){
          museum ans=museumservice.selectOne(Integer.parseInt(a[i]));
          if(request.getSession().getAttribute("user_id")!=null){
              int uid=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
              focus focus=focusservice.select(uid,Integer.parseInt(a[i]));
              if(focus!=null){
                  ans.setIs_focus(focus.getStatus());
              }
          }
          museums.add(ans);
        }
        Fn.ajaxReturn(response,museums);
        return "";
    }

    //关注或取消关注演员
    @ResponseBody
    @RequestMapping("/focus")
    public String Focus(HttpServletRequest request,int id,int status){
        if(request.getSession().getAttribute("user_id")==null)
            return "no";
        int uid=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
        focus a=focusservice.select(uid,id);
        if (a!=null){
            a.setStatus(status);
            focusservice.update(a);
        }else {
            museum museum=museumservice.selectOne(id);
            focus ans=new focus();
            ans.setStatus(status);
            ans.setMid(id);
            ans.setUid(uid);
            ans.setName(museum.getTitle());
            ans.setNum(museum.getNum());
            ans.setPicture(museum.getPicture());
            ans.setRemark(museum.getRemark());
            focusservice.insert(ans);
        }
        return "ok";
    }

    //显示某个演员参演的所有视频
    @RequestMapping("/actorplay")
    public String showAllFocus(int id, Map<String,Object> map, Model model
            , @RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn
            , @RequestParam(required = false,defaultValue = "8",value = "pagesize")Integer pagesize){
        List<video> videos=videoservice.selectall();
//        PageHelper.startPage(pn,pagesize);//第pn页，每页pagesize记录
        List<video> ans=new ArrayList<>();
        for (int i=0;i<videos.size();i++){
            String[] actor=videos.get(i).getActor().split("-");
            for (int j=0;j<actor.length;j++){
                if (id==Integer.parseInt(actor[j])) {
                    ans.add(videos.get(i));
                }
            }
        }

//        PageInfo pageInfo = new PageInfo<>(ans,5);
        model.addAttribute("video",ans);
//        map.put("pageInfo",pageInfo);

        museum actor=museumservice.selectOne(id);
        model.addAttribute("actor",actor);
        return "famousPeopleView";
    }


}
