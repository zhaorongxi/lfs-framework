package com.lfs.interfaces.model;
public class ChannelSupplier {
	/**
	 * 供应商编码
	 */
	private String channelNum;

	private String merchId;
	
	/**
	 * 供应商名称
	 */
	private String channelName;


	/**
	 * 流量下发适配器
	 */
	private String adapterName;

	/**
	 * 接入密码
	 */
	private String passwd;

	/**
	 * 接入密钥
	 */
	private String channelKey;

	/**
	 * 下单URL
	 */
	private String makeOrderUrl;

	/**
	 * 查询URL
	 */
	private String queryUrl;

   /**
    * 查询余额URL
    */
	private String balanceUrl;
	/**
	 * 回调URL
	 */
	private String notifyUrl;
	
	
	private String sign;
	
	/**
	 * 备用字段1
	 */
	private String free1;
	
	/**
	 * 备用字段2
	 */
	private String free2;


	public String getChannelNum() {
		return channelNum;
	}


	public void setChannelNum(String channelNum) {
		this.channelNum = channelNum;
	}


	public String getChannelName() {
		return channelName;
	}


	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}


	public String getAdapterName() {
		return adapterName;
	}


	public void setAdapterName(String adapterName) {
		this.adapterName = adapterName;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String getChannelKey() {
		return channelKey;
	}


	public void setChannelKey(String channelKey) {
		this.channelKey = channelKey;
	}


	public String getMakeOrderUrl() {
		return makeOrderUrl;
	}


	public void setMakeOrderUrl(String makeOrderUrl) {
		this.makeOrderUrl = makeOrderUrl;
	}


	public String getQueryUrl() {
		return queryUrl;
	}


	public void setQueryUrl(String queryUrl) {
		this.queryUrl = queryUrl;
	}


	public String getSign() {
		return sign;
	}


	public void setSupplierSign(String sign) {
		this.sign = sign;
	}


	public String getMerchId() {
		return merchId;
	}


	public void setMerchId(String merchId) {
		this.merchId = merchId;
	}


	public String getBalanceUrl() {
		return balanceUrl;
	}


	public void setBalanceUrl(String balanceUrl) {
		this.balanceUrl = balanceUrl;
	}


	public String getNotifyUrl() {
		return notifyUrl;
	}


	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}


	public void setSign(String sign) {
		this.sign = sign;
	}


	public String getFree1() {
		return free1;
	}


	public void setFree1(String free1) {
		this.free1 = free1;
	}


	public String getFree2() {
		return free2;
	}


	public void setFree2(String free2) {
		this.free2 = free2;
	}



}
