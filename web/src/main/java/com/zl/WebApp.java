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
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");
        System.setProperty("com.sun.jndi.cosnaming.object.trustURLCodebase","true");
        //System.setProperty("java.rmi.server.useCodebaseOnly","false");
        //System.setProperty("java.rmi.server.hostname","10.222.100.241");
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApp.class,args);
    }

}
