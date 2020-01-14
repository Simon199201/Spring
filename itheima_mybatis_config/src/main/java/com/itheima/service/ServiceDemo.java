package com.itheima.service;

import com.itheima.dao.UserMapper;
import com.itheima.domain.User1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceDemo {
    public static void main(String[] args) throws IOException {
        //创建dao层对象 当前dao层的实现是手动创建的
        //mybatis mapper
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = factory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //动态sql
//        User user = new User();
//        user.setId(5);
//        user.setUsername("tianqi");
//        user.setPassword("123");
//        User result = mapper.findByCondition(user);

//        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//        List<User> result = mapper.findByIds(list);
//        System.out.println(result);

        //typehandlers
        User1 user = new User1();
        user.setBirthday(new Date());
        user.setUsername("simon");
        user.setPassword("123");
        mapper.insert(user);

        List<Integer> list = new ArrayList<Integer>();
        list.add(8);
        List<User1> user1List = mapper.findByIds(list);
        System.out.println(user1List);
    }
}
