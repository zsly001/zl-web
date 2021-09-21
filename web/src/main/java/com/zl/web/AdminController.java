package com.zl.web;

import com.zl.domain.po.adm.User;
import com.zl.service.UserService;
import com.zl.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adm")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ApiResponse<User> getUser(@PathVariable("id") Integer id){

        User user = userService.getUser(id);
        return ApiResponse.ok(user);

    }

}
