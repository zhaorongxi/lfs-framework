package com.bc.interfaces.common;

/**
 * 返回码对应的枚举
 * 
 * 
 * @author liulu
 */
public enum GameResponseCode {

	CALL_OK("0", "回调充值成功"),
	CALL_ERROR("1", "回调充值失败"),
	C9999("9999", "系统内部错误"),
	C0006("0006", "缺少必要参数"),
	C0005("0005", "下发记录表没记录"),
	C0004("0004", "供应商通道不存在"),
	C0003("0003", "下单url请求失败"),
	C0002("0002", "适配器不存在"),
	C0001("0001", "下单失败"),
	C0000("0000", "下单成功");

	private String code;
	private String desc;

	private GameResponseCode(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
