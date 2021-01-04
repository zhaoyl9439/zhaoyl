package com.example.demo.iddency.vo;

import java.io.Serializable;

public class IdentityAuth implements Serializable {
    private static final long serialVersionUID = 8983476213345811645L;
    /** 终端mac*/
    private String termMac;

    /** 设备mac*/
    private String devMac;

    /** 认证方式
     * AD  广告认证
     * SMS 短信认证
     * ACC 账号认证
     * */
    private String type;

    /** 手机号码*/
    private String phone;

    /** 短信验证码*/
    private String smsNum;

    public String getTermMac() {
        return termMac;
    }

    public void setTermMac(String termMac) {
        this.termMac = termMac;
    }

    public String getDevMac() {
        return devMac;
    }

    public void setDevMac(String devMac) {
        this.devMac = devMac;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSmsNum() {
        return smsNum;
    }

    public void setSmsNum(String smsNum) {
        this.smsNum = smsNum;
    }

}
