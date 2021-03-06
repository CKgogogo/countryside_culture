package com.countryside_culture.service;

import com.countryside_culture.entity.userinfo;
import com.countryside_culture.mapper.userinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userinfoService {
    @Autowired
    userinfoMapper userinfomapper;
    public userinfo checkLogin(String username,String password){
        return userinfomapper.checkLogin(username,password);
    }
    public userinfo select(int id){return userinfomapper.select(id);}
    public List<userinfo> all(String nickname){return userinfomapper.all(nickname);}
    public int register(userinfo userinfo){
        return userinfomapper.register(userinfo);
    }
    public int update(userinfo userinfo){return userinfomapper.update(userinfo);}
}
