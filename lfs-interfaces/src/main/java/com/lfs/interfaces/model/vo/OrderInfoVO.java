package com.lfs.interfaces.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lfs.common.core.domain.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderInfoVO extends BaseEntity implements Serializable{

    private static final long serialVersionUID = -7924457651725561859L;
    private String orderNo;

    private BigDecimal chargeMoney;

    private String reqStreamId;

    private String upOrderNo;

    private String agtPhone;

    private String chargeAddr;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date applyTime;

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

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
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
                ", applyTime=" + applyTime +
                ", state=" + state +
                ", exp2='" + exp2 + '\'' +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
