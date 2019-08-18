package com.countryside_culture.service;

import com.countryside_culture.entity.review;
import com.countryside_culture.entity.userlike;
import com.countryside_culture.mapper.reviewMapper;
import com.countryside_culture.mapper.userlikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reviewService {
    @Autowired
    reviewMapper reviewmapper;
    @Autowired
    userlikeMapper userlikemapper;

    public review selectid(int id){return reviewmapper.selectid(id);}
    public List<review> selectvid(int vid){return reviewmapper.selectvid(vid);}
    public List<review> selectpid(int pid){return reviewmapper.selectpid(pid);}
    public List<review> all(){return reviewmapper.all();}
    public int updater(review review){return reviewmapper.update(review);}
    public int insertr(review review){return reviewmapper.insert(review);}


    public int updatel(userlike userlike){return userlikemapper.update(userlike);}
    public int insertl(userlike userlike){return userlikemapper.insert(userlike);}
    public userlike selectlike(int uid,int rid){return userlikemapper.selectlike(uid,rid);}
}
