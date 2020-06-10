package com.bc.base.enums;

public enum  ReturnCodeEnum {

    ACCOUNT_ERROR(1000, "账户不存在或被禁用"),
    LOCK_USER(10001, "此用户已被锁定"),
    LOGIN_FAIL(10002,"账号或密码不正确"),
    NEED_LOGIN(10003,"此用户需要登录"),
    SYSTEM_ERROR(9999, "系统异常");

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

    public String getMsg() {
        return msg;
    }

    ReturnCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
