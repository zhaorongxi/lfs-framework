package com.bc.mongo;


/**
 * <p><b>Title:</b><i>Mongo操作</i></p>
 * <p>Desc: 对mongo操作封装</p>
 * <p>source folder:{@docRoot}</p>
 * <p>Copyright:Copyright(c)2018</p>
 * <p>Company:vanke</p>
 * <p>Create Date:2018年11月29日 下午5:18:48</p>
 * <p>Modified By:wanglz08-</p>
 * <p>Modified Date:2018年11月29日 下午5:18:48</p>
 * @author <a href="mailto:wanglz08@vanke.com" title="邮箱地址">wanglz08</a>
 * @version Version 0.1
 *
 */
public class MongoBase {
	
    /**
	 * 
	   *方法用途: MongoDao 公共操作类<br>
	   * 操作步骤: 业务直接引用<br>
	 * @return
	 */
	public static <T> MongoDao<T> getMongo(Class<T> calzz){
		MongoDao<T> dao = new MongoDao<T>(calzz);
			return dao;
	  } 

}
