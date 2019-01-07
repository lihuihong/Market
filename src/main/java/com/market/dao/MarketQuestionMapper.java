package com.market.dao;

import com.market.entity.MarketQuestion;

import java.util.List;

public interface MarketQuestionMapper {
    int deleteByPrimaryKey(Integer questionId);

    int insert(MarketQuestion record);

    int insertSelective(MarketQuestion record);

    MarketQuestion selectByPrimaryKey(Integer questionId);

    List<MarketQuestion> selectList(MarketQuestion marketQuestion);

    int updateByPrimaryKeySelective(MarketQuestion record);

    int updateByPrimaryKey(MarketQuestion record);
}