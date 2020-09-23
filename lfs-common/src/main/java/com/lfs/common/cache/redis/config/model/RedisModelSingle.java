package com.lfs.common.cache.redis.config.model;

import com.lfs.common.cache.base.CacheConstants;
import com.lfs.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * <p><b>Title:</b><i>集群模式</i></p>
 * <p>Desc: TODO</p>
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
public class RedisModelSingle implements Condition{
	
	private final Logger logger = LoggerFactory.getLogger(RedisModelSingle.class);

	
	@Override
	public boolean matches(ConditionContext context,AnnotatedTypeMetadata metadata) {
		String redisMode = context.getEnvironment().getProperty("spring.redis.mode");
		logger.info("===spring.redis.mode==:"+redisMode);
		   try{
			   if(null==redisMode||redisMode.equals("")){
					throw new BusinessException("===spring.redis.mode== 不能为 NULL");
				}  
		   } catch(BusinessException s){
			   s.printStackTrace();
		   }
		return  CacheConstants.REDIS_MODEL_SINGLE.equals(redisMode);
	}
	
	

}
