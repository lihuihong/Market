package com.market.dao;

import com.market.entity.MarketVehicle;

import java.util.List;

public interface MarketVehicleMapper {
    int deleteByPrimaryKey(Integer vehicleId);

    int insert(MarketVehicle record);

    int insertSelective(MarketVehicle record);

    MarketVehicle selectByPrimaryKey(Integer vehicleId);

    List<MarketVehicle> selectList(MarketVehicle marketVehicle);

    int updateByPrimaryKeySelective(MarketVehicle record);

    int updateByPrimaryKey(MarketVehicle record);
}