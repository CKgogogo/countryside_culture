package com.countryside_culture.mapper;

import com.countryside_culture.entity.userinfo;
import org.springframework.stereotype.Repository;

@Repository
public interface userinfoMapper {
    public userinfo checkLogin(String username,String password);
    public int register(userinfo userinfo);
    public int update(userinfo userinfo);

}