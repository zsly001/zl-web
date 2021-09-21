package com.zl.dao.mb.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AdminDbConfig {

    @Bean
    @ConfigurationProperties(prefix = "db.ds.adm")
    public DataSource admDataSource(){
        DataSourceBuilder.create().build();
        return null;
    }

}
