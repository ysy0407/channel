package com.dongxin.channel.service;

import com.dongxin.channel.domain.RunLogChannelInfo;

public interface RunLogChannelInfoService {

    RunLogChannelInfo selectByChcode(String chcode);

    RunLogChannelInfo selectByChcode(String chcode, String isFirst);

}
