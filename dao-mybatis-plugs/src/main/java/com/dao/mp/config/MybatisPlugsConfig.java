package com.dao.mp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan({"com.weibo.biz.hogwarts.dao.mapper"})
public class MybatisPlugsConfig {
}
