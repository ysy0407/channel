package com.dongxin.channel.service.impl;

import com.dongxin.channel.domain.BYJChannelInfoLog;
import com.dongxin.channel.service.BYJChannelInfoLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class) //底层使用的是junit4
@SpringBootTest //表示启动整个springboot的工程
public class BYJChannelInfoLogServiceImplTest {

    private BYJChannelInfoLogService service;

    @Test
    public void selectLastUpdate() throws Exception {
//        List<BYJChannelInfoLog> list = service.selectBYJChannelLog("testcheshi");
//        for (BYJChannelInfoLog byj : list) {
//            System.out.println(byj);
//
//        }
    }


    @Test
    public void selectByPrimaryKey() throws Exception {
        System.out.println(service.selectByPrimaryKey(70));

    }

}