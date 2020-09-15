package com.lfs.interfaces.model;

import java.io.Serializable;

public class BankInfo implements Serializable {


    private static final long serialVersionUID = -2286510782568637126L;
    private Integer id;

    private String agtPhone;

    private String actionType;

    private String sourceId;

    private String cardNo;

    private String bankAccount;

    private String bankMark;

    private String bankName;

    private Integer status;

    private String bankType;

    private String applyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgtPhone() {
        return agtPhone;
    }

    public void setAgtPhone(String agtPhone) {
        this.agtPhone = agtPhone;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankMark() {
        return bankMark;
    }

    public void setBankMark(String bankMark) {
        this.bankMark = bankMark;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    @Override
    public String toString() {
        return "BankInfoEntity{" +
                "id=" + id +
                ", agtPhone='" + agtPhone + '\'' +
                ", actionType='" + actionType + '\'' +
                ", sourceId='" + sourceId + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", bankMark='" + bankMark + '\'' +
                ", bankName='" + bankName + '\'' +
                ", status=" + status +
                ", bankType='" + bankType + '\'' +
                ", applyTime='" + applyTime + '\'' +
                '}';
    }
}
