package com.bc.interfaces.model;

import org.apache.ibatis.type.Alias;

@Alias("AgtSecurity")
public class AgtSecurity {

    private String agtNo;

    private String loginPwd;

    private String tradePwd;

    private Integer smsSwitch;

    private Integer screenSwitch;

    private String smsCode;

    private Integer chargeMsgState;

    private Integer custMsgState;

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public AgtSecurity() {

    }

    public AgtSecurity(String agtNo, String loginPwd, String tradePwd) {
        this.agtNo = agtNo;
        this.loginPwd = loginPwd;
        this.tradePwd = tradePwd;
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

    public Integer getChargeMsgState() {
        return chargeMsgState;
    }

    public void setChargeMsgState(Integer chargeMsgState) {
        this.chargeMsgState = chargeMsgState;
    }

    public Integer getCustMsgState() {
        return custMsgState;
    }

    public void setCustMsgState(Integer custMsgState) {
        this.custMsgState = custMsgState;
    }

}
