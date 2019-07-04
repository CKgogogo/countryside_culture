package com.countryside_culture.service;

import com.countryside_culture.entity.userinfo;
import com.countryside_culture.mapper.userinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userinfoService {
    @Autowired
    userinfoMapper userinfomapper;
    public int checkLogin(userinfo userinfo){
        return userinfomapper.checkLogin(userinfo);
    }

    public int register(userinfo userinfo){
        return userinfomapper.register(userinfo);
    }
}
