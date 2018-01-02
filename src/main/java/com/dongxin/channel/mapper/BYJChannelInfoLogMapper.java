package com.dongxin.channel.mapper;

import com.dongxin.channel.domain.BYJChannelInfoLog;

import java.util.List;
import java.util.Map;

public interface BYJChannelInfoLogMapper {

    List<BYJChannelInfoLog> selectBYJChannelLog(Map<String, Object> map);

    int deleteByPrimaryKey(Integer id);

    int insert(BYJChannelInfoLog record);

    int insertSelective(BYJChannelInfoLog record);

    BYJChannelInfoLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BYJChannelInfoLog record);

    int updateByPrimaryKey(BYJChannelInfoLog record);
}