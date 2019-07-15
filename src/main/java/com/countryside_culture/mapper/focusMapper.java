package com.countryside_culture.mapper;

import com.countryside_culture.entity.focus;
import org.springframework.stereotype.Repository;

@Repository
public interface focusMapper {
    public focus select(int uid,int mid);
    public int update(focus focus);
    public int insert(focus focus);
    int deleteByPrimaryKey(Integer id);

    int insertSelective(focus record);

    focus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(focus record);

    int updateByPrimaryKey(focus record);
}