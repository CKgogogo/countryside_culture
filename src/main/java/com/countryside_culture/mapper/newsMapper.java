package com.countryside_culture.mapper;

import com.countryside_culture.entity.news;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface newsMapper {
    public List<news> show(int amount);
    public List<news> showall();
    public news selectOne(int id);
    public int update(news news);
}