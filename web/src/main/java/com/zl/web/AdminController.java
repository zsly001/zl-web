package com.zl.web;

import com.zl.domain.po.adm.User;
import com.zl.dto.UserRequest;
import com.zl.service.UserService;
import com.zl.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/users")
    public ApiResponse<List<User>> getUsers(@RequestParam("ids") String ids){
        List<Integer> idList = Arrays.stream(ids.split(",")).map(Integer::valueOf).collect(Collectors.toList());
        return ApiResponse.ok(userService.getUsers(idList));
    }


    @PostMapping("/user/add")
    public ApiResponse<Integer> saveUser(@RequestBody UserRequest userRequest){
        User user = new User();
        user.setName(userRequest.getName());
        user.setAge(userRequest.getAge());
        user.setEmail(userRequest.getEmail());
        Date ct = new Date();
        user.setCreateAt(ct);
        user.setUpdateAt(new Timestamp(ct.getTime()));
        int id = userService.save(user);
        return ApiResponse.ok(id);
    }

}
