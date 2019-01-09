package com.market.services;


import com.market.dao.MarketAnswerMapper;
import com.market.dao.MarketQuestionMapper;
import com.market.entity.MarketAnswer;
import com.market.entity.MarketQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AnswerService")
public class AnswerService {

    @Autowired
    private MarketAnswerMapper marketAnswerMapper;

    /**
     * 根据id查询问询
     *
     * @param id
     * @return
     */
    public MarketAnswer selectById(int id) {
        return marketAnswerMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有题目
     *
     * @param marketAnswer
     * @return
     */
    public List<MarketAnswer> selectList(MarketAnswer marketAnswer) {
        return marketAnswerMapper.selectList(marketAnswer);
    }


    /**
     * 根据id修改问卷
     * @return
     */
    public int updateByPrimaryKeySelective(MarketAnswer marketAnswer){
        return marketAnswerMapper.updateByPrimaryKeySelective(marketAnswer);
    }

    /**
     * 根据主键删除问卷
     * @param surveyId
     * @return
     */
    public int deleteByPrimaryKey(Integer surveyId){
        return marketAnswerMapper.deleteByPrimaryKey(surveyId);
    }

    /**
     * 根据主键删除问卷
     * @param marketAnswer
     * @return
     */
    public int insertSelective(MarketAnswer marketAnswer){
        return marketAnswerMapper.insertSelective(marketAnswer);
    }

}
