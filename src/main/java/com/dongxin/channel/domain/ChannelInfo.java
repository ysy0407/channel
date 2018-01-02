package com.dongxin.channel.domain;

public class ChannelInfo {
    private String chcode;

    private String secret;

    private String name;

    private String chname;

    private String nameqc;

    private String companyname;

    private String companynameqc;

    private String url;

    private Integer chtype;

    private Integer status;

    private Integer sfpid;

    private Integer queueident;

    private Integer complexinterval;

    private String mailrecvier;

    private String pchcode;

    private String pname;

    private Integer isparent;

    private Integer isipidentify;

    private String ipaddress;

    private Integer issms;

    private String smsmobile;

    private Integer chhtid;

    private Integer cachetimer;

    private Integer nomoneycache;

    private Integer qjcache;

    private String inserttime;

    private Byte level;

    private Byte dgords;

    public String getChcode() {
        return chcode;
    }

    public void setChcode(String chcode) {
        this.chcode = chcode == null ? null : chcode.trim();
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret == null ? null : secret.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getChname() {
        return chname;
    }

    public void setChname(String chname) {
        this.chname = chname == null ? null : chname.trim();
    }

    public String getNameqc() {
        return nameqc;
    }

    public void setNameqc(String nameqc) {
        this.nameqc = nameqc == null ? null : nameqc.trim();
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    public String getCompanynameqc() {
        return companynameqc;
    }

    public void setCompanynameqc(String companynameqc) {
        this.companynameqc = companynameqc == null ? null : companynameqc.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getChtype() {
        return chtype;
    }

    public void setChtype(Integer chtype) {
        this.chtype = chtype;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSfpid() {
        return sfpid;
    }

    public void setSfpid(Integer sfpid) {
        this.sfpid = sfpid;
    }

    public Integer getQueueident() {
        return queueident;
    }

    public void setQueueident(Integer queueident) {
        this.queueident = queueident;
    }

    public Integer getComplexinterval() {
        return complexinterval;
    }

    public void setComplexinterval(Integer complexinterval) {
        this.complexinterval = complexinterval;
    }

    public String getMailrecvier() {
        return mailrecvier;
    }

    public void setMailrecvier(String mailrecvier) {
        this.mailrecvier = mailrecvier == null ? null : mailrecvier.trim();
    }

    public String getPchcode() {
        return pchcode;
    }

    public void setPchcode(String pchcode) {
        this.pchcode = pchcode == null ? null : pchcode.trim();
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Integer getIsparent() {
        return isparent;
    }

    public void setIsparent(Integer isparent) {
        this.isparent = isparent;
    }

    public Integer getIsipidentify() {
        return isipidentify;
    }

    public void setIsipidentify(Integer isipidentify) {
        this.isipidentify = isipidentify;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress == null ? null : ipaddress.trim();
    }

    public Integer getIssms() {
        return issms;
    }

    public void setIssms(Integer issms) {
        this.issms = issms;
    }

    public String getSmsmobile() {
        return smsmobile;
    }

    public void setSmsmobile(String smsmobile) {
        this.smsmobile = smsmobile == null ? null : smsmobile.trim();
    }

    public Integer getChhtid() {
        return chhtid;
    }

    public void setChhtid(Integer chhtid) {
        this.chhtid = chhtid;
    }

    public Integer getCachetimer() {
        return cachetimer;
    }

    public void setCachetimer(Integer cachetimer) {
        this.cachetimer = cachetimer;
    }

    public Integer getNomoneycache() {
        return nomoneycache;
    }

    public void setNomoneycache(Integer nomoneycache) {
        this.nomoneycache = nomoneycache;
    }

    public Integer getQjcache() {
        return qjcache;
    }

    public void setQjcache(Integer qjcache) {
        this.qjcache = qjcache;
    }

    public String getInserttime() {
        return inserttime;
    }

    public void setInserttime(String inserttime) {
        this.inserttime = inserttime == null ? null : inserttime.trim();
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Byte getDgords() {
        return dgords;
    }

    public void setDgords(Byte dgords) {
        this.dgords = dgords;
    }
}