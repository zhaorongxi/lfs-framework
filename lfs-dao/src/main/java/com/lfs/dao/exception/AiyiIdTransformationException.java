package com.lfs.dao.exception;
/**
 * <p><b>Title:</b><i>内部异常类：表示数据库中自增ID达到了Long类型，而实体类中ID为Integer类型时发生的类型转换异常
 * 解决方案：实体类中将int提升为long</i></p>
 * <p>Desc: TODO</p>
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
public class AiyiIdTransformationException extends Exception {

	public AiyiIdTransformationException(String message) {
		// TODO Auto-generated constructor stub
		 super(message);
	}

	private static final long serialVersionUID = 1L;

}
