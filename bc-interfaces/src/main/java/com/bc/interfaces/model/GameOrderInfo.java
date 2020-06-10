package com.bc.interfaces.model;

public class GameOrderInfo {
	private Long orderId;
	private Long flowAppId;
	private String channelId;
	private String usedMobile;
	private Long enterpriseId;
	private String status;
	private String adapterName;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getFlowAppId() {
		return flowAppId;
	}
	public void setFlowAppId(Long flowAppId) {
		this.flowAppId = flowAppId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getUsedMobile() {
		return usedMobile;
	}
	public void setUsedMobile(String usedMobile) {
		this.usedMobile = usedMobile;
	}
	public Long getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAdapterName() {
		return adapterName;
	}
	public void setAdapterName(String adapterName) {
		this.adapterName = adapterName;
	}

}
