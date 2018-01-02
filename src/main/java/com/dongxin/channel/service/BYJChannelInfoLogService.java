package com.dongxin.channel.service;

import com.dongxin.channel.domain.BYJChannelInfoLog;

import java.util.List;

public interface BYJChannelInfoLogService {

    List<BYJChannelInfoLog> selectBYJChannelLog(String chcode);

    BYJChannelInfoLog selectByPrimaryKey(Integer id);

}
