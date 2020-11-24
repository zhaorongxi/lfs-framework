package com.lfs.interfaces.model.vo;

import java.math.BigDecimal;

public class ProductVo {

    private Long productCode;

    private Long businessCode;

    private Long arriveType;

    private Long provinceId;

    private Long cityId;

    private BigDecimal tradeFace;

    private BigDecimal price;

    private BigDecimal discount;

    private String upChannel;
    
    private Integer productType;
    
    private Long specialType;

    private String unit;

    private Integer state;

    private String businessName;

    public Long getProductCode() {
        return productCode;
    }

    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }

    public Long getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(Long businessCode) {
        this.businessCode = businessCode;
    }

    public Long getArriveType() {
        return arriveType;
    }

    public void setArriveType(Long arriveType) {
        this.arriveType = arriveType;
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

    public BigDecimal getTradeFace() {
        return tradeFace;
    }

    public void setTradeFace(BigDecimal tradeFace) {
        this.tradeFace = tradeFace;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getUpChannel() {
        return upChannel;
    }

    public void setUpChannel(String upChannel) {
        this.upChannel = upChannel;
    }

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public Long getSpecialType() {
		return specialType;
	}

	public void setSpecialType(Long specialType) {
		this.specialType = specialType;
	}

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
