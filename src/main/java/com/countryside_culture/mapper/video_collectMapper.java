package com.countryside_culture.mapper;

import com.countryside_culture.entity.video_collect;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface video_collectMapper {
    public video_collect select(int uid, int id);
    public int updatecollect(video_collect video_collect);
    public int collect(video_collect video_collect);
    public List<video_collect> showcollect(int uid);
    int deleteByPrimaryKey(Integer id);

    int insertSelective(video_collect record);

    video_collect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(video_collect record);

    int updateByPrimaryKey(video_collect record);
}