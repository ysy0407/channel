package com.dongxin.channel.service.impl;

import com.dongxin.channel.domain.ChannelHandleLog;
import com.dongxin.channel.util.exception.MyException;
import com.dongxin.channel.mapper.ChannelHandleLogMapper;
import com.dongxin.channel.util.myenum.MyEnum;
import com.dongxin.channel.service.ChannelHandleLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 渠道操作日志service Impl
 *
 * @author yusongyuan
 * @create 2018-01-03 11:35
 **/
@Service
public class ChannelHandleLogServiceImpl implements ChannelHandleLogService {

    @Autowired
    private ChannelHandleLogMapper channelHandleLogMapper;

    @Override
    public int insertHandleLog(ChannelHandleLog channelHandleLog) throws MyException {
        System.out.println("--------x需要添加的日志:"+channelHandleLog);
        int result = channelHandleLogMapper.insertSelective(channelHandleLog);
        //插入渠道操作日志失败
        if (result != 1) {
            throw new MyException(MyEnum.ERR_1001);
        }
        return result;
    }
}
