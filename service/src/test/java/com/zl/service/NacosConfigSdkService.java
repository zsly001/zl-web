package com.zl.service;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.zl.domain.util.Util;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class NacosConfigSdkService {

    public static String serverAddr = "http://127.0.0.1:8848";
    public static String dataId = "test.demo1";
    public static String group = "DEFAULT_GROUP";
    public static Properties properties = new Properties();
    static {
        properties.put("serverAddr", serverAddr);
        properties.put("username","nacos");
        properties.put("password","nacos");
    }


    public static void syncConfig(){
        try {
            ConfigService configService = NacosFactory.createConfigService(properties);
            for(int i=0;i<100;i++){
                String content = configService.getConfig(dataId, group, 5000);
                System.out.println(content);
                System.out.println("================");
                Util.sleep(1);
            }

        } catch (NacosException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void listener(){
        try {
            ConfigService configService = NacosFactory.createConfigService(properties);
            configService.addListener(dataId, group, new Listener() {
                @Override
                public Executor getExecutor() {
                    return null;
                }

                @Override
                public void receiveConfigInfo(String configInfo) {
                    System.out.println("configInfo: " + configInfo);
                }
            });
        } catch (NacosException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        CountDownLatch latch = new CountDownLatch(1);
        try {
            latch.await(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {


        syncConfig();
        //listener();

    }

}
