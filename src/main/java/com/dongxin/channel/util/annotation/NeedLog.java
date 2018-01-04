package com.dongxin.channel.util.annotation;

import java.lang.annotation.*;

/**
 * 该注解用于:当前方法需要日志进行记录
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NeedLog {

    //操作内容
    String handleInfo();

}
