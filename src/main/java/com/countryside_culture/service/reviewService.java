package com.countryside_culture.service;

import com.countryside_culture.mapper.reviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class reviewService {
    @Autowired
    reviewMapper reviewmapper;
}
