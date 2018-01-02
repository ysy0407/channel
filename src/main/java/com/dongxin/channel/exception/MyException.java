package com.dongxin.channel.exception;

import com.dongxin.channel.myenum.MyEnum;

/**
 * 自定义异常
 *
 * @author yusongyuan
 * @create 2017-12-27 14:00
 **/

public class MyException extends RuntimeException {

    //统一管理异常信息的枚举类
    private MyEnum myEnum;

    public MyException(MyEnum myEnum) {
        this.myEnum = myEnum;
    }

    public MyEnum getMyEnum() {
        return myEnum;
    }

    public void setMyEnum(MyEnum myEnum) {
        this.myEnum = myEnum;
    }
}
