package com.bc.dao.conn;

import com.bc.base.exception.BusinessException;
import com.bc.base.util.SpringUtil;



/**
 * <p><b>Title:</b><i>TODO</i></p>
 * <p>Desc: TODO</p>
 * <p>source folder:{@docRoot}</p>
 * <p>Copyright:Copyright(c)2018</p>
 * <p>Company:vanke</p>
 * <p>Create Date:2018年7月26日 下午5:42:03</p>
 * <p>Modified By:wanglz08-</p>
 * <p>Modified Date:2018年7月26日 下午5:42:03</p>
 * @author <a href="mailto:wanglz08@vanke.com" title="邮箱地址">wanglz08</a>
 * @version Version 0.1
 *
 */
public class BaseDao {

	/**
	 * 方法用途: 获取业务实体类对应的dao实例<br>
	 * 操作步骤: 1.第一步：对于的实体类必须实现基于IdEntity的实体或是IdEntity本身
	 *        2.第二步：必须在对于的实体类上标注javax.persistence.Entity注解,才能动态生成对应的dao操作类
	 *        3.第三步：必须在对于的实体类上标注javax.persistence.Table注解,并指定表名，才能知道具体操作哪个表，
	 *        。。。。具体的信息，参照com.meizu.entity.Test类<br>
	 * @param classz 业务实体类
	 * @return
	 */
	public static <T> Dao<T> getIns (Class<T> entity) {

		Dao<T> dao = new Dao<T>();
		if(dao == null) {
			throw new BusinessException("无法获取到"+entity.getName()+"实体对应的dao，请检查下实体是否有标注注解：@Entity和@TableName(name='demo')");
		}
		dao.initDao(entity);
		return dao;
	}
	
	/**
	 * 
	 * 方法用途: 参考<code> getIns(Class<T> classz)</code><br>
	 * 操作步骤: TODO<br>
	 * @param className 业务实体类的名称
	 * @return
	 */
	public static <T>  Dao<T> getIns (String className) {
		char[] chars = className.toCharArray();
		chars[0] = Character.toLowerCase(chars[0]);
		Dao<T> dao = (Dao<T>) SpringUtil.getApplicationContext().getBean(className);
		if(dao == null) {
			throw new BusinessException("无法获取到"+className+"实体对应的dao，请检查下实体是否有标注注解：@Entity和@TableName(name='demo')");
		}
		//dao.setIndex(null);
		return null;
	}
}
