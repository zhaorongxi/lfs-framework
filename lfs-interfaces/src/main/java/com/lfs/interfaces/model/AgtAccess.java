package com.lfs.interfaces.model;


public class AgtAccess {

    private Long id;

    private String agtNo;

    private String appId;

    private String appKey;

    private Integer appType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgtNo() {
        return agtNo;
    }

    public void setAgtNo(String agtNo) {
        this.agtNo = agtNo;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public Integer getAppType() {
        return appType;
    }

    public void setAppType(Integer appType) {
        this.appType = appType;
    }
}
