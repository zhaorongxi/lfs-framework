package com.lfs.interfaces.dto;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import com.lfs.interfaces.model.dto.OrderDto;

import java.io.Serializable;

public class ResultReturn<T> implements Serializable {
	private static final long serialVersionUID = 551189297268165493L;
	private T data;
	private Integer status;
	private OrderDto order;
	private String msg;

	public ResultReturn() {
	}

	public T getData() {
		return this.data;
	}

	public ResultReturn<T> setData(T data, OrderDto order) {
		this.data = data;
		this.order = order;
		return this;
	}

	public ResultReturn<T> setData(T data) {
		this.data = data;
		return this;
	}

	public Integer getStatus() {
		return this.status;
	}

	public ResultReturn<T> setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public String getMsg() {
		return this.msg;
	}

	public ResultReturn<T> setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public OrderDto getOrder() {
		return this.order;
	}

	public void setOrder(OrderDto order) {
		this.order = order;
	}

	public String toString() {
		return "ResultReturn [data=" + this.data + ", status=" + this.status + ", order=" + this.order + ", msg=" + this.msg + "]";
	}
}
