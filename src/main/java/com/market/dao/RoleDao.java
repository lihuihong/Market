package com.market.dao;


import com.fjy.costume.entity.Role;

import java.util.List;

/**
 * @author 冯健芸
 * @create 2018-01-02 02:18
 * @name
 */
public interface RoleDao {

    public Role findById(Integer id);

    public List<Role> list(Role role);

    public Integer add(Role role);

    public Integer update(Role role);
}
