package com.dongxin.channel.util;

import com.dongxin.channel.domain.HttpResult;
import com.dongxin.channel.myenum.MyEnum;
import org.springframework.stereotype.Component;

/**
 * 统一格式结果处理工具类
 *
 * @author yusongyuan
 * @create 2017-12-27 14:04
 **/
@Component
public class ResultUtil {

    //统一的成功结果处理
    public static HttpResult success(Object object){
        return new HttpResult(MyEnum.SCS_0000.getCode(), MyEnum.SCS_0000.getMsg(), object);
    }
    //统一成功无返回内容结果处理
    public static HttpResult success(){
        return new HttpResult(MyEnum.SCS_0000.getCode(), MyEnum.SCS_0000.getMsg(), null);
    }

    //统一的自定义错误结果处理
    public static HttpResult error(MyEnum myEnum){
        return new HttpResult(myEnum.getCode(), myEnum.getMsg(),null);
    }

    //统一未知错误结果处理
    public static HttpResult error(){
        return error(MyEnum.ERR_1000);
    }

}
