package com.countryside_culture.service;

import com.countryside_culture.entity.troupe;
import com.countryside_culture.mapper.troupeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class troupeService {
    @Autowired
    troupeMapper troupemapper;
    public List<troupe> show(){
        return troupemapper.show();
    }
    public List<troupe> showall(){
        return troupemapper.showall();
    }
    public troupe selectOne(int id){
        return troupemapper.selectOne(id);
    }
}
