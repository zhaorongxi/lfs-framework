package com.bc.base.dto;
/**
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
public class Result<T> {
	
	/**
	 * 成功标志,注意： 最好success是一个object类型的，不仅仅可以是boolean的返回，有时可以定制，比如 “success” 这样的字符串才是表示成功返回。
	 */
	private boolean success;
	
	/**
	 * 状态码
	 */
	private Integer code;
	
	
	/**
	 * 信息 提示
	 */
	private String message;
	
	
	/**
	 * 结果对象
	 */
	private T value;
	
	/**
	 * 时间撮
	 */
	private long dateline = System.currentTimeMillis();
	
	
	public Result(T value) {
		this.value = value;
	}
	
	public Result() {
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}


	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getDateline() {
		return dateline;
	}
	
	@Override
	public String toString() {
		return "Result [success=" + success + ", code=" + code + ", dateline="
				+ dateline + ", message=" + message + ",value="+ value + "]";
	}
}
