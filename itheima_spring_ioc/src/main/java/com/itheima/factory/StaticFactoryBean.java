package com.itheima.factory;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;

public class StaticFactoryBean {
    public static UserDao createUserDao(){
        return new UserDaoImpl();
    }
}
