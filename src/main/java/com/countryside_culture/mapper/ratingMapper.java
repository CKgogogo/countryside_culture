package com.countryside_culture.mapper;

import com.countryside_culture.entity.rating;
import org.springframework.stereotype.Repository;

@Repository
public interface ratingMapper {
    rating select(int uid,int vid);
    int update(rating rating);
    int insert(rating rating);
}