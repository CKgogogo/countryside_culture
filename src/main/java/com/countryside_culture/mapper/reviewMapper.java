package com.countryside_culture.mapper;

import com.countryside_culture.entity.review;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface reviewMapper {
    public List<review> selectvid(int vid);
    public List<review> selectpid(int pid);
    public List<review> all();
    public review selectid(int id);
    public int update(review review);
    public int insert(review review);

}