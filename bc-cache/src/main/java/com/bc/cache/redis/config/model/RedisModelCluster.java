package com.bc.cache.redis.config.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import com.bc.base.exception.BusinessException;
import com.bc.cache.base.CacheConstants;

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

public class RedisModelCluster implements Condition{
	
	private final Logger logger = LoggerFactory.getLogger(RedisModelCluster.class);
	
/*	@Value("${spring.redis.mode}")
	private String redisMode;
*/
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
		return  CacheConstants.REDIS_MODEL_CLUSTER.equals(redisMode);
	}
	
	

}
