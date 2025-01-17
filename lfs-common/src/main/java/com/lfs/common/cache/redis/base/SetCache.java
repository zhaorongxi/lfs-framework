package com.lfs.common.cache.redis.base;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * <p><b>Title:</b><i>Set 数据类型</i></p>
 * <p>Desc: TODO</p>
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
@Repository
public class SetCache {
	
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
     * 根据key获取Set中的所有值 
     * @param key 键 
     * @return 
     */  
    public Set<Object> sGet(String key){  
        try {  
            return redisTemplate.opsForSet().members(key);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  

    /** 
     * 根据value从一个set中查询,是否存在 
     * @param key 键 
     * @param value 值 
     * @return true 存在 false不存在 
     */  
    public boolean sHasKey(String key,Object value){  
        try {  
            return redisTemplate.opsForSet().isMember(key, value);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }  

    /** 
     * 将数据放入set缓存 
     * @param key 键 
     * @param values 值 可以是多个 
     * @return 成功个数 
     */  
    public long sSet(String key, Object...values) {  
        try {  
            return redisTemplate.opsForSet().add(key, values);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return 0;  
        }  
    }  

    /** 
     * 将set数据放入缓存 
     * @param key 键 
     * @param time 时间(秒) 
     * @param values 值 可以是多个 
     * @return 成功个数 
     */  
    public long sSetAndTime(String key,long time,Object...values) {  
        try {  
            Long count = redisTemplate.opsForSet().add(key, values);  
            if(time>0) expire(key, time);  
            return count;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return 0;  
        }  
    }  

    /** 
     * 获取set缓存的长度 
     * @param key 键 
     * @return 
     */  
    public long sGetSetSize(String key){  
        try {  
            return redisTemplate.opsForSet().size(key);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return 0;  
        }  
    }  

    /** 
     * 移除值为value的 
     * @param key 键 
     * @param values 值 可以是多个 
     * @return 移除的个数 
     */  
    public long setRemove(String key, Object ...values) {  
        try {  
            Long count = redisTemplate.opsForSet().remove(key, values);  
            return count;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return 0;  
        }  
    }  

}
