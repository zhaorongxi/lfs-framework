package com.lfs.interfaces.model.vo;


import java.io.Serializable;
import java.math.BigDecimal;

public class ProductInfoVo implements Serializable {

    private static final long serialVersionUID = -2600628609333780578L;
    /**
     * 
     */
    private Long productCode;

    private Long businessCode;

    private Long arriveType;

    private Long provinceId;

    private Long cityId;

    private String province;

    private String city;

    private BigDecimal tradeFace;

    private BigDecimal price;

    private BigDecimal discount;

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

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
}
