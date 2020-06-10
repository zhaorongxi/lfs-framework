package com.bc.interfaces.model;

import java.io.Serializable;

public class AppAuthToken implements Serializable {
    private static final long serialVersionUID = 7324831702519086282L;

    private Integer id;

    private String agtAppId;

    private String developAppId;

    private String agtAppAccount;

    private String appAuthCode;

    private String appAuthToken;

    private String appPublicKey;

    private String appPrivateKey;

    private String remark;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgtAppId() {
        return agtAppId;
    }

    public void setAgtAppId(String agtAppId) {
        this.agtAppId = agtAppId;
    }

    public String getDevelopAppId() {
        return developAppId;
    }

    public void setDevelopAppId(String developAppId) {
        this.developAppId = developAppId;
    }

    public String getAgtAppAccount() {
        return agtAppAccount;
    }

    public void setAgtAppAccount(String agtAppAccount) {
        this.agtAppAccount = agtAppAccount;
    }

    public String getAppAuthCode() {
        return appAuthCode;
    }

    public void setAppAuthCode(String appAuthCode) {
        this.appAuthCode = appAuthCode;
    }

    public String getAppAuthToken() {
        return appAuthToken;
    }

    public void setAppAuthToken(String appAuthToken) {
        this.appAuthToken = appAuthToken;
    }

    public String getAppPublicKey() {
        return appPublicKey;
    }

    public void setAppPublicKey(String appPublicKey) {
        this.appPublicKey = appPublicKey;
    }

    public String getAppPrivateKey() {
        return appPrivateKey;
    }

    public void setAppPrivateKey(String appPrivateKey) {
        this.appPrivateKey = appPrivateKey;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
