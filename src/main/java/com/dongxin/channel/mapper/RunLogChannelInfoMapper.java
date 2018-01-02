package com.dongxin.channel.mapper;

import com.dongxin.channel.domain.RunLogChannelInfo;

import java.util.Map;

public interface RunLogChannelInfoMapper {

    RunLogChannelInfo selectByChcode(Map<String, Object> map);

    int deleteByPrimaryKey(String chcode);

    int insert(RunLogChannelInfo record);

    int insertSelective(RunLogChannelInfo record);

    RunLogChannelInfo selectByPrimaryKey(String chcode);

    int updateByPrimaryKeySelective(RunLogChannelInfo record);

    int updateByPrimaryKey(RunLogChannelInfo record);
}