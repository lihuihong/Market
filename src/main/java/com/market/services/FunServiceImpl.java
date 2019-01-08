package com.market.services;


import com.fjy.costume.dao.FunDao;
import com.fjy.costume.entity.Fun;
import com.fjy.costume.service.FunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 冯健芸
 * @create 2018-01-03 15:18
 */

/**
 * 用户Service层
 */
@Service
public class FunServiceImpl{

    @Autowired
    private FunDao funDao;

    @Override
    public List<Fun> list() {
        return funDao.list();
    }


}
