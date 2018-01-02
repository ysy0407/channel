package com.dongxin.channel.service;

import com.dongxin.channel.domain.ChannelUserLogin;

public interface UserService {

    ChannelUserLogin selectByNameAndPWD(String username, String password);

    ChannelUserLogin changePWD(Integer id, String newPWD);

}
