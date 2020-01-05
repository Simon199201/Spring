package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findAll();

    void saveUserRoleRel(Role role);

    List<Role> findRoleByUserId(Long id);

    void saveUserRoleRel(Long id, Long[] roleIds);

    void delUserRoleRel(Long userId);
}
