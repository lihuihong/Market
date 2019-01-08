package com.market.services;


import com.fjy.costume.dao.RoleDao;
import com.fjy.costume.entity.Role;
import com.fjy.costume.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 冯健芸
 * @create 2018-01-02 11:18
 */

/**
 * 用户Service层
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> list(Role role) {
        return roleDao.list(role);
    }

    @Override
    public Role findById(Integer id) {
        return roleDao.findById(id);
    }

    @Override
    public Integer add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public Integer update(Role role) {
        return roleDao.update(role);
    }

    /*@Override
    public Integer delete(Integer id) {
        return roleDao.delete(id);
    }*/
}
