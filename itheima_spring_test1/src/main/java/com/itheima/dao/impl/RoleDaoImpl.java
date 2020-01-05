package com.itheima.dao.impl;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RoleDaoImpl implements RoleDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Role> findAll() {
        String sql = "select * from sys_role";
        List<Role> roleList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    public void saveUserRoleRel(Role role) {
        String sql = "insert into sys_role values (?,?,?)";
        jdbcTemplate.update(sql, null, role.getRoleName(), role.getRoleDesc());
    }

    public List<Role> findRoleByUserId(Long id) {
        String sql = "select * from sys_user_role su,sys_role r where su.`roleId` = r.id and su.`userId` = ?";
        List<Role> roles = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Role>(Role.class), id);
        return roles;
    }

    public void saveUserRoleRel(Long id, Long[] roleIds) {
        String sql = "insert into sys_user_role values(?,?)";
        for (Long roleId :
                roleIds) {
            jdbcTemplate.update(sql, id, roleId);
        }

    }

    public void delUserRoleRel(Long userId) {
        String sql = "delete from sys_user_role where userId = ?";
        jdbcTemplate.update(sql, userId);
    }
}
