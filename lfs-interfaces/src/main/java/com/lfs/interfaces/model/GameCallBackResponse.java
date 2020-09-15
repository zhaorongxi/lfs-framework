package com.lfs.interfaces.model;

import com.lfs.interfaces.common.GameResponseCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

/**
 * 适配器转换回调协议
 * 
 * 
 * @author liulu
 */
@JsonInclude(Include.NON_NULL)
public class GameCallBackResponse implements Serializable {


	private static final long serialVersionUID = 287503956264141366L;
	private String gwSeqNo;// 网关序列号
	private String adapterName;// 网关序列号
	private String status;// 网关状态
	private String code;// 网关信息
	private String message;// 网关信息
	private String mobile;// 网关信息

	public GameCallBackResponse() {

	}
	
	/**
	 * 
	 * @param gwSeqNo
	 * @param code
	 * @param message
	 * @param okFlag
	 * @param adapterName
	 */
	public GameCallBackResponse(String gwSeqNo, String code, String message, String okFlag, String adapterName) {
		// 如果相等就为成功
		if (okFlag.equalsIgnoreCase(code)) {
			this.status = GameResponseCode.CALL_OK.getCode();
		} else {
			this.status = GameResponseCode.CALL_ERROR.getCode();
		}
		this.gwSeqNo = gwSeqNo;
		this.adapterName = adapterName;
		this.code = code;
		this.message = message;
	}
	
	
	
	
	

	public String getGwSeqNo() {
		return gwSeqNo;
	}

	public void setGwSeqNo(String gwSeqNo) {
		this.gwSeqNo = gwSeqNo;
	}

	public String getAdapterName() {
		return adapterName;
	}

	public void setAdapterName(String adapterName) {
		this.adapterName = adapterName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
