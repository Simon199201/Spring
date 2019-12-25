package com.itheima.dao;

public interface UserDao {
    void out(int money, String fromUser);

    void in(int money, String toUser);
}
