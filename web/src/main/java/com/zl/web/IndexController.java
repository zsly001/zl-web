package com.zl.web;

import com.zl.vo.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/index")
public class IndexController {


    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @GetMapping
    public ApiResponse<String> index(){
        System.out.println("request "+new Date());
        return ApiResponse.ok();
    }

    @GetMapping("/foo")
    public ApiResponse<String> foo(@RequestParam("value") String value){

        log.info("{}",value);
        return ApiResponse.ok();
    }


}
