package com.bc.interfaces.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderInfoVO implements Serializable {

    private static final long serialVersionUID = -7924457651725561859L;
    private String orderNo;

    private BigDecimal chargeMoney;

    private String reqStreamId;

    private String upOrderNo;

    private String agtPhone;

    private String chargeAddr;

    private String startTime;

    private String endTime;

    private Integer state;

    private String exp2;

    private Integer currentPage;

    private Integer pageSize;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getReqStreamId() {
        return reqStreamId;
    }

    public void setReqStreamId(String reqStreamId) {
        this.reqStreamId = reqStreamId;
    }

    public String getAgtPhone() {
        return agtPhone;
    }

    public void setAgtPhone(String agtPhone) {
        this.agtPhone = agtPhone;
    }

    public String getChargeAddr() {
        return chargeAddr;
    }

    public void setChargeAddr(String chargeAddr) {
        this.chargeAddr = chargeAddr;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getExp2() {
        return exp2;
    }

    public void setExp2(String exp2) {
        this.exp2 = exp2;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUpOrderNo() {
        return upOrderNo;
    }

    public void setUpOrderNo(String upOrderNo) {
        this.upOrderNo = upOrderNo;
    }

    public BigDecimal getChargeMoney() {
        return chargeMoney;
    }

    public void setChargeMoney(BigDecimal chargeMoney) {
        this.chargeMoney = chargeMoney;
    }

    @Override
    public String toString() {
        return "OrderInfoVO{" +
                "orderNo='" + orderNo + '\'' +
                ", chargeMoney=" + chargeMoney +
                ", reqStreamId='" + reqStreamId + '\'' +
                ", upOrderNo='" + upOrderNo + '\'' +
                ", agtPhone='" + agtPhone + '\'' +
                ", chargeAddr='" + chargeAddr + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", state=" + state +
                ", exp2='" + exp2 + '\'' +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
