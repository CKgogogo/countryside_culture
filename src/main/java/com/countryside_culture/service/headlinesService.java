package com.countryside_culture.service;

import com.countryside_culture.entity.headlines;
import com.countryside_culture.mapper.headlinesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class headlinesService {
    @Autowired
    headlinesMapper headlinesmapper;
    public List<headlines> show(int amount){
        return headlinesmapper.show(amount);
    }
    public headlines selectid(int id){return headlinesmapper.selectid(id);}
}
