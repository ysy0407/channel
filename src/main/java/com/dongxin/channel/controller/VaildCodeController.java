package com.dongxin.channel.controller;

import com.dongxin.channel.util.domain.HttpResult;
import com.dongxin.channel.util.exception.MyException;
import com.dongxin.channel.util.myenum.MyEnum;
import com.dongxin.channel.util.HttpUtil;
import com.dongxin.channel.util.secret.MD5;
import com.dongxin.channel.util.ResultUtil;
import com.dongxin.channel.util.secret.ValidationCode;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证码Controller
 *
 * @author yusongyuan
 * @create 2017-12-27 14:56
 **/
@RestController
@RequestMapping("/vail")
public class VaildCodeController {

    /**
     * 获取验证码图片，并将其时间戳作为key，并将验证码toLower，MD5加密后放入session中
     *
     * @param response
     * @param date
     * @throws Exception
     */
    @PostMapping("/getVerify")
    public void getVerfy(HttpServletResponse response,
                         @RequestParam("date") String date) throws Exception{
        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache"); //不缓存
        response.setDateHeader("Expire", 0);//在代理服务器端防止缓冲

        //获取随机验证码
        String veriftyCode = ValidationCode.generateVerifyCode(4);
        //将验证码存入session<时间戳, MD5(验证码)>
        HttpUtil.setSessionAttribute(date, MD5.toMD5(veriftyCode.toLowerCase()));
        //输出验证码
        ValidationCode.outputImage(100, 40, response.getOutputStream(), veriftyCode);
    }

    /**
     * 校验验证码并删除原有验证码缓存
     * @param request
     * @param date
     * @param verify
     * @return
     * @throws Exception
     */
    @GetMapping("/vailVerify")
    public HttpResult vailVerify(HttpServletRequest request,
                                 @RequestParam("date") String date, @RequestParam("verify") String verify) throws Exception{
        //以时间戳为key获取验证码
        String reallyVerify = request.getSession().getAttribute(date).toString();
        //删除验证码session缓存
        HttpUtil.removeSessionAttribute(date);
        //验证码正确
        if(reallyVerify.equals(MD5.toMD5(verify.toLowerCase()))){
            return ResultUtil.success();
        //验证码错误
        }else {
            throw new MyException(MyEnum.ERR_1003);
        }


    }


}
