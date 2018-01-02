package com.dongxin.channel.mapper;

import com.dongxin.channel.domain.ChannelInfo;

public interface ChannelInfoMapper {
    int deleteByPrimaryKey(String chcode);

    int insert(ChannelInfo record);

    int insertSelective(ChannelInfo record);

    ChannelInfo selectByPrimaryKey(String chcode);

    int updateByPrimaryKeySelective(ChannelInfo record);

    int updateByPrimaryKey(ChannelInfo record);
}