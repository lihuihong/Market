package com.market.dao;

import com.market.entity.MarketSurvey;

import java.util.List;

public interface MarketSurveyMapper {

    int deleteByPrimaryKey(Integer surveyId);

    int insert(MarketSurvey record);

    int insertSelective(MarketSurvey record);

    MarketSurvey selectByPrimaryKey(Integer surveyId);

    List<MarketSurvey> selectList(MarketSurvey marketSurvey);

    int updateByPrimaryKeySelective(MarketSurvey record);

    int updateByPrimaryKey(MarketSurvey record);
}