package com.market.services;


import com.market.dao.MarketSurveyMapper;
import com.market.entity.MarketSurvey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("SurveyService")
public class SurveyService {

    @Autowired
    private MarketSurveyMapper marketSurveyMapper;

    /**
     * 根据id查询问询
     *
     * @param id
     * @return
     */
    public MarketSurvey selectById(int id) {
        return marketSurveyMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有问卷
     * @return
     */
    public List<MarketSurvey> selectList(MarketSurvey marketSurvey){
        return marketSurveyMapper.selectList(marketSurvey);
    }

    /**
     * 根据id修改问卷
     * @return
     */
    public int updateByPrimaryKeySelective(MarketSurvey marketSurvey){
        return marketSurveyMapper.updateByPrimaryKeySelective(marketSurvey);
    }

    /**
     * 根据主键删除问卷
     * @param surveyId
     * @return
     */
    public int deleteByPrimaryKey(Integer surveyId){
        return marketSurveyMapper.deleteByPrimaryKey(surveyId);
    }

    /**
     * 根据主键删除问卷
     * @param marketSurvey
     * @return
     */
    public int insertSelective(MarketSurvey marketSurvey){
        return marketSurveyMapper.insertSelective(marketSurvey);
    }

}
