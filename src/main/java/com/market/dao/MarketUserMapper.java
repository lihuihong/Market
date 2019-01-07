package com.market.dao;

import com.market.entity.MarketUser;

public interface MarketUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(MarketUser record);

    int insertSelective(MarketUser record);

    MarketUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(MarketUser record);

    int updateByPrimaryKey(MarketUser record);
}