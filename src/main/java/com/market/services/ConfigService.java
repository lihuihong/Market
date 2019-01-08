package com.market.services;


import com.market.dao.MarketConfigureMapper;
import com.market.entity.MarketConfigure;
import com.market.entity.MarketData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ConfigService")
public class ConfigService {

    @Autowired
    private MarketConfigureMapper marketConfigureMapper;

    /**
     * 根据id查询问询
     *
     * @param id
     * @return
     */
    public MarketConfigure selectById(int id) {
        return marketConfigureMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有问卷
     * @return
     */
    public List<MarketConfigure> selectList(MarketConfigure marketConfig){
        return marketConfigureMapper.selectList(marketConfig);
    }

    /**
     * 根据id修改问卷
     * @return
     */
    public int updateByPrimaryKeySelective(MarketConfigure marketConfig){
        return marketConfigureMapper.updateByPrimaryKeySelective(marketConfig);
    }

    /**
     * 根据主键删除问卷
     * @param surveyId
     * @return
     */
    public int deleteByPrimaryKey(Integer surveyId){
        return marketConfigureMapper.deleteByPrimaryKey(surveyId);
    }

    /**
     * 根据主键删除问卷
     * @param marketConfig
     * @return
     */
    public int insertSelective(MarketConfigure marketConfig){
        return marketConfigureMapper.insertSelective(marketConfig);
    }

}
