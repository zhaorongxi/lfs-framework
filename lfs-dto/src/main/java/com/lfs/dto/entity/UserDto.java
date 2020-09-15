package com.lfs.dto.entity;

import java.io.Serializable;

/**
 * <p><b>Title:</b><i>TODO</i></p>
 * <p>Desc: TODO</p>
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
public class UserDto implements Serializable {


    private static final long serialVersionUID = -6333607629127489738L;
    
    public Integer id;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户名称
     */
    private String userName;

	/**
	 * 登录名
	 */
	private String loginName;

	/**
	 * 昵称
	 */
	private String nickName;


    /**
     * 用户头像URL
     */
    private String userIcon;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 电话号
     */
    private String phoneNo;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 用户状态  0不正常，1正常
     */
    private Boolean state;

    /**
     * 账号来源
     */
    private String accountSource;

    /**
     * 是否内部用户  0 内部，1 外部
     */
    private int userType;
    
    
    private String loginTime;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUserAccount() {
		return userAccount;
	}


	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserIcon() {
		return userIcon;
	}


	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getIdCard() {
		return idCard;
	}


	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}


	public Boolean getState() {
		return state;
	}


	public void setState(Boolean state) {
		this.state = state;
	}


	public String getAccountSource() {
		return accountSource;
	}


	public void setAccountSource(String accountSource) {
		this.accountSource = accountSource;
	}


	public int getUserType() {
		return userType;
	}


	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "UserDto{" +
				"id=" + id +
				", userAccount='" + userAccount + '\'' +
				", userName='" + userName + '\'' +
				", userIcon='" + userIcon + '\'' +
				", email='" + email + '\'' +
				", phoneNo='" + phoneNo + '\'' +
				", idCard='" + idCard + '\'' +
				", state=" + state +
				", accountSource='" + accountSource + '\'' +
				", userType=" + userType +
				", loginTime=" + loginTime +
				'}';
	}
}
