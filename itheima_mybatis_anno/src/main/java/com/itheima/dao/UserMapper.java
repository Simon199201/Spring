package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Insert("insert into user values(#{id},#{username},#{password},#{birthday})")
    void insert(User user);

    @Delete("delete from user where id = #{id}")
    void delete(int id);

    @Update("update user set username = #{username} where id = #{id}")
    void update(User user);

    @Select("select * from user")
    @Results({
        @Result(property = "id",column = "id",id = true),
        @Result(property = "username",column = "username"),
        @Result(property = "password",column = "password"),
        @Result(property = "birthday",column = "birthday"),
        @Result(property = "orderList",column = "id",javaType = List.class,many = @Many(select = "com.itheima.dao.OrderMapper.findOrdersById"))
    })
    List<User> findAllUser();

    @Select("select * from user where id = #{id}")
    User findUserById(int id);
}
