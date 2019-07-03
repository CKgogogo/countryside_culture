package com.countryside_culture;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import com.countryside_culture.util.*;
import org.springframework.web.bind.annotation.RequestMapping;

@MapperScan("com.countryside_culture.mapper") //扫描的mapper
@SpringBootApplication
public class CountrysideCultureApplication {

    public static void main(String[] args) {
//        SpringApplication.run(CountrysideCultureApplication.class, args);
        ApplicationContext applicationContext =
                SpringApplication.run(CountrysideCultureApplication.class, args);
        SpringUtil.setApplicationContext(applicationContext);

    }

}
