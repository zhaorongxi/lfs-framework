package com.lfs.base.exception;

/**
 * @description: 统一异常返回类
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
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
