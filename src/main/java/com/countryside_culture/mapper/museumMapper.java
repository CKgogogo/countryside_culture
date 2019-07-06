package com.countryside_culture.mapper;

import com.countryside_culture.entity.museum;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface museumMapper {
    public List<museum> showfamous();
    public List<museum> showtroupe();
    public List<museum> showkind(int kind);
    public museum selectOne(int id);
    int deleteByPrimaryKey(Integer id);

    int insert(museum record);

    int insertSelective(museum record);

    int updateByPrimaryKeySelective(museum record);

    int updateByPrimaryKeyWithBLOBs(museum record);

    int updateByPrimaryKey(museum record);
}