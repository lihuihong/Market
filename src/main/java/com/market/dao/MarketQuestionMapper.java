package com.market.dao;

import com.market.entity.MarketQuestion;

public interface MarketQuestionMapper {
    int deleteByPrimaryKey(Integer questionId);

    int insert(MarketQuestion record);

    int insertSelective(MarketQuestion record);

    MarketQuestion selectByPrimaryKey(Integer questionId);

    int updateByPrimaryKeySelective(MarketQuestion record);

    int updateByPrimaryKey(MarketQuestion record);
}