package com.itheima.factory;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;

public class DynamicFactoryBean {
    public UserDao createUserDao(){
        return new UserDaoImpl();
    }
}
