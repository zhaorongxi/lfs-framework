package com.bc.mongo;


/**
 * <p><b>Title:</b><i>Mongo操作</i></p>
 * <p>Desc: 对mongo操作封装</p>
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
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
