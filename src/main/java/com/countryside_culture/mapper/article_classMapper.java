
package com.countryside_culture.mapper;

import com.countryside_culture.entity.article_class;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface article_classMapper {
    List<article_class> selectmuseum();

}