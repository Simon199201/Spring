package com.itheima.service.impl;

import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private RoleDao roleDao;


    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> list() {
        List<User> userList = userDao.findAll();
        for (User u : userList) {
            Long id = u.getId();
            List<Role> roles = roleDao.findRoleByUserId(id);
            u.setRoles(roles);
        }
        return userList;
    }

    public void save(User user, Long[] roleIds) {
        Long userId = userDao.save(user);
        roleDao.saveUserRoleRel(userId,roleIds);
    }

    public void del(Long userId) {
        //1.删除sys_user_role 关系表
        roleDao.delUserRoleRel(userId);
        //2.删除sys_user表
        userDao.delUser(userId);

    }
}
