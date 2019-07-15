package com.countryside_culture.mapper;

import com.countryside_culture.entity.video;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface videoMapper {
    public List<video> allhot();
    public List<video> hot(int kind,int amount);
    public List<video> newest(int kind,int amount);
    public List<video> tkind(int kind);
    public List<video> pkind(int kind);
    public video selectone(int id);
    public int update(video video);

}