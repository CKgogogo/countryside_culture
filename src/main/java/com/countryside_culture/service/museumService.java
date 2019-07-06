package com.countryside_culture.service;

import com.countryside_culture.entity.museum;
import com.countryside_culture.mapper.museumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class museumService {
    @Autowired
    museumMapper museummapper;
    public List<museum> showfamous(){
        return museummapper.showfamous();
    }
    public List<museum> showtroupe(){
        return museummapper.showtroupe();
    }
    public List<museum> showkind(int kind){
        return museummapper.showkind(kind);
    }
    public museum selectOne(int id){
        return museummapper.selectOne(id);
    }
}
