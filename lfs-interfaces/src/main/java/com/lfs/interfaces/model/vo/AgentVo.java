package com.lfs.interfaces.model.vo;


import com.lfs.interfaces.model.BankInfo;

import java.io.Serializable;
import java.util.List;

public class AgentVo implements Serializable {

    private static final long serialVersionUID = -7400053370249053724L;
    /**
     * 代理商信息
     */


    private Long id;

    private String agtName;

    private String applyTime;

    private String agtPhone;

    private String agtNo;

    private Long saler;

    private Long parentId;

    private String agtOfficeAddr;

    private String linkName;

    private String linkMobile;

    private String remark;

    private Integer agtType;

    private String idCard;

    private Integer state;

    private Long provinceId;

    private Long cityId;

    private String province;

    private String city;

    private String email;

    private String parentAgtPhone;
    
    private Integer isUsedCard;

    private List<BankInfo> bankInfoList;


    public AgentVo(Long id, String agtName, String agtPhone, Long parentId, String agtNo, Integer agtType,
                   Integer state, Integer isUsedCard,String agtOfficeAddr) {
        this.id = id;
        this.agtName = agtName;
        this.agtPhone = agtPhone;
        this.parentId = parentId;
        this.agtNo = agtNo;
        this.agtType = agtType;
        this.state = state;
        this.isUsedCard = isUsedCard;
        this.agtOfficeAddr = agtOfficeAddr;
    }

    public AgentVo() {

    }

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public String getAgtName() {
        return agtName;
    }

    
    public void setAgtName(String agtName) {
        this.agtName = agtName;
    }

    
    public String getApplyTime() {
        return applyTime;
    }

    
    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    
    public String getAgtPhone() {
        return agtPhone;
    }

    
    public void setAgtPhone(String agtPhone) {
        this.agtPhone = agtPhone;
    }

    
    public String getAgtNo() {
        return agtNo;
    }

    
    public void setAgtNo(String agtNo) {
        this.agtNo = agtNo;
    }

    
    public Long getSaler() {
        return saler;
    }

    
    public void setSaler(Long saler) {
        this.saler = saler;
    }

    
    public Long getParentId() {
        return parentId;
    }

    
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    
    public String getAgtOfficeAddr() {
        return agtOfficeAddr;
    }

    
    public void setAgtOfficeAddr(String agtOfficeAddr) {
        this.agtOfficeAddr = agtOfficeAddr;
    }

    
    public String getLinkName() {
        return linkName;
    }

    
    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    
    public String getLinkMobile() {
        return linkMobile;
    }

    
    public void setLinkMobile(String linkMobile) {
        this.linkMobile = linkMobile;
    }

    
    public String getRemark() {
        return remark;
    }

    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    
    public Integer getAgtType() {
        return agtType;
    }

    
    public void setAgtType(Integer agtType) {
        this.agtType = agtType;
    }

    
    public String getIdCard() {
        return idCard;
    }

    
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    
    public Integer getState() {
        return state;
    }

    
    public void setState(Integer state) {
        this.state = state;
    }

    
    public Long getProvinceId() {
        return provinceId;
    }

    
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    
    public Long getCityId() {
        return cityId;
    }

    
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    
    public String getProvince() {
        return province;
    }

    
    public void setProvince(String province) {
        this.province = province;
    }

    
    public String getCity() {
        return city;
    }

    
    public void setCity(String city) {
        this.city = city;
    }

    
    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getParentAgtPhone() {
        return parentAgtPhone;
    }

    
    public void setParentAgtPhone(String parentAgtPhone) {
        this.parentAgtPhone = parentAgtPhone;
    }

	public Integer getIsUsedCard() {
		return isUsedCard;
	}

	public void setIsUsedCard(Integer isUsedCard) {
		this.isUsedCard = isUsedCard;
	}

    public List<BankInfo> getBankInfoList() {
        return bankInfoList;
    }

    public void setBankInfoList(List<BankInfo> bankInfoList) {
        this.bankInfoList = bankInfoList;
    }
}
