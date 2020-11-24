package com.lfs.base.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.lang.reflect.Method;

/**
 *
 * @author linxi
 * @version Version 0.1
 */
@Aspect
@Service
public class ServiceLogAspect {
    private  final Logger logger = LoggerFactory.getLogger(ServiceLogAspect.class);

    /**
     * 方法用途: 拦截service和rpc下的所有pubic方法，执行切面<br/>
     * 操作步骤: TODO<br/>
     * ${tags}
     */
    @Pointcut("execution(* com.lfs..*Dao.*(..)) ")
    public void anyMethod(){
    }

    /**
     * 方法用途: 环绕监控，打印方法请求前的调用参数信息，方法请求后的返回信息及方法调用时长<br/>
     * 操作步骤: TODO<br/>
     * ${tags}
     */
    @Around(value = "anyMethod()")
    public Object timeAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Class<?>[] argTypes = new Class[joinPoint.getArgs().length];
        for (int i = 0; i < args.length; i++) {
            if (null != args[i]) {
                argTypes[i] = args[i].getClass();
            }
        }
        Method method = null;
        Object obj = null;
        try {
            method = joinPoint.getTarget().getClass()
                    .getMethod(joinPoint.getSignature().getName(), argTypes);
            if (null != method) {
                UnLogAspect ma = method.getAnnotation(UnLogAspect.class);
                if (null == ma) {
                    // 定义返回对象、得到方法需要的参数

                    long startTime = System.currentTimeMillis();
                    String methodName = joinPoint.getSignature().getDeclaringType().getSimpleName() + "." + joinPoint.getSignature().getName();
                    Object[] o = new Object[joinPoint.getArgs().length];
                    for (int i = 0; i < joinPoint.getArgs().length; i++) {
                        if (!(joinPoint.getArgs()[i] instanceof MultipartFile || joinPoint.getArgs()[i] instanceof File)) {
                            o[i] = joinPoint.getArgs()[i];
                        }
                    }
                    this.logger.info("\n#######Service方法：【" + methodName + "】开始执行，请求参数为：" + JSON.toJSONString(o));
                    obj = joinPoint.proceed(args);
                    long endTime = System.currentTimeMillis();
                    // 打印耗时的信息
                    this.logger.info("\n#######Service方法：【" + methodName + "】,当次执行时间为：【" + (endTime - startTime) / 1000.0 + "秒】");
                    this.logger.info("\n#######Service方法：【" + methodName + "】执行结束，返回参数为：" + JSON.toJSONString(obj));
                    return obj;
                } else {
                    return joinPoint.proceed(args);
                }
            }else {
                return joinPoint.proceed(args);
            }
        } catch (NoSuchMethodException e) {
            return joinPoint.proceed(args);
        } catch (SecurityException e) {
            return joinPoint.proceed(args);
        }

    }
}
