package com.bc.cache.redis.base;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * <p><b>Title:</b><i>List 数据类型</i></p>
 * <p>Desc: TODO</p>
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
@Repository
public class ListCache {
	
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
     * 获取list缓存的内容 
     * @param key 键 
     * @param start 开始 
     * @param end 结束  0 到 -1代表所有值 
     * @return 
     */  
    public List<Object> lGet(String key,long start, long end){  
        try {  
            return redisTemplate.opsForList().range(key, start, end);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  

    /** 
     * 获取list缓存的长度 
     * @param key 键 
     * @return 
     */  
    public long lGetListSize(String key){  
        try {  
            return redisTemplate.opsForList().size(key);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return 0;  
        }  
    }  

    /** 
     * 通过索引 获取list中的值 
     * @param key 键 
     * @param index 索引  index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推 
     * @return 
     */  
    public Object lGetIndex(String key,long index){  
        try {  
            return redisTemplate.opsForList().index(key, index);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  

    /** 
     * 将list放入缓存 
     * @param key 键 
     * @param value 值 
     * @param time 时间(秒) 
     * @return 
     */  
    public boolean lSet(String key, Object value) {  
        try {  
            redisTemplate.opsForList().rightPush(key, value);  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }  

    /** 
     * 将list放入缓存 
     * @param key 键 
     * @param value 值 
     * @param time 时间(秒) 
     * @return 
     */  
    public boolean lSet(String key, Object value, long time) {  
        try {  
            redisTemplate.opsForList().rightPush(key, value);  
            if (time > 0) expire(key, time);  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }  

    /** 
     * 将list放入缓存 
     * @param key 键 
     * @param value 值 
     * @param time 时间(秒) 
     * @return 
     */  
    public boolean lSet(String key, List<Object> value) {  
        try {  
            redisTemplate.opsForList().rightPushAll(key, value);  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }  

    /** 
     * 将list放入缓存 
     * @param key 键 
     * @param value 值 
     * @param time 时间(秒) 
     * @return 
     */  
    public boolean lSet(String key, List<Object> value, long time) {  
        try {  
            redisTemplate.opsForList().rightPushAll(key, value);  
            if (time > 0) expire(key, time);  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }  

    /** 
     * 根据索引修改list中的某条数据 
     * @param key 键 
     * @param index 索引 
     * @param value 值 
     * @return 
     */  
    public boolean lUpdateIndex(String key, long index,Object value) {  
        try {  
            redisTemplate.opsForList().set(key, index, value);  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }   

    /** 
     * 移除N个值为value  
     * @param key 键 
     * @param count 移除多少个 
     * @param value 值 
     * @return 移除的个数 
     */  
    public long lRemove(String key,long count,Object value) {  
        try {  
            Long remove = redisTemplate.opsForList().remove(key, count, value);  
            return remove;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return 0;  
        }  
    } 

}
