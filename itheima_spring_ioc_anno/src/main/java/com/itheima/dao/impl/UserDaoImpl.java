package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    @Qualifier("dataSource")
    private DataSource mDataSource;

    public void save() {
        System.out.println("save ...");
        try {
            System.out.println(mDataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
