package com.market.services;


import com.market.dao.FunDao;
import com.market.entity.Fun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 用户Service层
 */
@Service("FunServiceImpl")
public class FunServiceImpl{

    @Autowired
    private FunDao funDao;

    public List<Fun> list() {
        return funDao.list();
    }


}
