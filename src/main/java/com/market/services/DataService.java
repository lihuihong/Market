package com.market.services;


import com.market.dao.MarketDataMapper;
import com.market.dao.MarketVehicleMapper;
import com.market.entity.MarketData;
import com.market.entity.MarketVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DataService")
public class DataService {

    @Autowired
    private MarketDataMapper marketDataMapper;

    /**
     * 根据id查询问询
     *
     * @param id
     * @return
     */
    public MarketData selectById(int id) {
        return marketDataMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据id查询问询
     *
     * @param id
     * @return
     */
    public MarketData selectByVehicleId(int id) {
        return marketDataMapper.selectByVehicleId(id);
    }

    /**
     * 查询所有问卷
     * @return
     */
    public List<MarketData> selectList(MarketData marketData){
        return marketDataMapper.selectList(marketData);
    }

    /**
     * 根据id修改问卷
     * @return
     */
    public int updateByPrimaryKeySelective(MarketData marketData){
        return marketDataMapper.updateByPrimaryKeySelective(marketData);
    }

    /**
     * 根据主键删除问卷
     * @param surveyId
     * @return
     */
    public int deleteByPrimaryKey(Integer surveyId){
        return marketDataMapper.deleteByPrimaryKey(surveyId);
    }

    /**
     * 根据主键删除问卷
     * @param marketData
     * @return
     */
    public int insertSelective(MarketData marketData){
        return marketDataMapper.insertSelective(marketData);
    }

}
