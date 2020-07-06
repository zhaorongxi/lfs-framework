package com.bc.base.exception;

/**
 * @description: service 自定义业务统一异常
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
public class ServiceException extends BusinessException {

    public ServiceException(Integer errCode,String errMsg) {
        super(errCode,errMsg );
    }

}
