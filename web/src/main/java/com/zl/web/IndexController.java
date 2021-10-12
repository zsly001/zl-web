package com.zl.web;

import com.zl.vo.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/index")
public class IndexController {


    @GetMapping
    public ApiResponse<String> index(){
        System.out.println("request "+new Date());
        return ApiResponse.ok();
    }




}
