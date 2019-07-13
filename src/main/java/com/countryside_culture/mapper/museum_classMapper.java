package com.countryside_culture.mapper;

import com.countryside_culture.entity.museum_class;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface museum_classMapper {
    List<museum_class> selectall();

}