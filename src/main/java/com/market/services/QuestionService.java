package com.market.services;


import com.market.dao.MarketQuestionMapper;
import com.market.dao.MarketSurveyMapper;
import com.market.entity.MarketQuestion;
import com.market.entity.MarketSurvey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("QuestionService")
public class QuestionService {

    @Autowired
    private MarketQuestionMapper marketQuestionMapper;

    /**
     * 根据id查询问询
     *
     * @param id
     * @return
     */
    public MarketQuestion selectById(int id) {
        return marketQuestionMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据id查询问询
     *
     * @param id
     * @return
     */
    public List<MarketQuestion> findBySurveyId(int id) {
        return marketQuestionMapper.findBySurveyId(id);
    }

    /**
     * 查询所有题目
     *
     * @param marketQuestion
     * @return
     */
    public List<MarketQuestion> selectList(MarketQuestion marketQuestion) {
        return marketQuestionMapper.selectList(marketQuestion);
    }


    /**
     * 根据id修改问卷
     * @return
     */
    public int updateByPrimaryKeySelective(MarketQuestion marketQuestion){
        return marketQuestionMapper.updateByPrimaryKeySelective(marketQuestion);
    }

    /**
     * 根据主键删除问卷
     * @param surveyId
     * @return
     */
    public int deleteByPrimaryKey(Integer surveyId){
        return marketQuestionMapper.deleteByPrimaryKey(surveyId);
    }

    /**
     * 根据主键删除问卷
     * @param marketQuestion
     * @return
     */
    public int insertSelective(MarketQuestion marketQuestion){
        return marketQuestionMapper.insertSelective(marketQuestion);
    }

}
