package com.zl.web;

import com.zl.vo.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobleAdvice {

    private static final Logger log = LoggerFactory.getLogger(GlobleAdvice.class);

    @ExceptionHandler
    public ApiResponse exception(Exception e){
        log.error("{}",e.getMessage(),e);
        return ApiResponse.error(e.getMessage());
    }

    @ExceptionHandler
    public ApiResponse nullPointerException(NullPointerException e){
        log.error("{}",e.getMessage(),e);
        return ApiResponse.error("空");
    }

}
