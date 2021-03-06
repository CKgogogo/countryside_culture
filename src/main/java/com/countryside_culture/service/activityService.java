package com.countryside_culture.service;

import com.countryside_culture.entity.activity;
import com.countryside_culture.mapper.activityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class activityService {
    @Autowired
    activityMapper activitymapper;

    public activity selectid(int id){return activitymapper.selectid(id);}
    public List<activity> showall(){return activitymapper.showall();}
    public List<activity> showhot(){return activitymapper.showhot();}
    public List<activity> showdoing(String status){return activitymapper.showdoing(status);}
    public int update(activity activity){return activitymapper.update(activity);}
}
