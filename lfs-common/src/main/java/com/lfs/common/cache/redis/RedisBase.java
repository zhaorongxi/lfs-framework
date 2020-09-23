package com.lfs.common.cache.redis;


import com.lfs.common.cache.redis.base.*;
import com.lfs.common.exception.UncheckedException;
import com.lfs.common.utils.spring.SpringUtils;

/**
 * <p><b>Title:</b><i>TODO</i></p>
 * <p>Desc: TODO</p>
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
public class RedisBase {
	
	  /**
	 * 
	 * 方法用途: Redis 公共操作类<br>
	 * 操作步骤: TODO<br>
	 * @return
	 */
	public static CommonCache getCommonCache(){
		  CommonCache dao = SpringUtils.getBean(CommonCache.class);
			if(dao == null) {
				throw new UncheckedException("无法获取到CommonCache.class的dao，请检查是否已经初始化了");
			}
			return dao;
	  } 
	  
	  /**
	 * 
	 * 方法用途: String 数据类型<br>
	 * 操作步骤: TODO<br>
	 * @return
	 */
	public static StringCache getStringCache(){
		  StringCache dao =SpringUtils.getBean(StringCache.class);
			if(dao == null) {
				throw new UncheckedException("无法获取到StringCache.class的dao，请检查是否已经初始化了");
			}
			return dao;
	  }
	  
	  /**
	 * 
	 * 方法用途: Map  数据类型<br>
	 * 操作步骤: TODO<br>
	 * @return
	 */
	public static MapCache getMapCache(){
		  MapCache dao =SpringUtils.getBean(MapCache.class);
			if(dao == null) {
				throw new UncheckedException("无法获取到MapCache.class的dao，请检查是否已经初始化了");
			}
			return dao;
	  }
	  
	  /**
	 * 
	 * 方法用途: Set  数据类型<br>
	 * 操作步骤: TODO<br>
	 * @return
	 */
	public static SetCache getSetCache(){
		  SetCache dao =SpringUtils.getBean(SetCache.class);
			if(dao == null) {
				throw new UncheckedException("无法获取到SetCache.class的dao，请检查是否已经初始化了");
			}
			return dao;
	  }
	  
	  /**
	 * 
	 * 方法用途: List  数据类型<br>
	 * 操作步骤: TODO<br>
	 * @return
	 */
	public static ListCache getListCache(){
		  ListCache dao =SpringUtils.getBean(ListCache.class);
			if(dao == null) {
				throw new UncheckedException("无法获取到ListCache.class的dao，请检查是否已经初始化了");
			}
			return dao;
	  }
	  
	  
	  
	  
}
