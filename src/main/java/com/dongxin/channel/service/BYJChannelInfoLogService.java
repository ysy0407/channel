package com.dongxin.channel.service;

import com.dongxin.channel.domain.BYJChannelInfoLog;
import com.github.pagehelper.PageInfo;

public interface BYJChannelInfoLogService {

    PageInfo<BYJChannelInfoLog> selectBYJChannelLog(Integer id, String startDate, String endDate, int pageNo, int pageSize) throws Exception ;

    BYJChannelInfoLog selectByPrimaryKey(Integer id);

}
