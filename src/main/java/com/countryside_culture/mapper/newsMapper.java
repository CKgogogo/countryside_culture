package com.countryside_culture.mapper;


import com.countryside_culture.entity.news;

public interface newsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(news record);

    int insertSelective(news record);

    news selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(news record);

    int updateByPrimaryKeyWithBLOBs(news record);

    int updateByPrimaryKey(news record);
}