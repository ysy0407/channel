package com.dongxin.channel.controller;

import com.dongxin.channel.domain.ChannelUserLogin;
import com.dongxin.channel.domain.HttpResult;
import com.dongxin.channel.exception.MyException;
import com.dongxin.channel.myannotation.NeedLog;
import com.dongxin.channel.myenum.MyEnum;
import com.dongxin.channel.service.UserService;
import com.dongxin.channel.util.Base64;
import com.dongxin.channel.util.HttpUtil;
import com.dongxin.channel.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 渠道用户Controller
 *
 * @author yusongyuan
 * @create 2017-12-27 13:24
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 登录 将用户名和密码解密,登录成功后存入到session中,user字段为key
     *
     * @param username 前端传来的用户名应当Base64加密
     * @param password 前端传来的密码应当先MD5加密,后Base64加密
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    public HttpResult login(@RequestParam("username") String username,
                            @RequestParam("password") String password) throws Exception{
        //登陆 BASE64解密
        ChannelUserLogin user = userService.selectByNameAndPWD(new String(Base64.decode(new String(username))), new String(Base64.decode(new String(password))));
        logger.info(user.toString());
        //放入session，username为key
        HttpUtil.setSessionAttribute("user", user);
        return ResultUtil.success(user);
    }

    /**
     * 退出 通过用户id 将指定的用户在session中删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/exit")
    public HttpResult exit(@RequestParam("id") Integer id){
        ChannelUserLogin user = (ChannelUserLogin)HttpUtil.getSessionAttribute("user");
        HttpUtil.removeSessionAttribute("user");
        return ResultUtil.success();
    }

    /**
     * 通过id,修改密码
     *
     * @param id
     * @param newPWD 前端传来的密码应当先MD5加密,后Base64加密
     */
    @PostMapping("/changePWD")
    public HttpResult changePWD(@RequestParam("id") Integer id,
                                @RequestParam("newPWD") String newPWD) throws Exception{
        //Base64解密后放入数据库
        userService.changePWD(id, new String(Base64.decode(new String(newPWD))));
        return ResultUtil.success();
    }

}
