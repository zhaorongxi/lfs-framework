package com.bc.cache.redis.base;

import java.util.concurrent.TimeUnit;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

/**
 * <p><b>Title:</b><i>Redis 公共操作</i></p>
 * <p>Desc: TODO</p>
 * <p>source folder:{@docRoot}</p>
 * <p>Copyright:Copyright(c)2018</p>
 * <p>Company:vanke</p>
 * <p>Create Date:2018年7月25日 下午6:07:24</p>
 * <p>Modified By:wanglz08-</p>
 * <p>Modified Date:2018年7月25日 下午6:07:24</p>
 * @author <a href="mailto:wanglz08@vanke.com" title="邮箱地址">wanglz08</a>
 * @version Version 0.1
 *
 */
@Repository
public class CommonCache{
	
    private RedisTemplate<String,Object> redisTemplate;
	
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {  
	        this.redisTemplate = redisTemplate;  
	}

	/** 
     * 指定缓存失效时间 
     * @param key 键 
     * @param time 时间(秒) 
     * @return 
     */  
    public boolean expire(String key,long time){  
        try {  
            if(time>0){  
                redisTemplate.expire(key, time, TimeUnit.SECONDS);  
            }  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }  

    /** 
     * 根据key 获取过期时间 
     * @param key 键 不能为null 
     * @return 时间(秒) 返回0代表为永久有效 
     */  
    public long getExpire(String key){  
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);  
    }  

    /** 
     * 判断key是否存在 
     * @param key 键 
     * @return true 存在 false不存在 
     */  
    public boolean hasKey(String key){  
        try {  
            return redisTemplate.hasKey(key);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }  

    /** 
     * 删除缓存 
     * @param key 
     */  
    public boolean delete(String key) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() { 
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException { 
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer(); 
                byte[] keys  = serializer.serialize(key); 
                connection.del(keys);
                return true; 
            } 
        }); 
        return result;
    }
}
