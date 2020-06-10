package com.bc.base.exception;

/**
 * @program: VBIM
 * @description: 统一异常返回类
 * @author: Dylan
 * @create: 2018-11-28 16:19
 **/
public class ApiException extends RuntimeException {
    private String errMsg;
    private String errCode;

    public ApiException(String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
    }

    public ApiException(String errMsg, Throwable e) {
        super(errMsg, e);
        this.errMsg = errMsg;
    }

    public ApiException(String errCode, String errMsg) {
       super(errMsg);
        this.errMsg = errMsg;
        this.errCode = errCode;
    }

    public ApiException(String errMsg, String errCode, Throwable e) {
        super(errMsg, e);
        this.errMsg = errMsg;
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
}
