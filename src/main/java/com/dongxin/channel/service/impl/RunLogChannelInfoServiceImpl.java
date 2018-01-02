package com.dongxin.channel.service.impl;

import com.dongxin.channel.domain.RunLogChannelInfo;
import com.dongxin.channel.mapper.RunLogChannelInfoMapper;
import com.dongxin.channel.service.RunLogChannelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 渠道商备用金日志信息ServiceImpl
 *
 * @author yusongyuan
 * @create 2017-12-28 14:27
 **/
@Service
public class RunLogChannelInfoServiceImpl implements RunLogChannelInfoService {

    @Autowired
    private RunLogChannelInfoMapper runLogChannelInfoMapper;

    /**
     * 查询第一个
     * @param chcode
     * @return
     */
    @Override
    public RunLogChannelInfo selectByChcode(String chcode) {
        return selectByChcode(chcode, "");
    }

    /**
     * 查询全部
     * @param chcode
     * @param isFirst
     * @return
     */
    @Override
    public RunLogChannelInfo selectByChcode(String chcode, String isFirst) {
        //获取当前时间的年份最后两个字段，月份，拼接作为需要联查的当月表
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String date =  sdf.format( new Date());
//        String historyTable = "byjchannelinfolog"+date.substring(2,4)+date.substring(5,7);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("chcode", chcode);
        map.put("historyTable", "byjchannelinfolog1712");
        //当first为空字符串就会只查第一个
        map.put("first", isFirst);
        return runLogChannelInfoMapper.selectByChcode(map);
    }
}
