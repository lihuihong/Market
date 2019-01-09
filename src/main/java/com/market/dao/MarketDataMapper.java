package com.market.dao;

import com.market.entity.MarketData;

import java.util.List;

public interface MarketDataMapper {
    int deleteByPrimaryKey(Integer dataId);

    int insert(MarketData record);

    int insertSelective(MarketData record);

    MarketData selectByPrimaryKey(Integer dataId);

    MarketData selectByVehicleId(Integer vehicleId);

    List<MarketData> selectList(MarketData marketData);

    int updateByPrimaryKeySelective(MarketData record);

    int updateByPrimaryKey(MarketData record);
}