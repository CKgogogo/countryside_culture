package com.countryside_culture.service;

import com.countryside_culture.entity.type;
import com.countryside_culture.mapper.typeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class typeService {
    @Autowired
    typeMapper typemapper;
    public type selectname(String name){return typemapper.selectname(name);}
    public List<type> selectpid(int pid){return typemapper.selectpid(pid);}
    public type selectid(int id){return typemapper.selectid(id);}
}
