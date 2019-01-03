package com.market.dao;

import com.market.entity.MarketConfigure;

public interface MarketConfigureMapper {
    int deleteByPrimaryKey(Integer configureId);

    int insert(MarketConfigure record);

    int insertSelective(MarketConfigure record);

    MarketConfigure selectByPrimaryKey(Integer configureId);

    int updateByPrimaryKeySelective(MarketConfigure record);

    int updateByPrimaryKey(MarketConfigure record);
}