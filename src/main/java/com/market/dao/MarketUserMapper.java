package com.market.dao;

import com.market.entity.MarketUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MarketUserMapper {
    /**
     * 根据主键删除用户信息
     * @param userId
     * @return
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * 插入用户信息
     * @param MarketUser
     * @return
     */
    int insert(MarketUser MarketUser);

    int insertSelective(MarketUser record);

    /**
     * 根据主键查询用户信息
     * @param userId
     * @return
     */
    MarketUser selectByPrimaryKey(Integer userId);

    /**
     * 根据用户id修改用户信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MarketUser record);

    int updateByPrimaryKey(MarketUser record);
    /**
     * 校验用户
     * @param userName 登录名
     * @param passWord 登录密码
     * @return
     */
    MarketUser checkUser(@Param("userName") String userName, @Param("passWord") String passWord);
    /**
     * 根据旧密码，判断查询用户
     * @param password
     * @return
     */
    MarketUser selectByPassword(@Param("password") String password, @Param("id")int id);

    /**
     * 根据用户id查询信息
     * @param id
     * @return
     */
    MarketUser selectById(int id);

    List<MarketUser> selectAllMarketUser();

}