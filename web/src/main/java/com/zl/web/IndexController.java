package com.zl.web;

import com.zl.vo.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/index")
public class IndexController {


    @GetMapping
    public ApiResponse<String> index(){
        return ApiResponse.ok();
    }

}
