package com.dongxin.channel.util.myenum;

public enum MyEnum {

    SCS_0000("0000", "操作成功"),
    ERR_1000("1000", "未知错误"),
    ERR_1001("1001", "操作失败"),
    ERR_1002("1002", "用户名或密码错误"),
    ERR_1003("1003", "验证码错误"),
    ERR_1004("1004", "未登录"),
    ERR_1005("1005", "sada"),
    ERR_1006("1006", "adsda"),
    ;

    MyEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

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
}
