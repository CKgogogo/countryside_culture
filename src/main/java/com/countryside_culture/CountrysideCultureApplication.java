package com.countryside_culture;

import com.countryside_culture.util.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@MapperScan("com.countryside_culture.mapper") //扫描的mapper
@EnableCaching  //开启缓存功能，为redis服务。
@RestController
@SpringBootApplication
public class CountrysideCultureApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
//        SpringApplication.run(CountrysideCultureApplication.class, args);
        ApplicationContext applicationContext =
                SpringApplication.run(CountrysideCultureApplication.class, args);
        SpringUtil.setApplicationContext(applicationContext);

    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CountrysideCultureApplication.class);
    }


}
