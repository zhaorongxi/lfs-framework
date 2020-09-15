package com.lfs.interfaces.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AgtWallet implements Serializable {

    private static final long serialVersionUID = 6251678083790677332L;
    private Integer id;

    private String agtPhone;

    private BigDecimal credit;

    private BigDecimal profit;

    private BigDecimal freeze;

    private String lastTime;

    private BigDecimal sxCredit;

    public AgtWallet() {

    }

    public AgtWallet(String agtPhone) {
        this.agtPhone = agtPhone;
    }


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

    public BigDecimal getSxCredit() {
        return sxCredit;
    }

    public void setSxCredit(BigDecimal sxCredit) {
        this.sxCredit = sxCredit;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getFreeze() {
        return freeze;
    }

    public void setFreeze(BigDecimal freeze) {
        this.freeze = freeze;
    }

    public String getLastTime() {
        if (lastTime != null && lastTime != "") {
            return lastTime.substring(0, lastTime.length() - 2);
        } else {
            return "";
        }
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }
}