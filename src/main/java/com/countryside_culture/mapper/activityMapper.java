package com.countryside_culture.mapper;

import com.countryside_culture.entity.activity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface activityMapper {
    public activity selectid(int id);
    public List<activity> showall();
    public List<activity> showhot();
    public List<activity> showdoing(String status);
    int update(activity record);
}