package com.dongxin.channel.controller;

import com.dongxin.channel.domain.HttpResult;
import com.dongxin.channel.service.RunLogChannelInfoService;
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

    @GetMapping("/getLastRunLog")
    public HttpResult getLastRunLog(@RequestParam("chcode") String chcode){
        return ResultUtil.success(runLogChannelInfoService.selectByChcode(chcode));
    }

    @GetMapping("/getRunLog")
    public HttpResult getRunLog(@RequestParam("chcode") String chcode){
        return ResultUtil.success(runLogChannelInfoService.selectByChcode(chcode, "all"));
    }

}
