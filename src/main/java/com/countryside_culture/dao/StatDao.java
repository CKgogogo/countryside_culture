package com.countryside_culture.dao;

import com.countryside_culture.entity.Guest;
import com.countryside_culture.entity.userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/6/16.
 */
@Repository
public class StatDao {
    @Autowired
    RedisTemplate redisTemplate;
    public void pushOnlineUser(userinfo userEntity){
        redisTemplate.opsForSet().add("OnlineUser",userEntity);
    }
    public void popOnlineUser(userinfo userEntity){
        redisTemplate.opsForSet().remove("OnlineUser" ,userEntity);
    }
    public Set getAllUserOnline(){
        return redisTemplate.opsForSet().members("OnlineUser");
    }
    public void pushGuestHistory(Guest guest){
        //最多存储指定个数的访客
        if (redisTemplate.opsForList().size("Guest") == 2000l){
            redisTemplate.opsForList().rightPop("Guest");
        }
        redisTemplate.opsForList().leftPush("Guest",guest);
    }
    public List getGuestHistory(){
        return redisTemplate.opsForList().range("Guest",0,-1);
    }
}