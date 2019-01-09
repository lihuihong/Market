package com.market.dao;

import com.market.entity.MarketAnswer;

import java.util.List;

public interface MarketAnswerMapper {
    int deleteByPrimaryKey(Integer answerId);

    int insert(MarketAnswer record);

    int insertSelective(MarketAnswer record);

    MarketAnswer selectByPrimaryKey(Integer answerId);

    List<MarketAnswer> selectList(MarketAnswer marketAnswer);

    int updateByPrimaryKeySelective(MarketAnswer record);

    int updateByPrimaryKey(MarketAnswer record);
}