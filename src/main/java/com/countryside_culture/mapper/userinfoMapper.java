package com.countryside_culture.mapper;

import com.countryside_culture.entity.userinfo;
import org.springframework.stereotype.Repository;

@Repository
public interface userinfoMapper {
    public int checkLogin(userinfo userinfo);
    public int register(userinfo userinfo);
    int deleteByPrimaryKey(Integer userId);

    int insert(userinfo record);

    int insertSelective(userinfo record);

    userinfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(userinfo record);

    int updateByPrimaryKey(userinfo record);
}