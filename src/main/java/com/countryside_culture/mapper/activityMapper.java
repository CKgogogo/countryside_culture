package com.countryside_culture.mapper;

import com.countryside_culture.entity.activity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface activityMapper {
    public activity selectid(int id);
    public List<activity> showall();
    int deleteByPrimaryKey(Integer id);

    int insert(activity record);

    int insertSelective(activity record);

    int updateByPrimaryKeySelective(activity record);

    int updateByPrimaryKeyWithBLOBs(activity record);

    int updateByPrimaryKey(activity record);
}