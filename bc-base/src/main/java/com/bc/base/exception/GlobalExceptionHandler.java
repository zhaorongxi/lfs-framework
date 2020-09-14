package com.bc.base.exception;

import com.bc.base.dto.Result;
import com.bc.base.enums.HttpStatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * <p><b>Title:</b><i>全局异常处理</i></p >
 * <p>Desc: 处理throws的异常</p >
 * <p>source folder:com.bc.base.exception.GlobalExceptionHandler</p >
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private  final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);




    /**
     * 特别说明： 可以配置指定的异常处理,这里处理所有
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Result<String> errorHandler(HttpServletRequest request, Exception exception) {
        String errorMsg = "";
        Integer code = HttpStatusEnum.INTERNAL_SERVER_ERROR.value();
        Result<String> result = new Result<String>();
        result.setSuccess(false);
        if (exception instanceof NullPointerException){
            errorMsg = "发生空指针异常";
        }
        else if (exception instanceof RuntimeException){
            errorMsg = "发生运行时异常";
        }
        exception.printStackTrace();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        exception.printStackTrace(new PrintStream(baos));
        String exceptionmsg = baos.toString();
        this.logger.error("#######调用接口："+request.getRequestURI()+"，执行时发生："+ errorMsg+",\n"+exceptionmsg);
        result.setCode(code);
        result.setMessage(errorMsg);
        return result;
    }


    /**
     * 业务错误处理
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    public Result<String> BusinessException(HttpServletRequest request, BusinessException exception) {
        String errorMsg = "";
        Integer code = HttpStatusEnum.INTERNAL_SERVER_ERROR.value();
        Result<String> result = new Result<String>();
        result.setSuccess(false);
        if (exception instanceof BusinessException){
            errorMsg =exception.getMessage();
            code = exception.getCode();
        }
        result.setCode(code);
        result.setMessage(errorMsg);
        this.logger.error("\n#######调用接口："+request.getRequestURI()+"，业务错误：状态码【"+code+"】,错误信息【"+errorMsg+"】");
        return result;
    }
}
