package com.lfs.common.cache.redis.base;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * <p><b>Title:</b><i>String 数据类型</i></p>
 * <p>Desc: TODO</p>
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
@Repository
public class StringCache {
	
    private RedisTemplate<String,Object> redisTemplate;
	
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {  
	        this.redisTemplate = redisTemplate;  
	}
	
	 /** 
     * 普通缓存获取 
     * @param key 键 
     * @return 值 
     */  
    public Object get(String key){  
        return key==null?null:redisTemplate.opsForValue().get(key);  
    }  

    /** 
     * 普通缓存放入 
     * @param key 键 
     * @param value 值 
     * @return true成功 false失败 
     */  
    public boolean  set(String key,Object value) {  
         try {  
            redisTemplate.opsForValue().set(key, value);  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  

    }  

    /** 
     * 普通缓存放入并设置时间 
     * @param key 键 
     * @param value 值 
     * @param time 时间(秒) time要大于0 如果time小于等于0 将设置无限期 
     * @return true成功 false 失败 
     */  
    public boolean set(String key,Object value,long time){  
        try {  
            if(time>0){  
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);  
            }else{  
                set(key, value);  
            }  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }  

    /** 
     * 递增 
     * @param key 键 
     * @param by 要增加几(大于0) 
     * @return 
     */  
    public long incr(String key, long delta){    
        if(delta<0){  
            throw new RuntimeException("递增因子必须大于0");  
        }  
        return redisTemplate.opsForValue().increment(key, delta);  
    }  

    /** 
     * 递减 
     * @param key 键 
     * @param by 要减少几(小于0) 
     * @return 
     */  
    public long decr(String key, long delta){    
        if(delta<0){  
            throw new RuntimeException("递减因子必须大于0");  
        }  
        return redisTemplate.opsForValue().increment(key, -delta);    
    } 

}
