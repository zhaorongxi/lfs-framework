package com.bc.dao.po;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * <p><b>Title:</b><i>实体类字段约束注解
 * 标有此注解的字段对应数据库中的字段名强制约束为该注解中的name值</i></p>
 * <p>Desc: TODO</p>
 * <p>source folder:{@docRoot}</p>
 * <p>Copyright:Copyright(c)2018</p>
 * <p>Company:vanke</p>
 * <p>Create Date:2018年8月30日 上午10:28:22</p>
 * <p>Modified By:wanglz08-</p>
 * <p>Modified Date:2018年8月30日 上午10:28:22</p>
 * @author <a href="mailto:wanglz08@vanke.com title="邮箱地址">wanglz08</a>
 * @version Version 0.1
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldName {

	String name() default PUBVALUE.FIELD_NAME_DEFAUL_VALUE;
}
