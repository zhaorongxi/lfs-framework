package com.lfs.base.dto;

import com.lfs.base.enums.HttpStatusEnum;

/**
 * <p><b>Title:</b><i>传递结果信息</i></p>
 * <p>Desc: 包含复杂对象结果信息</p>
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
public class ResultObject {
	/**
	 * 方法用途: 成功提示信息<br>
	 * 操作步骤: TODO<br>
	 * @param message
	 * @return
	 */
	public static Result<String> successMessage(String message) {
		Result<String> result = new Result<String>(message);
		result.setCode(HttpStatusEnum.OK.value());
		result.setSuccess(true);
		result.setValue(null);
		result.setMessage(message);
		return result;
	}
	
	/**
	 * 方法用途: 业务提示警告信息<br>
	 * 操作步骤: TODO<br>
	 * @param message
	 * @return
	 */
	public static Result<String> warnMessage(String message) {
		Result<String> result = new Result<String>(message);
		result.setCode(HttpStatusEnum.INVALID.value());
		result.setSuccess(false);
		result.setValue(null);
		result.setMessage(message);
		return result;
	}
	
	
	/**
	 * 方法用途: 自定义业务状态码返回<br>
	 * 操作步骤: TODO<br>
	 * @param message
	 * @return
	 */
	public static Result<String> customMessage(Integer code , String message) {
		Result<String> result = new Result<String>(message);
		result.setCode(code);
		result.setSuccess(true);
		result.setValue(null);
		result.setMessage(message);
		return result;
	}
	
	/**
	 * 方法用途: 业务提示验证权限<br>
	 * 操作步骤: TODO<br>
	 * @param message
	 * @return
	 */
	public static Result<String> sucreMessage(String message) {
		Result<String> result = new Result<String>(message);
		result.setCode(HttpStatusEnum.UNAUTHORIZED.value());
		result.setSuccess(false);
		result.setValue(null);
		result.setMessage(message);
		return result;
	}
	
	
	/**
	 * 方法用途: 成功返回对象<br>
	 * 操作步骤: TODO<br>
	 * @param message
	 * @return
	 */
	public static <T> Result<T> successObject(T t, String message) {
		Result<T> result = new Result<T>(t);
		result.setCode(HttpStatusEnum.OK.value());
		result.setSuccess(true);
		if(null==message||message.equals("")){
			message="成功";
		}
		result.setMessage(message);
		result.setValue(t);
		return result;
	}

	/**
	 * 方法用途: TODO<br/>
	 * 操作步骤: TODO<br/>
	 * ${tags}
	 */
	/**
	 * 方法用途: 成功返回对象<br>
	 * 操作步骤:  <br>
	 * @param message
	 * @return
	 */
	public static Result<String> serverErrorObject(String message) {
		Result<String> result = new Result<String>(message);
		result.setCode(HttpStatusEnum.INTERNAL_SERVER_ERROR.value());
		result.setSuccess(false);
		if(null==message||message.equals("")){
			message="失败";
		}
		result.setMessage(message);
		return result;
	}
}
