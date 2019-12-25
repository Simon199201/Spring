package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void out(int money, String fromUser) {
        String sql = "update account set money=money-? where username = ? ";
        jdbcTemplate.update(sql, money, fromUser);
    }

    public void in(int money, String toUser) {
        String sql = "update account set money=money+? where username = ? ";
        jdbcTemplate.update(sql, money, toUser);
    }
}
