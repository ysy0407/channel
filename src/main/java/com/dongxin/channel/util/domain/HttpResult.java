package com.dongxin.channel.util.domain;

/**
 * 统一的HTTP请求响应信息
 *
 * @author yusongyuan
 * @create 2017-12-27 13:40
 **/

public class HttpResult<T> {

    //编号
    private String code;
    //描述信息
    private String msg;
    //具体内容
    private T date;

    public HttpResult(){}

    public HttpResult(String code, String msg, T date) {
        this.code = code;
        this.msg = msg;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

}
