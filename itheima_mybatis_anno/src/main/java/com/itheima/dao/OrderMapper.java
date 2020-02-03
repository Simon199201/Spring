package com.itheima.dao;

import com.itheima.domain.Order;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface OrderMapper {
    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "total", column = "total"),
            @Result(property = "ordertime", column = "ordertime"),
            @Result(property = "user",column = "uid",javaType = User.class,one = @One(select = "com.itheima.dao.UserMapper.findUserById"))
    })
    Order findOrdersById(int id);
}
