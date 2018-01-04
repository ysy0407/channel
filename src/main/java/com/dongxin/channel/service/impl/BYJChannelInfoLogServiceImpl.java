package com.dongxin.channel.service.impl;

import com.dongxin.channel.domain.BYJChannelInfoLog;
import com.dongxin.channel.domain.ChannelUserLogin;
import com.github.pagehelper.PageInfo;
import com.dongxin.channel.mapper.BYJChannelInfoLogMapper;
import com.dongxin.channel.service.BYJChannelInfoLogService;
import com.dongxin.channel.util.HttpUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
    public PageInfo<BYJChannelInfoLog> selectBYJChannelLog(Integer id, String startDate, String endDate, int pageNo, int pageSize) {
        //获取当前时间的年份最后两个字段，月份，拼接作为需要联查的当月表
        String historyTable = "byjchannelinfolog"+startDate.substring(2,4)+startDate.substring(5,7);
        Map<String, Object> map = new HashMap<String, Object>();
        //通过id获取缓存中的user信息
        ChannelUserLogin user = (ChannelUserLogin)HttpUtil.getSessionAttribute("user");
        map.put("chcode", user.getUsername());
        map.put("historyTable", historyTable);
        map.put("startDate", startDate);
        map.put("endDate", endDate);

        //first不为null会查找所有
        map.put("first", "all");
        //分页
        PageHelper.startPage(pageNo, pageSize);
        PageInfo pages = new PageInfo(byjChannelInfoLogMapper.selectBYJChannelLog(map));
        return pages;
    }

    @Override
    public BYJChannelInfoLog selectByPrimaryKey(Integer id) {
        return byjChannelInfoLogMapper.selectByPrimaryKey(id);
    }
}
