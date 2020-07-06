package com.bc.dao.exception;
/**
 * 内部异常类：表示实体类的ID字段类型与数据库类型不匹配
 * 解决方案：更正主键类型
 * @author 郭胜凯
 * @time 2016年2月26日下午5:04:16
 * @email 719348277@qq.com
 */
/**
 * <p><b>Title:</b><i> 内部异常类：表示实体类的ID字段类型与数据库类型不匹配
 * 解决方案：更正主键类型</i></p>
 * <p>Desc: TODO</p>
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
public class AiyiIdTypeException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public AiyiIdTypeException(String message){
		 super(message);
	}

}
