package com.bc.base.aspect;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p><b>Title:</b><i>TODO</i></p >
 * <p>Desc: TODO</p >
 * <p>source folder:com.bc.base.aspect.UnLogAspect</p >
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Company:vanke</p >
 * <p>Create Date:2018/12/6 下午3:00</p >
 * <p>Modified By:v-mol01</p >
 * <p>Modified Date:2018/12/6 下午3:00</p >
 *
 * @author <a href=" " title="邮箱地址">v-mol01@vanke.com</a >
 * @version Version 0.1
 */
@Component
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UnLogAspect {

}
