package com.dongxin.channel.mapper;

import com.dongxin.channel.domain.ChannelUserLogin;

public interface ChannelUserLoginMapper {

    ChannelUserLogin selectByNameAndPWD(ChannelUserLogin user);

    int deleteByPrimaryKey(Integer id);

    int insert(ChannelUserLogin record);

    int insertSelective(ChannelUserLogin record);

    ChannelUserLogin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChannelUserLogin record);

    int updateByPrimaryKey(ChannelUserLogin record);
}