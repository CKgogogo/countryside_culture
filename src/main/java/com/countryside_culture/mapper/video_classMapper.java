package com.countryside_culture.mapper;

import com.countryside_culture.entity.video_class;
import org.springframework.stereotype.Repository;

@Repository
public interface video_classMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(video_class record);

    int insertSelective(video_class record);

    video_class selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(video_class record);

    int updateByPrimaryKey(video_class record);
}