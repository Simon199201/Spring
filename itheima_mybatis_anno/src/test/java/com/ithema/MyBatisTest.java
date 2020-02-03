package com.ithema;

import com.itheima.dao.OrderMapper;
import com.itheima.dao.UserMapper;
import com.itheima.domain.Order;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatisTest {
    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);

    }
    @Test
    public void test1(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(0);
        user.setPassword("123");
        user.setUsername("simon");
        user.setBirthday(new Date());
        userMapper.insert(user);
    }

    @Test
    public void test2(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.delete(4);
    }
    @Test
    public void test3(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(2);
        user.setUsername("update");
        userMapper.update(user);
    }

    @Test
    public void test4(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(2);
        user.setUsername("update");
        List<User> allUser = userMapper.findAllUser();
        for (User item : allUser) {
            System.out.println(item);
        }
    }
    @Test
    public void test5(){
        //one
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order ordersById = orderMapper.findOrdersById(1);
        System.out.println(ordersById);
    }

    @Test
    public void test6(){
        //many
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = userMapper.findAllUser();
        for (User item : allUser) {
            System.out.println(item);
        }
    }
}
