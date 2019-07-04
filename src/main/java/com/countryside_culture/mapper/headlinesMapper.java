package com.countryside_culture.mapper;

import com.countryside_culture.entity.headlines;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface headlinesMapper {
    public List<headlines> show();

    int deleteByPrimaryKey(Integer id);

    int insert(headlines record);

    int insertSelective(headlines record);

    headlines selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(headlines record);

    int updateByPrimaryKeyWithBLOBs(headlines record);

    int updateByPrimaryKey(headlines record);
}