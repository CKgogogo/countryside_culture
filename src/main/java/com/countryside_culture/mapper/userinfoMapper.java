package com.countryside_culture.mapper;

import com.countryside_culture.entity.userinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface userinfoMapper {
    public userinfo checkLogin(@Param("username") String username,@Param("password") String password);
    public int register(userinfo userinfo);
    public int update(userinfo userinfo);
    public userinfo select(int id);
}