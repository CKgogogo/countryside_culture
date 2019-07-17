package com.countryside_culture.service;

import com.countryside_culture.entity.focus;
import com.countryside_culture.mapper.focusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class focusService {
    @Autowired
    focusMapper focusmapper;
    public focus select(int uid,int mid){return focusmapper.select(uid,mid);}
    public int update(focus focus){return focusmapper.update(focus);}
    public int insert(focus focus){return focusmapper.insert(focus);}
    public List<focus> showfocus(int uid){return focusmapper.showfocus(uid);}
}
