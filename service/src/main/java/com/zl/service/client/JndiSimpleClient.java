package com.zl.service.client;

import javax.naming.Context;
import javax.naming.InitialContext;

public class JndiSimpleClient {

    static {
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase","true");
    }


    public static void main(String[] args) throws Exception{
        Context context = new InitialContext();
        Object obj = context.lookup("rmi://127.0.0.1:1099/exec");
        System.out.println(obj);
    }

}
