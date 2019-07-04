package com.countryside_culture.mapper;


import com.countryside_culture.entity.news;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface newsMapper {
    public List<news> show();
    public List<news> showall();
    public news selectOne(int id);
    int deleteByPrimaryKey(Integer id);

    int insert(news record);

    int insertSelective(news record);

    int updateByPrimaryKeySelective(news record);

    int updateByPrimaryKeyWithBLOBs(news record);

    int updateByPrimaryKey(news record);
}