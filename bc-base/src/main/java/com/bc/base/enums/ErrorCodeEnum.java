package com.bc.base.enums;

/**
 * Copyright: Copyright (c) 2019  Dylan
 *
 * @ClassName: ErrorCode
 * @Description: 错误码
 * @version: v1.0.0
 * @author: Dylan
 * @date 2019/2/15 5:36 PM
 */
/**
 * @author wanglz08
 *
 */
public enum ErrorCodeEnum {

    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    /**
     * 系统维护中...
     */
    SYSTEM_ERROR(-1, "系统维护中..."),
    /**
     * 请求的接口不存在
     */
    API_NOT_EXISTS(1001, "请求的接口不存在"),
    /**
     * 没有该接口的访问权限
     */
    API_NOT_PER(1002, "没有该接口的访问权限"),
    
    
    //常用参数验证失败使用1003
    /**
     * 参数错误常用参数验证失败使用1003
     */
    PARAMS_ERROR(1003, "参数错误"),
    /**
     * 业务异常
     */
    SERVICE_ERROR(1004, "业务异常"),

    /**
     *TOKEN过期了 
     */
    TOKEN_TIMEOUT(1005, "TOKEN过期了"),
    /**
     * TOKEN验证成功
     */
    TOKEN_AUTH_SUCCESS(1006, "TOKEN验证成功"),
    /**
     * TOKEN验证失败
     */
    TOKEN_AUTH_FAILED(1007, "TOKEN验证失败"),
    /**
     * TOKEN校验失败
     */
    TOKEN_FAIL(1008, "TOKEN校验失败"),
    /**
     * AccessToken is Null
     */
    NULL_TOKEN(1009, "AccessToken is Null"),
    /**
     *没有访问权限 
     */
    NO_PERMISSON(1010, "没有访问权限"),


    //------------------------------------------管理中心业务code[10000-20000]----------------------------------------------

    /**
     * 用户锁定
     */
    LOCK_USER(10001, "用户锁定"),
    /**
     * 账号或密码不正确
     */
    LOGIN_FAIL(10002, "账号或密码不正确"),
    /**
     * 
     */
    NEED_LOGIN(10003, "此用户需要登录"),
    /**
     * 账户不存在或被禁用
     */
    ACCOUNT_ERROR(10004, "账户已被禁用"),
    /**
     * IDM认证失败
     */
    IDMAUTH_FAIL(10005, "IDM认证失败"),
    /**
     * 公司已参与本项目
     */
    ALREADY_INVOLVED(10006, "公司已参与本项目"),
    /**
     * 验证码过期
     */
    VCODE_EXPIRED(10007, "验证码过期"),
    /**
     * 请输入正确的验证码
     */
    VCODE_ERROR(10008, "请输入正确的验证码"),
    /**
     * 验证码类型不能为空
     */
    VCODE_TYPE_NOTNULL(10009, "验证码类型不能为空"),
    /**
     * 手机号不能为空
     */
    PHONE_NOTNULL(10010, "手机号不能为空"),

    //跳转迁移页面
    /**
     * 请绑定手机号
     */
    BIND_PHONE_NUMBER(10011,"请绑定手机号"),
    /**
     * 请使用万科账号密码登陆
     */
    USE_IDM_PASSWORD(10012,"请使用万科账号密码登陆"),
    /**
     * 请联系运维
     */
    CONTACT_OPERATION(10013,"请联系运维"),

    /**
     * 手机登录迁移
     */
    MOBILE_LOGIN_MIGRATE(10014,"手机迁移"),

    /**
     * IDM手机迁迁移
     */
    SEND_IDM_REGIST_MESSAGE(10015,"发送迁移IDM成功信息"),

    /**
     * 绑定域账号手机
     */
    BIND_DOMAIN_NUMBER(10016,"请绑定手机号"),


    //------------------------------------------客户业务code[50000-60000]
    /**
     *账户类型为公司时,公司id不能为空
     */
    ACCOUNT_COMPANY_ERROR(50001,"公司id不能为空"),
    /**
     * 信息已存在
     */
    INFORMATION_ALREADY_EXISTS(50002,"信息已存在"),
    /**
     * 调用共享中心接口失败
     */
    FAIL_DATACENTERSERVER(50003,"调用共享中心接口失败"),
    /**
     * 未找到
     */
    NOT_FOUND(50004,"未找到"),

    /**
     * 数量上限
     * */
    MAX_NUM(50005,"数量上限"),
    /**
     * 验证错误
     * */
    VALIDATE(50006,"验证错误"),
    /**
     * 超时
     * */
    TIMEOUT(50007,"超时"),





	//------------------------------------------bp平台业务code[70000-80000]
	BP_PARAM_ERROR(60001,"参数校验失败"),
	
	;
	
	
    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String msg;

    public Integer getCode() {
        return code;
    }

    public ErrorCodeEnum setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ErrorCodeEnum setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    ErrorCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
