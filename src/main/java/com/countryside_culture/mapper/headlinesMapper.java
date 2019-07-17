package com.countryside_culture.mapper;

import com.countryside_culture.entity.headlines;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface headlinesMapper {
    public  List<headlines> show(int amount);
    public headlines selectid(int id);
    int deleteByPrimaryKey(Integer id);

    int insert(headlines record);

    int updateByPrimaryKey(headlines record);
}