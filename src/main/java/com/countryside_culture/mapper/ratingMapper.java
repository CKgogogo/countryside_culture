package com.countryside_culture.mapper;

import com.countryside_culture.entity.rating;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ratingMapper {
    rating select(@Param("uid")int uid,@Param("vid") int vid);
    int update(rating rating);
    int insert(rating rating);
}