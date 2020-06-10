package com.bc.dao.po;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p><b>Title:</b><i> 标识某个字段不录入数据库中
 * 标识该注解的字段将没有增删改查的功能</i></p>
 * <p>Desc: TODO</p>
 * <p>source folder:{@docRoot}</p>
 * <p>Copyright:Copyright(c)2018</p>
 * <p>Company:vanke</p>
 * <p>Create Date:2018年8月30日 上午10:29:27</p>
 * <p>Modified By:wanglz08-</p>
 * <p>Modified Date:2018年8月30日 上午10:29:27</p>
 * @author <a href="mailto:wanglz08@vanke.com title="邮箱地址">wanglz08</a>
 * @version Version 0.1
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TempField {

	 
}
