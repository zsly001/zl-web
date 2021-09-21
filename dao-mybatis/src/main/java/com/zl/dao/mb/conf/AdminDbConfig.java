package com.zl.dao.mb.conf;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties({MybatisProperties.class})
@MapperScan(basePackages = "com.zl.dao.mb.adm",sqlSessionFactoryRef = "admSqlSessionFactory")
public class AdminDbConfig {

    @Autowired
    private MybatisProperties properties;

    @Bean
    @ConfigurationProperties(prefix = "db.ds.adm")
    public DataSource admDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory admSqlSessionFactory(@Qualifier("admDataSource") DataSource ds) throws Exception{

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds);
        factoryBean.setConfiguration(properties.getConfiguration());
        return factoryBean.getObject();
    }
}
