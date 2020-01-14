package com.itheima.dao;

import com.itheima.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper {
    List<User> findAll() throws IOException;
    User findByCondition(User user);

    List<User> findByIds(List<Integer> list);
}
