package com.bc.interfaces.model.dto;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDto implements Serializable {

    private static final long serialVersionUID = 3092569323482508966L;
    private Long id;

    private String orderNo;

    private String upOrderNo;

    private String downOrderNo;

    private String agtNo;

    private String agtPhone;

    private String chargeAddr;

    private BigDecimal chargeMoney;

    private BigDecimal profit;

    private BigDecimal price;

    private Integer amount;

    private BigDecimal outMoney;

    private Integer state;

    private Integer checkState;

    private String upchanel;

    private String remark;

    private BigDecimal balance;

    private String errorCode;

    private Long businessCode;

    private Long productCode;

    private BigDecimal accountBalance;

    private String rechargeType;

    private Integer accountType;

    private Long arriveType;

    private Integer stockState;

    private String applyTime;

    private String adapterName;

    private String upProductCode;

    private Integer productType;

    /**
     * 通道结算价格
     * @return
     */
    private BigDecimal channelPrice;

    private String accountIp;

    private String chargeType;

    private String qrCode;

    private String qrTimeOutExpress;

    private String exp2;

    public OrderDto() {
        this.accountBalance = new BigDecimal(0.00);
        this.balance = new BigDecimal(0.00);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUpOrderNo() {
        return upOrderNo;
    }

    public void setUpOrderNo(String upOrderNo) {
        this.upOrderNo = upOrderNo;
    }

    public String getDownOrderNo() {
        return downOrderNo;
    }

    public void setDownOrderNo(String downOrderNo) {
        this.downOrderNo = downOrderNo;
    }

    public String getAgtNo() {
        return agtNo;
    }

    public void setAgtNo(String agtNo) {
        this.agtNo = agtNo;
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

    public BigDecimal getChargeMoney() {
        return chargeMoney;
    }

    public void setChargeMoney(BigDecimal chargeMoney) {
        this.chargeMoney = chargeMoney;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getOutMoney() {
        return outMoney;
    }

    public void setOutMoney(BigDecimal outMoney) {
        this.outMoney = outMoney;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCheckState() {
        return checkState;
    }

    public void setCheckState(Integer checkState) {
        this.checkState = checkState;
    }

    public String getUpchanel() {
        return upchanel;
    }

    public void setUpchanel(String upchanel) {
        this.upchanel = upchanel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Long getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(Long businessCode) {
        this.businessCode = businessCode;
    }

    public Long getProductCode() {
        return productCode;
    }

    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getRechargeType() {
        if (rechargeType != null && rechargeType != "") {
            return rechargeType;
        } else {
            return "";
        }
    }

    public void setRechargeType(String rechargeType) {
        this.rechargeType = rechargeType;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Long getArriveType() {
        return arriveType;
    }

    public void setArriveType(Long arriveType) {
        this.arriveType = arriveType;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getStockState() {
        return stockState;
    }

    public void setStockState(Integer stockState) {
        this.stockState = stockState;
    }

    public String getAdapterName() {
        return adapterName;
    }

    public void setAdapterName(String adapterName) {
        this.adapterName = adapterName;
    }

    public BigDecimal getChannelPrice() {
        return channelPrice;
    }

    public void setChannelPrice(BigDecimal channelPrice) {
        this.channelPrice = channelPrice;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getUpProductCode() {
        return upProductCode;
    }

    public void setUpProductCode(String upProductCode) {
        this.upProductCode = upProductCode;
    }

    public String getAccountIp() {
        return accountIp;
    }

    public void setAccountIp(String accountIp) {
        this.accountIp = accountIp;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getQrTimeOutExpress() {
        return qrTimeOutExpress;
    }

    public void setQrTimeOutExpress(String qrTimeOutExpress) {
        this.qrTimeOutExpress = qrTimeOutExpress;
    }

    public String getExp2() {
        return exp2;
    }

    public void setExp2(String exp2) {
        this.exp2 = exp2;
    }
}
