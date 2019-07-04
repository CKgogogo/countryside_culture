package com.countryside_culture.service;

import com.countryside_culture.entity.news;
import com.countryside_culture.mapper.newsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class newsService {
    @Autowired
    newsMapper newsmapper;
    public List<news> show(){
        return newsmapper.show();
    }

    public List<news> showall(){
        return newsmapper.showall();
    }

    public news selectOne(int id){
        return newsmapper.selectOne(id);
    }
}
