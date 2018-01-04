package com.dongxin.channel.controller;

import com.dongxin.channel.domain.ChannelUserLogin;
import com.dongxin.channel.util.domain.HttpResult;
import com.dongxin.channel.service.RunLogChannelInfoService;
import com.dongxin.channel.util.HttpUtil;
import com.dongxin.channel.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 渠道备用金信息Controller
 *
 * @author yusongyuan
 * @create 2017-12-28 14:32
 **/
@RestController
@RequestMapping("/info")
public class RunLogChannelInfoController {

    @Autowired
    private RunLogChannelInfoService runLogChannelInfoService;

    //通过渠道user的id获取其备用金最新动态
    @GetMapping("/getLastRunLog")
    public HttpResult getLastRunLog(@RequestParam("id") Integer id){
        ChannelUserLogin user = (ChannelUserLogin)HttpUtil.getSessionAttribute("user");
        return ResultUtil.success(runLogChannelInfoService.selectByChcode(user.getUsername()));
    }

    //通过渠道user的id获取其所有的订单扣除日志
//    @GetMapping("/getRunLog")
//    public HttpResult getRunLog(@RequestParam("id") Integer id){
//        ChannelUserLogin user = (ChannelUserLogin)HttpUtil.getSessionAttribute("user");
//        return ResultUtil.success(runLogChannelInfoService.selectByChcode(user.getUsername(), "all"));
//    }

}
