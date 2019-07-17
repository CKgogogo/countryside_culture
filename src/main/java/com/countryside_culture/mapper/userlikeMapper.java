package com.countryside_culture.mapper;

import com.countryside_culture.entity.userlike;
import org.springframework.stereotype.Repository;

@Repository
public interface userlikeMapper {
    public userlike selectlike(int uid,int rid);
    public int insert(userlike userlike);
    public int update(userlike userlike);

}