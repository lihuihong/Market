package com.market.dao;

import com.market.entity.MarketProduction;

public interface MarketProductionMapper {
    int deleteByPrimaryKey(Integer productionId);

    int insert(MarketProduction record);

    int insertSelective(MarketProduction record);

    MarketProduction selectByPrimaryKey(Integer productionId);

    int updateByPrimaryKeySelective(MarketProduction record);

    int updateByPrimaryKey(MarketProduction record);
}