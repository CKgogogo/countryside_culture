package com.countryside_culture.mapper;

import com.countryside_culture.entity.userlike;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface userlikeMapper {
    public userlike selectlike(@Param("uid") int uid, @Param("rid") int rid);
    public int insert(userlike userlike);
    public int update(userlike userlike);

}