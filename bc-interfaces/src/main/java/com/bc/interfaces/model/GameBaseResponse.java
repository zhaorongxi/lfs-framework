package com.bc.interfaces.model;

import com.bc.interfaces.common.Constant;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.ArrayList;
import java.util.List;

/**
 * 适配器转换回调协议
 * 
 * 
 * @author liulu
 */
@JsonInclude(Include.NON_NULL)
public class GameBaseResponse {

	private int status;
	private String okResponse;// 成功响应信息
	private String failResponse;// 失败响应信息
	private List<GameCallBackResponse> responses;

	public GameBaseResponse() {

	}

	/**
	 * 回调解析失败构造方法
	 * 
	 * @param failResponse
	 */
	public GameBaseResponse(String failResponse) {
		this.failResponse = failResponse;
		this.status = Constant.ADAPTER_ERROR;
	}

	/**
	 * 回调解析成功构造方法(多条)
	 * 
	 * @param okResponse
	 * @param failResponse
	 * @param responses
	 */
	public GameBaseResponse(String okResponse, String failResponse, List<GameCallBackResponse> responses) {
		super();
		this.status = Constant.ADAPTER_SUCCESS;
		this.okResponse = okResponse;
		this.failResponse = failResponse;
		this.responses = responses;
	}

	/**
	 * 回调解析成功构造方法（单条）
	 * 
	 * @param okResponse
	 * @param failResponse
	 */
	public GameBaseResponse(String okResponse, String failResponse, GameCallBackResponse response) {
		super();
		this.status = Constant.ADAPTER_SUCCESS;
		this.okResponse = okResponse;
		this.failResponse = failResponse;
		List<GameCallBackResponse> datas = new ArrayList<GameCallBackResponse>();
		datas.add(response);
		this.responses = datas;
	}

	public String getOkResponse() {
		return okResponse;
	}

	public void setOkResponse(String okResponse) {
		this.okResponse = okResponse;
	}

	public String getFailResponse() {
		return failResponse;
	}

	public void setFailResponse(String failResponse) {
		this.failResponse = failResponse;
	}

	public List<GameCallBackResponse> getResponses() {
		return responses;
	}

	public void setResponses(List<GameCallBackResponse> responses) {
		this.responses = responses;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
