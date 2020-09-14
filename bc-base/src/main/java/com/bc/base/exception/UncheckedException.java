package com.bc.base.exception;

/**
 * <p><b>Title:</b><i>无需捕获处理的异常</i></p>
 * <p>Desc: 无需捕获处理的异常</p>
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
@SuppressWarnings("serial")
public class UncheckedException extends RuntimeException {
	/**
	 * 构造方法。
	 * 
	 * @param message
	 *            异常信息
	 */
	public UncheckedException(String message) {
		super(message);
	}

	/**
	 * 构造方法。
	 * 
	 * @param cause
	 *            异常原因
	 */
	public UncheckedException(Throwable cause) {
		super(cause);
	}

	/**
	 * 构造方法。
	 * 
	 * @param message
	 *            异常信息
	 * @param cause
	 *            异常原因
	 */
	public UncheckedException(String message, Throwable cause) {
		super(message, cause);
	}
}
