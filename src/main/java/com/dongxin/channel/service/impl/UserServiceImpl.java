package com.dongxin.channel.service.impl;

import com.dongxin.channel.domain.ChannelUserLogin;
import com.dongxin.channel.exception.MyException;
import com.dongxin.channel.mapper.ChannelUserLoginMapper;
import com.dongxin.channel.myannotation.NeedLog;
import com.dongxin.channel.myenum.MyEnum;
import com.dongxin.channel.service.UserService;
import com.dongxin.channel.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 渠道用户ServiceImpl
 *
 * @author yusongyuan
 * @create 2017-12-27 13:27
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ChannelUserLoginMapper channelUserLoginMapper;

    @NeedLog(handleInfo = "登录")
    @Override
    public ChannelUserLogin selectByNameAndPWD(String username, String password) throws MyException {
        ChannelUserLogin user = new ChannelUserLogin();
        user.setUsername(username);
        user.setPassword(password);
        ChannelUserLogin userLogin = channelUserLoginMapper.selectByNameAndPWD(user);
        if(userLogin != null){
            return userLogin;
        //用户名或密码错误
        }else{
            throw new MyException(MyEnum.ERR_1002);
        }
    }

    @NeedLog(handleInfo = "修改密码")
    @Override
    public ChannelUserLogin changePWD(Integer id, String newPWD) throws MyException {
        ChannelUserLogin user = new ChannelUserLogin();
        user.setId(id);
        user.setPassword(newPWD);
        if(1 == channelUserLoginMapper.updateByPrimaryKeySelective(user)){
            return user;
        //密码修改失败
        }else{
            throw new MyException(MyEnum.ERR_1001);
        }
    }
}
