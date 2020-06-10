package com.bc.interfaces.model.vo;

import java.math.BigDecimal;

public class AgtSecurityVo {

    private String agtNo;

    private String loginPwd;

    private String tradePwd;

    private Integer smsSwitch;

    private Integer screenSwitch;

    private String smsCode;

    private Integer chargeMsgState;

    private Integer custMsgState;
    private Integer state;
    
    private Integer isSendEmail;
    
    private BigDecimal balanceWarning;
    
    private Integer customType;

    public Integer getChargeMsgState() {
        return chargeMsgState;
    }

    public void setChargeMsgState(Integer chargeMsgState) {
        this.chargeMsgState = chargeMsgState;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public AgtSecurityVo() {

    }

    public AgtSecurityVo(String agtNo, String loginPwd, String tradePwd, Integer chargeMsgState, Integer custMsgState) {
        this.agtNo = agtNo;
        this.loginPwd = loginPwd;
        this.tradePwd = tradePwd;
        this.chargeMsgState = chargeMsgState;
        this.custMsgState = custMsgState;
    }

    public String getAgtNo() {
        return agtNo;
    }

    public void setAgtNo(String agtNo) {
        this.agtNo = agtNo;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getTradePwd() {
        return tradePwd;
    }

    public void setTradePwd(String tradePwd) {
        this.tradePwd = tradePwd;
    }

    public Integer getSmsSwitch() {
        return smsSwitch;
    }

    public void setSmsSwitch(Integer smsSwitch) {
        this.smsSwitch = smsSwitch;
    }

    public Integer getScreenSwitch() {
        return screenSwitch;
    }

    public void setScreenSwitch(Integer screenSwitch) {
        this.screenSwitch = screenSwitch;
    }

    public Integer getCustMsgState() {
        return custMsgState;
    }

    public void setCustMsgState(Integer custMsgState) {
        this.custMsgState = custMsgState;
    }

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getIsSendEmail() {
		return isSendEmail;
	}

	public void setIsSendEmail(Integer isSendEmail) {
		this.isSendEmail = isSendEmail;
	}

	public BigDecimal getBalanceWarning() {
		return balanceWarning;
	}

	public void setBalanceWarning(BigDecimal balanceWarning) {
		this.balanceWarning = balanceWarning;
	}

	public Integer getCustomType() {
		return customType;
	}

	public void setCustomType(Integer customType) {
		this.customType = customType;
	}

}
