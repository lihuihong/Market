package com.market.dao;

import com.market.entity.MarketAnswer;

public interface MarketAnswerMapper {
    int deleteByPrimaryKey(Integer answerId);

    int insert(MarketAnswer record);

    int insertSelective(MarketAnswer record);

    MarketAnswer selectByPrimaryKey(Integer answerId);

    int updateByPrimaryKeySelective(MarketAnswer record);

    int updateByPrimaryKey(MarketAnswer record);
}