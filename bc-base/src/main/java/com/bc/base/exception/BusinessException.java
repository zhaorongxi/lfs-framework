package com.bc.base.exception;


import com.bc.base.enums.HttpStatusEnum;

/**
 * <p><b>Title:</b><i>业务异常类</i></p>
 * <p>Desc: TODO</p>
 * <p>source folder:{@docRoot}</p>
 * <p>Copyright:Copyright(c)2018</p>
 * <p>Company:vanke</p>
 * <p>Create Date:2018年7月17日 上午11:55:29</p>
 * <p>Modified By:wanglz08-</p>
 * <p>Modified Date:2018年7月17日 上午11:55:29</p>
 * @author <a href="mailto:wanglz08@vanke.com title="邮箱地址">wanglz08</a>
 * @version Version 0.1
 *
 */
public class BusinessException extends RuntimeException {


	private static final long serialVersionUID = -8912507817799695689L;

	private Integer code;

	private String message;


	public BusinessException() {
		super();
	}

	public Integer getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	/**
	 * 构造方法。
	 * 
	 * @param message
	 *            异常信息
	 */
	public BusinessException(String message) {
		super(message);
		this.message = message;
		this.code = HttpStatusEnum.INTERNAL_SERVER_ERROR.value();
	}
	public BusinessException(int code,String message) {
		super(message);
		this.code = code;
		this.message = message;
	}
	public BusinessException(Exception e) {
		super(e.getMessage(), e);
		this.code = HttpStatusEnum.INTERNAL_SERVER_ERROR.value();
		this.message = e.getMessage();
	}
	/**
	 * 构造方法。
	 * 
	 * @param cause
	 *            异常原因
	 *            error ex..
	 */
	public BusinessException(Throwable cause) {
		super(cause);
		this.code = HttpStatusEnum.INTERNAL_SERVER_ERROR.value();
		this.message = cause.getMessage();
	}

	/**
	 * 构造方法。
	 * 
	 * @param message
	 *            异常信息
	 * @param cause
	 *            异常原因
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
		this.code = HttpStatusEnum.INTERNAL_SERVER_ERROR.value();
	}
}
