package com.market.dao;

import com.market.entity.MarketPlaying;

public interface MarketPlayingMapper {
    int deleteByPrimaryKey(Integer playingId);

    int insert(MarketPlaying record);

    int insertSelective(MarketPlaying record);

    MarketPlaying selectByPrimaryKey(Integer playingId);

    int updateByPrimaryKeySelective(MarketPlaying record);

    int updateByPrimaryKey(MarketPlaying record);
}