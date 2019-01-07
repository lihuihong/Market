package com.market.services;


import com.market.dao.UserDao;
import com.market.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 冯健芸
 * @create 2018-01-02 11:18
 */

/**
 * 用户Service层
 */
@Service
public class UserServiceImpl{

    @Autowired
    private UserDao userDao;


    public User login(User user) {
        return userDao.login(user);
    }


    public List<User> list(User user) {
        return userDao.list(user);
    }


    public Long getTotal(Map<String, Object> map) {
        return userDao.getTotal(map);
    }


    public Integer add(User user) {
        return userDao.add(user);
    }


    public Integer update(User user) {
        return userDao.update(user);
    }


    public Integer delete(Integer id) {
        return userDao.delete(id);
    }
}
