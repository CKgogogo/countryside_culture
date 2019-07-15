package com.countryside_culture.mapper;

import com.countryside_culture.entity.review;
import org.springframework.stereotype.Repository;

@Repository
public interface reviewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(review record);

    int insertSelective(review record);

    review selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(review record);

    int updateByPrimaryKeyWithBLOBs(review record);

    int updateByPrimaryKey(review record);
}