package com.zl.web;

import com.zl.vo.ApiResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobleAdvice {

    @ExceptionHandler
    public ApiResponse exception(Exception e){
        return ApiResponse.error(e.getMessage());
    }

    @ExceptionHandler
    public ApiResponse nullPointerExceprion(NullPointerException e){
        return ApiResponse.error("空");
    }

}
