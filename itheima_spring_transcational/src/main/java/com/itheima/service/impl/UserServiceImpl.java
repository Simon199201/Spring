package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    public void transaction(int money, String fromUser, String toUser) {
        userDao.out(money, fromUser);
        int num = 1 / 0;
        userDao.in(money, toUser);
    }
}
