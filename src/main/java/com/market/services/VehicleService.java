package com.market.services;


import com.market.dao.MarketVehicleMapper;
import com.market.entity.MarketVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("VehicleService")
public class VehicleService {

    @Autowired
    private MarketVehicleMapper marketVehicleMapper;

    /**
     * 根据id查询问询
     *
     * @param id
     * @return
     */
    public MarketVehicle selectById(int id) {
        return marketVehicleMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有问卷
     * @return
     */
    public List<MarketVehicle> selectList(MarketVehicle marketVehicle){
        return marketVehicleMapper.selectList(marketVehicle);
    }

    /**
     * 根据id修改问卷
     * @return
     */
    public int updateByPrimaryKeySelective(MarketVehicle marketVehicle){
        return marketVehicleMapper.updateByPrimaryKeySelective(marketVehicle);
    }

    /**
     * 根据主键删除问卷
     * @param surveyId
     * @return
     */
    public int deleteByPrimaryKey(Integer surveyId){
        return marketVehicleMapper.deleteByPrimaryKey(surveyId);
    }

    /**
     * 根据主键删除问卷
     * @param marketVehicle
     * @return
     */
    public int insertSelective(MarketVehicle marketVehicle){
        return marketVehicleMapper.insertSelective(marketVehicle);
    }

}
