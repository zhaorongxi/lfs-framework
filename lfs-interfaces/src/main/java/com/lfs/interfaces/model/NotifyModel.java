package com.lfs.interfaces.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class NotifyModel {
private String orderNo;
private String status;
private String upOrderNo;
public String getOrderNo() {
	return orderNo;
}
public void setOrderNo(String orderNo) {
	this.orderNo = orderNo;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getUpOrderNo() {
	return upOrderNo;
}
public void setUpOrderNo(String upOrderNo) {
	this.upOrderNo = upOrderNo;
}
public NotifyModel(String orderNo, String status, String upOrderNo) {
	super();
	this.orderNo = orderNo;
	this.status = status;
	this.upOrderNo = upOrderNo;
}

}
