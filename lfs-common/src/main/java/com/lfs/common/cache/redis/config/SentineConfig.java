package com.lfs.common.cache.redis.config;

import com.lfs.common.cache.redis.config.model.RedisModelSentine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * <p><b>Title:</b><i>哨兵模式</i></p>
 * <p>Desc: TODO</p>
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
@Configuration
public class SentineConfig {

	private final Logger logger = LoggerFactory.getLogger(SentineConfig.class);
	
  //配置matser的名称
    @Value("${redis.hostName}")
    private String hostName; 
    
    @Value("${redis.port}")
    private Integer port;

  //配置redis的哨兵sentinel

    @Value("${redis.sentinel.host1}")
    private String senHost1; 
    @Value("${redis.sentinel.port1}")
    private Integer senPort1;


/**
     * 配置redis的哨兵
    * @return RedisSentinelConfiguration
    * @autor lpl
    * @date 2017年12月21日
    * @throws
     */
    @Bean
    @Conditional(RedisModelSentine.class)
    public RedisSentinelConfiguration sentinelConfiguration(){
    	logger.info("redis创建哨兵模式配置...........");
        RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration();
        //配置matser的名称
        RedisNode redisNode = new RedisNode(hostName, port);
        redisNode.setName("mymaster");
        redisSentinelConfiguration.master(redisNode);
        //配置redis的哨兵sentinel
        RedisNode senRedisNode = new RedisNode(senHost1,senPort1);
        Set<RedisNode> redisNodeSet = new HashSet<>();
        redisNodeSet.add(senRedisNode);
        redisSentinelConfiguration.setSentinels(redisNodeSet);
        return redisSentinelConfiguration;
    }
    /**
     * 配置工厂
     * @param jedisPoolConfig
     * @return
     */
    @Bean
    @Conditional(RedisModelSentine.class)
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig,RedisSentinelConfiguration sentinelConfig) {   
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(sentinelConfig,jedisPoolConfig);
        return jedisConnectionFactory;
    }
    
}
