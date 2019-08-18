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
    public List<museum> showfamous(int amount){
        return museummapper.showfamous(amount);
    }
    public List<museum> showtroupe(int amount){
        return museummapper.showtroupe(amount);
    }
    public List<museum> showkind(int kind){
        return museummapper.showkind(kind);
    }
    public museum selectOne(int id){
        return museummapper.selectOne(id);
    }
    public int update(museum museum){return museummapper.update(museum);}
}
