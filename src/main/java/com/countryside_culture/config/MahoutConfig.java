package com.countryside_culture.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Configuration
public class MahoutConfig {

    private MysqlDataSource getDataSource(){
        MysqlDataSource dataSource=new MysqlDataSource();
        dataSource.setServerName("120.79.217.195");
        dataSource.setUser("root");
        dataSource.setPassword("feng1.");
        dataSource.setDatabaseName("countryside_culture");
        return dataSource;
    }

    @Bean(autowire = Autowire.BY_NAME,value = "mySQLDataModel")
    public DataModel getMySQLJDBCDataModel(){
        DataModel dataModel=new MySQLJDBCDataModel(getDataSource(),"rating","user_id","item_id","rating", "rate_time");
        return dataModel;
    }

    /*
    @Bean(autowire = Autowire.BY_NAME,value = "fileDataModel")
    public DataModel getDataModel() throws IOException {
        URL url=MahoutConfig.class.getClassLoader().getResource("mahout/ratings-1m.data");
        DataModel dataModel = new FileDataModel(new File(url.getFile()));
        return dataModel;
    }*/
}
