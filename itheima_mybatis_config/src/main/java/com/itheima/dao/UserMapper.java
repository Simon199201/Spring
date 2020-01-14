package com.itheima.dao;

import com.itheima.domain.User1;
import com.itheima.domain.User1;

import java.io.IOException;
import java.util.List;

public interface UserMapper {
    List<User1> findAll() throws IOException;
    User1 findByCondition(User1 user);

    List<User1> findByIds(List<Integer> list);

    void insert(User1 user);
}
