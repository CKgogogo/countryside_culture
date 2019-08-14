package com.countryside_culture.mapper;

import com.countryside_culture.entity.focus;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface focusMapper {
    public focus select(@Param("uid") int uid, @Param("mid")int mid);
    public int update(focus focus);
    public int insert(focus focus);
    public List<focus> showfocus(int uid);
    int deleteByPrimaryKey(Integer id);

    int insertSelective(focus record);

    focus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(focus record);

    int updateByPrimaryKey(focus record);
}