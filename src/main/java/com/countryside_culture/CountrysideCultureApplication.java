package com.countryside_culture;

import com.countryside_culture.util.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@MapperScan("com.countryside_culture.mapper") //扫描的mapper
@SpringBootApplication
public class CountrysideCultureApplication {

    public static void main(String[] args) {
//        SpringApplication.run(CountrysideCultureApplication.class, args);
        ApplicationContext applicationContext =
                SpringApplication.run(CountrysideCultureApplication.class, args);
        SpringUtil.setApplicationContext(applicationContext);

    }
    @Configuration
    public class EncodingFilterConfig {
        @Bean
        public FilterRegistrationBean filterRegistrationBean() {
            FilterRegistrationBean registrationBean = new FilterRegistrationBean();
            CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
            characterEncodingFilter.setForceEncoding(true);
            characterEncodingFilter.setEncoding("UTF-8");
            registrationBean.setFilter(characterEncodingFilter);
            return registrationBean;
        }
    }


}
