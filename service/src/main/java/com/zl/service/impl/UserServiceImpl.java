package com.zl.service.impl;

import com.zl.dao.mb.adm.UserDao;
import com.zl.domain.po.adm.User;
import com.zl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(Integer id) {

        return userDao.getUser(id);
    }
}
