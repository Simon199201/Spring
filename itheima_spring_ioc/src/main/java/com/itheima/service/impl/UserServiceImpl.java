package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service("userService")
@Scope("prototype")
public class UserServiceImpl implements UserService {
    //    @Autowired
//    @Qualifier("userDao")
    @Resource(name = "userDao")
    private UserDao userDao;

    @Value("${jdbc.driver}")
    private String driver;

    public void save() {

        userDao.save();

        System.out.println("driver is " + driver);

    }

    @PostConstruct
    public void init() {
        System.out.println("service对象的初始化方法");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("service对象的销毁方法");

    }
}
