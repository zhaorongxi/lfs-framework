package com.bc.base.exception;

/**
 * @program: VBIM
 * @description: service 自定义业务统一异常
 * @author: Dylan
 * @create: 2018-11-28 16:09
 **/
public class ServiceException extends BusinessException {

    public ServiceException(Integer errCode,String errMsg) {
        super(errCode,errMsg );
    }

}
