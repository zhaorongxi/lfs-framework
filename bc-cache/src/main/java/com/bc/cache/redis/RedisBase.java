package com.bc.cache.redis;

import com.bc.base.exception.UncheckedException;
import com.bc.base.util.SpringUtil;
import com.bc.cache.redis.base.CommonCache;
import com.bc.cache.redis.base.ListCache;
import com.bc.cache.redis.base.MapCache;
import com.bc.cache.redis.base.SetCache;
import com.bc.cache.redis.base.StringCache;

/**
 * <p><b>Title:</b><i>TODO</i></p>
 * <p>Desc: TODO</p>
 * <p>source folder:{@docRoot}</p>
 * <p>Copyright:Copyright(c)2018</p>
 * <p>Company:vanke</p>
 * <p>Create Date:2018年7月25日 下午6:09:10</p>
 * <p>Modified By:wanglz08-</p>
 * <p>Modified Date:2018年7月25日 下午6:09:10</p>
 * @author <a href="mailto:wanglz08@vanke.com" title="邮箱地址">wanglz08</a>
 * @version Version 0.1
 *
 */
public class RedisBase {
	
	  /**
	 * 
	 * 方法用途: Redis 公共操作类<br>
	 * 操作步骤: TODO<br>
	 * @return
	 */
	public static CommonCache getCommonCache(){
		  CommonCache dao =SpringUtil.getBean(CommonCache.class);
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
		  StringCache dao =SpringUtil.getBean(StringCache.class);
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
		  MapCache dao =SpringUtil.getBean(MapCache.class);
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
		  SetCache dao =SpringUtil.getBean(SetCache.class);
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
		  ListCache dao =SpringUtil.getBean(ListCache.class);
			if(dao == null) {
				throw new UncheckedException("无法获取到ListCache.class的dao，请检查是否已经初始化了");
			}
			return dao;
	  }
	  
	  
	  
	  
}
