package com.dongxin.channel.domain;

import com.dongxin.channel.util.annotation.ExcelResources;

public class BYJChannelInfoLog {
    private Integer id;

    private String chcode;

    private Byte kkflag;

    private String orderid;

    private String srcorderid;

    private Byte operators;

    private Byte ftid;

    private String phone;

    private String provname;

    private String productid;

    private Double runmoney;

    private String bdtime;

    private Double totalmoney;

    private Integer isdel;

    private String inserttime;

    @Override
    public String toString() {
        return "BYJChannelInfoLog{" +
                "id=" + id +
                ", chcode='" + chcode + '\'' +
                ", kkflag=" + kkflag +
                ", orderid='" + orderid + '\'' +
                ", srcorderid='" + srcorderid + '\'' +
                ", operators=" + operators +
                ", ftid=" + ftid +
                ", phone='" + phone + '\'' +
                ", provname='" + provname + '\'' +
                ", productid='" + productid + '\'' +
                ", runmoney=" + runmoney +
                ", bdtime='" + bdtime + '\'' +
                ", totalmoney=" + totalmoney +
                ", isdel=" + isdel +
                ", inserttime='" + inserttime + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChcode() {
        return chcode;
    }

    public void setChcode(String chcode) {
        this.chcode = chcode == null ? null : chcode.trim();
    }

    @ExcelResources(title = "扣款/返款",order = 9)
    public Byte getKkflag() {
        return kkflag;
    }

    public void setKkflag(Byte kkflag) {
        this.kkflag = kkflag;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    @ExcelResources(title = "订单号",order = 1)
    public String getSrcorderid() {
        return srcorderid;
    }

    public void setSrcorderid(String srcorderid) {
        this.srcorderid = srcorderid == null ? null : srcorderid.trim();
    }

    @ExcelResources(title = "运行商",order = 4)
    public Byte getOperators() {
        return operators;
    }

    public void setOperators(Byte operators) {
        this.operators = operators;
    }

    @ExcelResources(title = "产品类型",order = 6)
    public Byte getFtid() {
        return ftid;
    }

    public void setFtid(Byte ftid) {
        this.ftid = ftid;
    }

    @ExcelResources(title = "手机号", order = 2)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    @ExcelResources(title = "省份", order = 3)
    public String getProvname() {
        return provname;
    }

    public void setProvname(String provname) {
        this.provname = provname == null ? null : provname.trim();
    }

    @ExcelResources(title = "产品ID",order = 5)
    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    public Double getRunmoney() {
        return runmoney;
    }

    public void setRunmoney(Double runmoney) {
        this.runmoney = runmoney;
    }

    public String getBdtime() {
        return bdtime;
    }

    public void setBdtime(String bdtime) {
        this.bdtime = bdtime == null ? null : bdtime.trim();
    }

    @ExcelResources(title = "交易金额",order = 8)
    public Double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    @ExcelResources(title = "交易时间",order = 7)
    public String getInserttime() {
        return inserttime;
    }

    public void setInserttime(String inserttime) {
        this.inserttime = inserttime == null ? null : inserttime.trim();
    }
}