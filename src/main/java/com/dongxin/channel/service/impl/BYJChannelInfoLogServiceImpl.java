package com.dongxin.channel.service.impl;

import com.dongxin.channel.domain.BYJChannelInfoLog;
import com.dongxin.channel.mapper.BYJChannelInfoLogMapper;
import com.dongxin.channel.service.BYJChannelInfoLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 渠道备用金service Impl
 *
 * @author yusongyuan
 * @create 2017-12-28 11:27
 **/
@Service
public class BYJChannelInfoLogServiceImpl implements BYJChannelInfoLogService {

    @Autowired
    private BYJChannelInfoLogMapper byjChannelInfoLogMapper;

    @Override
    public List<BYJChannelInfoLog> selectBYJChannelLog(String chcode) {
        //获取当前时间的年份最后两个字段，月份，拼接作为需要联查的当月表
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String date =  sdf.format( new Date());
        String historyTable = "byjchannelinfolog"+date.substring(2,4)+date.substring(5,7);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("chcode", chcode);
        map.put("historyTable", historyTable);
        //当first不为null就会只查第一个
        map.put("first", "first");
//        List<BYJChannelInfoLog> list = mapper.selectLastUpdate(map);
        return byjChannelInfoLogMapper.selectBYJChannelLog(map);
    }

    @Override
    public BYJChannelInfoLog selectByPrimaryKey(Integer id) {
        return byjChannelInfoLogMapper.selectByPrimaryKey(id);
    }
}
