package com.market.dao;

import com.market.entity.MarketPre;

public interface MarketPreMapper {
    int deleteByPrimaryKey(Integer preId);

    int insert(MarketPre record);

    int insertSelective(MarketPre record);

    MarketPre selectByPrimaryKey(Integer preId);

    int updateByPrimaryKeySelective(MarketPre record);

    int updateByPrimaryKey(MarketPre record);
}