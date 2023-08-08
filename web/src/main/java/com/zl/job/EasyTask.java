package com.zl.job;

import com.zl.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Component
public class EasyTask {

    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(cron="1/5 * * * * ?")
    public void send(){

        System.out.println("T1-run ..."+new Date());
        /*String url = "http://10.222.76.204:6006/api/index";
        ApiResponse response = restTemplate.getForObject(url, ApiResponse.class);
        System.out.println("resp "+response);*/
        try {
            Thread.sleep(1000*30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    /*@Scheduled(cron="1/5 * * * * ?")
    public void send2(){

        System.out.println("T2-run ..."+new Date());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }*/

}
