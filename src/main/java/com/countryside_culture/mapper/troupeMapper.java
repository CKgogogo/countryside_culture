package com.countryside_culture.mapper;

import com.countryside_culture.entity.troupe;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface troupeMapper {
    public List<troupe> show();
    public List<troupe> showall();
    public troupe selectOne(int id);
    int deleteByPrimaryKey(Integer troupeId);

}