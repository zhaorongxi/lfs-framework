package com.bc.cache.redis.config;

import com.bc.cache.redis.config.model.RedisModelSingle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

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
@Configuration
//@PropertySource("classpath:redis-config.properties")
public class SingleConfig {
	private final Logger logger = LoggerFactory.getLogger(SingleConfig.class);


    //配置matser的名称
    @Value("${redis.hostName}")
    private String hostName; 
    
    @Value("${redis.port}")
    private Integer port;
    
    @Value("${redis.password}")
    private String password;
    
    /**
     * 单机版配置
    * @Title: JedisConnectionFactory 
    * @param @param jedisPoolConfig
    * @param @return
    * @return JedisConnectionFactory
    * @throws
     */
    @Bean
    @Conditional(RedisModelSingle.class)
    public JedisConnectionFactory JedisConnectionFactory(JedisPoolConfig jedisPoolConfig){
    	logger.info("redis创建单机版配置...........");
        JedisConnectionFactory JedisConnectionFactory = new JedisConnectionFactory(jedisPoolConfig);
        //连接池  
        JedisConnectionFactory.setPoolConfig(jedisPoolConfig);  
        //IP地址  
        JedisConnectionFactory.setHostName(hostName);  
        //端口号  
        JedisConnectionFactory.setPort(port);  
        //如果Redis设置有密码  
        JedisConnectionFactory.setPassword(password);  
        //客户端超时时间单位是毫秒  
        JedisConnectionFactory.setTimeout(5000);  
        return JedisConnectionFactory; 
    }

  
}
