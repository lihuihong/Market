package com.market.dao;

import com.market.entity.MarketConfigure;

import java.util.List;

public interface MarketConfigureMapper {

    int deleteByPrimaryKey(Integer configureId);

    int insert(MarketConfigure record);

    int insertSelective(MarketConfigure record);

    MarketConfigure selectByPrimaryKey(Integer configureId);

    MarketConfigure selectByVehicleId(Integer vehicleId);

    List<MarketConfigure> selectList(MarketConfigure marketConfigure);

    int updateByPrimaryKeySelective(MarketConfigure record);

    int updateByPrimaryKey(MarketConfigure record);
}