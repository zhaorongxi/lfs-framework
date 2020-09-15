package com.lfs.interfaces.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class ChargeVo implements Serializable {

    private static final long serialVersionUID = -6843033197814679085L;

    private String reqStreamId;

    private String orderNo;

    private BigDecimal balance;

    private String agtPhone;

    private String applyTime;

    private BigDecimal chargeNumBalance;

    private String checkTime;

    private String upOrderNo;

    private String payUrl;

    private String exp1;

    public ChargeVo() {
        this.orderNo = "";
        this.balance = new BigDecimal(0.00);
        this.chargeNumBalance = new BigDecimal(0.00);
    }

    public String getReqStreamId() {
        return reqStreamId;
    }

    public void setReqStreamId(String reqStreamId) {
        this.reqStreamId = reqStreamId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public BigDecimal getChargeNumBalance() {
        return chargeNumBalance;
    }

    public void setChargeNumBalance(BigDecimal chargeNumBalance) {
        this.chargeNumBalance = chargeNumBalance;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getUpOrderNo() {
        return upOrderNo;
    }

    public void setUpOrderNo(String upOrderNo) {
        this.upOrderNo = upOrderNo;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    public String getAgtPhone() {
        return agtPhone;
    }

    public void setAgtPhone(String agtPhone) {
        this.agtPhone = agtPhone;
    }

    public String getExp1() {
        return exp1;
    }

    public void setExp1(String exp1) {
        this.exp1 = exp1;
    }
}
