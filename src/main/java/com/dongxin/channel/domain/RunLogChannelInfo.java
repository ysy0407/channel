package com.dongxin.channel.domain;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public class RunLogChannelInfo {
    private String chcode;

    private Double initmoney;

    private Double totalmoney;

    private Double minalarmmoney;

    private Double maxalarmmoney;

    private Double bzjmoney;

    private Byte status;

    private String updatetime;

    private List<BYJChannelInfoLog> byjChannelInfoLogList;

    public List<BYJChannelInfoLog> getByjChannelInfoLogList() {
        return byjChannelInfoLogList;
    }

    public void setByjChannelInfoLogList(List<BYJChannelInfoLog> byjChannelInfoLogList) {
        this.byjChannelInfoLogList = byjChannelInfoLogList;
    }

    public String getChcode() {
        return chcode;
    }

    public void setChcode(String chcode) {
        this.chcode = chcode == null ? null : chcode.trim();
    }

    public Double getInitmoney() {
        return initmoney;
    }

    public void setInitmoney(Double initmoney) {
        this.initmoney = initmoney;
    }

    public Double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Double getMinalarmmoney() {
        return minalarmmoney;
    }

    public void setMinalarmmoney(Double minalarmmoney) {
        this.minalarmmoney = minalarmmoney;
    }

    public Double getMaxalarmmoney() {
        return maxalarmmoney;
    }

    public void setMaxalarmmoney(Double maxalarmmoney) {
        this.maxalarmmoney = maxalarmmoney;
    }

    public Double getBzjmoney() {
        return bzjmoney;
    }

    public void setBzjmoney(Double bzjmoney) {
        this.bzjmoney = bzjmoney;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }
}