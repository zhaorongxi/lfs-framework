package com.bc.interfaces.model;

import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;

@Alias("Product")
public class Product {

    private Long productCode;

    private Long businessCode;

    private Long arriveType;

    private BigDecimal tradeFace;

    private BigDecimal price;

    private BigDecimal discount;

    private String upChannel;

    private String businessName;
    
    private Integer productType;
    
    private Integer specialType;

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

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public Integer getSpecialType() {
		return specialType;
	}

	public void setSpecialType(Integer specialType) {
		this.specialType = specialType;
	}
	
}
