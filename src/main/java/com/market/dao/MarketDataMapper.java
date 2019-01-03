package com.market.dao;

import com.market.entity.MarketData;

public interface MarketDataMapper {
    int deleteByPrimaryKey(Integer dataId);

    int insert(MarketData record);

    int insertSelective(MarketData record);

    MarketData selectByPrimaryKey(Integer dataId);

    int updateByPrimaryKeySelective(MarketData record);

    int updateByPrimaryKey(MarketData record);
}