package com.bc.dao.exception;
/**
 * <p><b>Title:</b><i>内部异常类：表示数据库中自增ID达到了Long类型，而实体类中ID为Integer类型时发生的类型转换异常
 * 解决方案：实体类中将int提升为long</i></p>
 * <p>Desc: TODO</p>
 * <p>source folder:{@docRoot}</p>
 * <p>Copyright:Copyright(c)2018</p>
 * <p>Company:vanke</p>
 * <p>Create Date:2018年8月30日 上午10:26:40</p>
 * <p>Modified By:wanglz08-</p>
 * <p>Modified Date:2018年8月30日 上午10:26:40</p>
 * @author <a href="mailto:wanglz08@vanke.com title="邮箱地址">wanglz08</a>
 * @version Version 0.1
 *
 */
public class AiyiIdTransformationException extends Exception {

	public AiyiIdTransformationException(String message) {
		// TODO Auto-generated constructor stub
		 super(message);
	}

	private static final long serialVersionUID = 1L;

}
