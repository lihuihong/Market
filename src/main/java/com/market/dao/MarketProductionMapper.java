package com.market.dao;

import com.market.entity.MarketProduction;

import java.util.List;

public interface MarketProductionMapper {
    int deleteByPrimaryKey(Integer productionId);

    int insert(MarketProduction record);

    int insertSelective(MarketProduction record);

    MarketProduction selectByPrimaryKey(Integer productionId);

    List<MarketProduction> selectList(MarketProduction marketProduction);

    int updateByPrimaryKeySelective(MarketProduction record);

    int updateByPrimaryKey(MarketProduction record);
}