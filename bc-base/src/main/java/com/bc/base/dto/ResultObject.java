package com.bc.base.dto;

import com.bc.base.enums.HttpStatusEnum;

/**
 * <p><b>Title:</b><i>传递结果信息</i></p>
 * <p>Desc: 包含复杂对象结果信息</p>
 * <p>source folder:{@docRoot}</p>
 * <p>Copyright:Copyright(c)2018</p>
 * <p>Company:vanke</p>
 * <p>Create Date:2018年8月21日 下午6:16:38</p>
 * <p>Modified By:wanglz08-</p>
 * <p>Modified Date:2018年8月21日 下午6:16:38</p>
 * @author <a href="mailto:wanglz08@vanke.com" title="邮箱地址">wanglz08</a>
 * @version Version 0.1
 *
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
