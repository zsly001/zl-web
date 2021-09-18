package com.zl.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;


@Configuration
//@EnableScheduling
public class BeanConfig {

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate template = new RestTemplate();
        //new RestTemplateBuilder().setConnectTimeout(new Duration())
        return template;
    }

}
