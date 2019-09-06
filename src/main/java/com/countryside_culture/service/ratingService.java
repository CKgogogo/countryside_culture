package com.countryside_culture.service;

import com.countryside_culture.entity.rating;
import com.countryside_culture.mapper.ratingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ratingService {
    @Autowired
    private ratingMapper ratingmapper;

    public rating select(int uid,int vid){return ratingmapper.select(uid, vid);}
    public int update(rating rating){return ratingmapper.update(rating);}
    public int insert(rating rating){return ratingmapper.insert(rating);}
}
