package com.zl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WebApp {

    static {
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase","true");
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApp.class,args);
    }

}
