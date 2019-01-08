package com.market.services;


import com.market.dao.RoleDao;
import com.market.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 * 用户Service层
 */
@Service("RoleServiceImpl")
public class RoleServiceImpl {

    @Autowired
    private RoleDao roleDao;


    public List<Role> list(Role role) {
        return roleDao.list(role);
    }


    public Role findById(Integer id) {
        return roleDao.findById(id);
    }


    public Integer add(Role role) {
        return roleDao.add(role);
    }


    public Integer update(Role role) {
        return roleDao.update(role);
    }

    /*@Override
    public Integer delete(Integer id) {
        return roleDao.delete(id);
    }*/
}
