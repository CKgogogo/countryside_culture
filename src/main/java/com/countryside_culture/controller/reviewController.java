package com.countryside_culture.controller;

import com.countryside_culture.entity.review;
import com.countryside_culture.entity.userlike;
import com.countryside_culture.service.reviewService;
import com.zlzkj.core.util.Fn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin(origins = "*",maxAge = 3600,allowCredentials = "true",allowedHeaders = "*")
@RequestMapping("review")
public class reviewController {
    @Autowired
    private reviewService reviewservice;

    //显示该视频对应的评论
    @RequestMapping("/show")
    public String showReview(HttpServletResponse response, HttpServletRequest request,int id){
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
        Fn.ajaxReturn(response,ans);
        return "";
    }

    //取消或点赞评论
    @ResponseBody
    @RequestMapping("/like")
    public String Like(HttpServletRequest request,int id,int status,int likenum){
        if(request.getSession().getAttribute("user_id")==null)
            return "no";
        int uid=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
        userlike userlike=reviewservice.selectlike(uid,id);
        review review=reviewservice.selectid(id);
        review.setLikeNum(likenum);
        reviewservice.updater(review);
        if (userlike==null){
            userlike ans=new userlike();
            ans.setRid(id);
            ans.setUid(uid);
            ans.setStatus(status);
            reviewservice.insertl(ans);
        }else{
            userlike.setStatus(status);
            reviewservice.updatel(userlike);
        }
        return "ok";
    }

    //删除评论
    @ResponseBody
    @RequestMapping("/delete")
    public String Delete(int id){
        review review=reviewservice.selectid(id);
        if (review.getPid()==0){
            int pid=review.getId();
            List<review> ans=reviewservice.selectpid(pid);
            for (int i=0;i<ans.size();i++){
                ans.get(i).setStatus(0);
                reviewservice.updater(ans.get(i));
            }
        }
        review.setStatus(0);
        reviewservice.updater(review);
        return "ok";
    }

    //发表评论
    @ResponseBody
    @RequestMapping("/publish")
    public String Publish(HttpServletRequest request,int vid){
        if(request.getSession().getAttribute("user_id")==null)
            return "no";
        int uid=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
        String picture=request.getSession().getAttribute("picture").toString();
        String plname=request.getSession().getAttribute("nickname").toString();
        String content=request.getParameter("content");
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        review ans=new review();
        ans.setLikeNum(0);
        ans.setStatus(1);
        ans.setPid(0);
        ans.setUid(uid);
        ans.setContent(content);
        ans.setPicture(picture);
        ans.setPlname(plname);
        ans.setVid(vid);
        ans.setTime(sdf.format(d));
        reviewservice.insertr(ans);
        return "ok";
    }

    //回复评论
    @ResponseBody
    @RequestMapping("/reply")
    public String Reply(HttpServletRequest request,int id) {
        if (request.getSession().getAttribute("user_id") == null)
            return "no";
        int uid = Integer.parseInt(request.getSession().getAttribute("user_id").toString());
        String picture=request.getSession().getAttribute("picture").toString();
        String plname=request.getSession().getAttribute("nickname").toString();
        String content=request.getParameter("content");
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        review review=reviewservice.selectid(id);
        int pid;
        if (review.getPid()==0){
            pid=review.getId();
        }else {
            pid=review.getPid();
        }
        review ans=new review();
        ans.setLikeNum(0);
        ans.setStatus(1);
        ans.setPid(pid);
        ans.setUid(uid);
        ans.setContent(content);
        ans.setPicture(picture);
        ans.setRname(review.getPlname());
        ans.setPlname(plname);
        ans.setVid(review.getVid());
        ans.setTime(sdf.format(d));
        reviewservice.insertr(ans);
        return "ok";
    }

}
