package com.dongxin.channel.controller;

import com.dongxin.channel.domain.BYJChannelInfoLog;
import com.dongxin.channel.domain.HttpResult;
import com.dongxin.channel.service.BYJChannelInfoLogService;
import com.dongxin.channel.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 渠道备用金controller
 *
 * @author yusongyuan
 * @create 2017-12-28 13:14
 **/
@RestController
@RequestMapping("/byjlog")
public class BYJChannelInfoLogController {

    @Autowired
    private BYJChannelInfoLogService byjChannelInfoLogService;

    @GetMapping("/getBYJInfoLog")
    public HttpResult getBYJInfoLog(@RequestParam("id") Integer id,
                                    @RequestParam("startDate") String startDate,
                                    @RequestParam("endDate") String endDate,
                                    @RequestParam("pageNo") int pageNo,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize){
        PageInfo<BYJChannelInfoLog> pages = byjChannelInfoLogService.selectBYJChannelLog(id, startDate, endDate, pageNo, pageSize);
        //每页20个
        return  ResultUtil.success(pages);
    }



}
