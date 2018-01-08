package com.dongxin.channel.controller;

import com.dongxin.channel.domain.BYJChannelInfoLog;
import com.dongxin.channel.util.CommonUtil;
import com.dongxin.channel.util.ExcelUtil;
import com.dongxin.channel.util.HttpUtil;
import com.dongxin.channel.util.domain.HttpResult;
import com.dongxin.channel.service.BYJChannelInfoLogService;
import com.dongxin.channel.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    //根据开始和结束时间查找渠道备用金日志
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

    //根据开始和结束时间下载渠道备用金日志
    @GetMapping("/downBYJInfoLog")
    public HttpResult downBYJInfoLog(@RequestParam("id") Integer id,
                                     @RequestParam("startDate") String startDate,
                                     @RequestParam("endDate") String endDate) throws Exception {
        PageInfo<BYJChannelInfoLog> pages = byjChannelInfoLogService.selectBYJChannelLog(id, startDate, endDate, 0, 999);
        String downDate = CommonUtil.getNowDate();
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "渠道扣款日志");
        map.put("total", pages.getTotal()+" 条");
        map.put("date", downDate);
        //设置response相关信息
        HttpUtil.getHttpResponse().setContentType("application/vnd.ms-excel; charset=UTF-8");
        HttpUtil.getHttpResponse().addHeader("Content-Disposition", "attachment; filename=channelBYJLog"+downDate+".xls");
        //通过工具类完成下载 向responseOutputStream中输出文件流
        ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, "渠道扣款日志模板.xls", HttpUtil.getHttpResponse().getOutputStream(), pages.getList(), BYJChannelInfoLog.class, true);
        HttpUtil.getHttpResponse().getOutputStream().flush();
        HttpUtil.getHttpResponse().getOutputStream().close();
        return ResultUtil.success();

    }



}
