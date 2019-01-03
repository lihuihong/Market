package com.market.dao;

import com.market.entity.MarketVehicle;

public interface MarketVehicleMapper {
    int deleteByPrimaryKey(Integer vehicleId);

    int insert(MarketVehicle record);

    int insertSelective(MarketVehicle record);

    MarketVehicle selectByPrimaryKey(Integer vehicleId);

    int updateByPrimaryKeySelective(MarketVehicle record);

    int updateByPrimaryKey(MarketVehicle record);
}