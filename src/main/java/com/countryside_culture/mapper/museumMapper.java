package com.countryside_culture.mapper;

import com.countryside_culture.entity.museum;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface museumMapper {
    public List<museum> showfamous(int amount);
    public List<museum> showtroupe(int amount);
    public List<museum> showkind(int kind);
    public museum selectOne(int id);



}