package com.zl.service;

import com.zl.domain.po.adm.User;

import java.util.List;

public interface UserService {

    User getUser(Integer id);

    List<User> getUsers(List<Integer> ids);

    int save(User user);
}
