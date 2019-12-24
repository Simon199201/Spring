package com.itheima;

import com.itheima.config.SpringConfiguration;
import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class UserDaoDemo {
    public static void main(String[] args) throws SQLException {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        UserService userService = app.getBean(UserService.class);
//        userService.save();
        DataSource dataSource = (DataSource) app.getBean("dataSource");
        System.out.println(dataSource.getConnection());

        ApplicationContext app1 = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object userDao1 = app1.getBean("userDao1");
    }
}
