package com.countryside_culture.controller;


import com.countryside_culture.entity.focus;
import com.countryside_culture.entity.museum;
import com.countryside_culture.entity.video;
import com.countryside_culture.entity.video_collect;
import com.countryside_culture.service.focusService;
import com.countryside_culture.service.museumService;
import com.countryside_culture.service.videoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlzkj.core.util.Fn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("video")
public class videoControlle {
    @Autowired
    private videoService videoservice;
    @Autowired
    private museumService museumservice;
    @Autowired
    private focusService focusservice;
    //������Ƶ�����ŵ�6��
    @RequestMapping("/allhot")
    public String showAllhot(HttpServletResponse response){
        List<video> video = videoservice.allhot();
        Fn.ajaxReturn(response,video);
        return "";
    }

    //�����������µ���Ƶ
    @RequestMapping("/newest")
    public String showNewest(HttpServletResponse response,int kind
            ,@RequestParam(required = false,defaultValue = "10",value = "amount")Integer amount){
        List<video> video = videoservice.newest(kind,amount);
        Fn.ajaxReturn(response,video);
        return "";
    }

    //�������ಥ�����ߵ���Ƶ
    @RequestMapping("/hot")
    public String showHot(HttpServletResponse response,int kind
            ,@RequestParam(required = false,defaultValue = "5",value = "amount")Integer amount){
        List<video> video = videoservice.hot(kind,amount);
        Fn.ajaxReturn(response,video);
        return "";
    }

    //��������������Ƶ  ��ʱ������
    @RequestMapping("/tkind")
    public String showTkind(HttpServletResponse response, int kind,
                            @RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,
                            @RequestParam(required = false,defaultValue = "8",value = "pagesize")Integer pagesize){
        PageHelper.startPage(pn,pagesize);//��pnҳ��ÿҳpagesize��¼
        List<video> video = videoservice.tkind(kind);
        PageInfo pageInfo = new PageInfo<>(video,5);
        Fn.ajaxReturn(response,pageInfo);
        return "";
    }

    //��������������Ƶ  ������������
    @RequestMapping("/pkind")
    public String showPkind(HttpServletResponse response, int kind,
                            @RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,
                            @RequestParam(required = false,defaultValue = "8",value = "pagesize")Integer pagesize){
        PageHelper.startPage(pn,pagesize);//��pnҳ��ÿҳpagesize��¼
        List<video> video = videoservice.pkind(kind);
        PageInfo pageInfo = new PageInfo<>(video,5);
        Fn.ajaxReturn(response,pageInfo);
        return "";
    }

    //ĳ����Ƶ
    @RequestMapping("/selectone")
    public String showSelectone(HttpServletResponse response,HttpServletRequest request,int id){
        video video = videoservice.selectone(id);
        video.setPlayNum(video.getPlayNum()+1);
        if(request.getSession().getAttribute("user_id")!=null){
            int uid=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
            video_collect ans=videoservice.select(uid,id);
            if(ans!=null) {
                video.setIs_collect(ans.getStatus());
            }
        }
        videoservice.update(video);
        Fn.ajaxReturn(response,video);
        return "";
    }

    //�ղ���Ƶ
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
            ans.setPictue(video.getPicture());
            ans.setPlayNum(video.getPlayNum());
            ans.setTitle(video.getTitle());
            ans.setUrl(video.getUrl());
            videoservice.collect(ans);
        }
        return "ok";
    }

    //�鿴��ǰ�û������ղ���Ƶ
    @RequestMapping("/showcollect")
    public String showAllCollect(HttpServletRequest request,HttpServletResponse response
            ,@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn
            ,@RequestParam(required = false,defaultValue = "8",value = "pagesize")Integer pagesize){
        int uid=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
        PageHelper.startPage(pn,pagesize);//��pnҳ��ÿҳpagesize��¼
        List<video_collect> video_collect=videoservice.showcollect(uid);
        PageInfo pageInfo = new PageInfo<>(video_collect,5);
        Fn.ajaxReturn(response,pageInfo);
        return "";
    }

    //��ʾ��Ƶ��Ա��
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

    //��ע��Ա
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


}
