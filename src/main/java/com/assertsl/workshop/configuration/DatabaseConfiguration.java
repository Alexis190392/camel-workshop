package com.assertsl.workshop.configuration;

import io.agroal.springframework.boot.AgroalDataSource;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Resource    
    @Autowired
    private DatabaseProperties properties;


    @Bean
    public DataSource dataSource(){
        AgroalDataSource dataSource = new AgroalDataSource();
        dataSource.setDriverClassName(properties.getDriver());
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        
        System.out.println("\n\n\n" + properties.getDriver() 
                + "\n" + properties.getUrl()
                + "\n" + properties.getUsername()
                + "\n" + properties.getPassword()
                +"\n\n\n"
        );
        
        return dataSource;
    }


}
