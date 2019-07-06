package com.countryside_culture.mapper;

import com.countryside_culture.entity.museum_class;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface museum_classMapper {
    List<museum_class> selectall();
    int deleteByPrimaryKey(Integer id);

    int insert(museum_class record);

    int insertSelective(museum_class record);

    museum_class selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(museum_class record);

    int updateByPrimaryKey(museum_class record);
}