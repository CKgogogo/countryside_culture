package com.countryside_culture.mapper;

import com.countryside_culture.entity.museum;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface museumMapper {
    public List<museum> show();
    int deleteByPrimaryKey(Integer id);

    int insert(museum record);

    int insertSelective(museum record);

    museum selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(museum record);

    int updateByPrimaryKeyWithBLOBs(museum record);

    int updateByPrimaryKey(museum record);
}