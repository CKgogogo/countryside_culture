package com.countryside_culture.mapper;

import com.countryside_culture.entity.video;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface videoMapper {
    public List<video> allhot();

    public List<video> hot(@Param("kind") int kind, @Param("amount") int amount);

    public List<video> newest(@Param("kind") int kind, @Param("amount") int amount);

    public List<video> tkind(int kind);

    public List<video> pkind(int kind);

    public List<video> selectall();

    public video selectone(int id);

    public int update(video video);


    List<video> queryProductsBySql(Integer userid);

    List<video> queryProductsByIds(List ids);

}