package com.dongxin.channel.mapper;

import com.dongxin.channel.domain.ChannelHandleLog;

public interface ChannelHandleLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChannelHandleLog record);

    int insertSelective(ChannelHandleLog record);

    ChannelHandleLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChannelHandleLog record);

    int updateByPrimaryKey(ChannelHandleLog record);
}