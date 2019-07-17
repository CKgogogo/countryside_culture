package com.countryside_culture.mapper;

import com.countryside_culture.entity.type;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface typeMapper {
    public type selectname(String name);
    public List<type> selectpid(int pid);
    public type selectid(int id);
    int deleteByPrimaryKey(Integer id);

    int insert(type record);

    int insertSelective(type record);

    int updateByPrimaryKeySelective(type record);

    int updateByPrimaryKey(type record);
}