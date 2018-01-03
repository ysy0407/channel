package com.dongxin.channel.controller;

import com.dongxin.channel.service.BYJChannelInfoLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 渠道备用金controller
 *
 * @author yusongyuan
 * @create 2017-12-28 13:14
 **/
@RestController
@RequestMapping("/channelinfo")
public class BYJChannelInfoLogController {

    @Autowired
    private BYJChannelInfoLogService byjChannelInfoLogService;



}
