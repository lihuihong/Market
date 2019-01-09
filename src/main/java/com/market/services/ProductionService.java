package com.market.services;


import com.market.dao.MarketConfigureMapper;
import com.market.dao.MarketProductionMapper;
import com.market.entity.MarketConfigure;
import com.market.entity.MarketProduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductionService")
public class ProductionService {

    @Autowired
    private MarketProductionMapper marketProductionMapper;

    /**
     * 根据id查询问询
     *
     * @param id
     * @return
     */
    public MarketProduction selectById(int id) {
        return marketProductionMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有问卷
     * @return
     */
    public List<MarketProduction> selectList(MarketProduction marketProduction){
        return marketProductionMapper.selectList(marketProduction);
    }

    /**
     * 根据id修改问卷
     * @return
     */
    public int updateByPrimaryKeySelective(MarketProduction marketProduction){
        return marketProductionMapper.updateByPrimaryKeySelective(marketProduction);
    }

    /**
     * 根据主键删除问卷
     * @param surveyId
     * @return
     */
    public int deleteByPrimaryKey(Integer surveyId){
        return marketProductionMapper.deleteByPrimaryKey(surveyId);
    }

    /**
     * 根据主键删除问卷
     * @param marketProduction
     * @return
     */
    public int insertSelective(MarketProduction marketProduction){
        return marketProductionMapper.insertSelective(marketProduction);
    }

}
