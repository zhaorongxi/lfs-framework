package com.lfs.cache.redis.config;

import com.lfs.cache.redis.config.model.RedisModelCluster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

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
public class ClusterConfig {
	private final Logger logger = LoggerFactory.getLogger(ClusterConfig.class);

    @Value("${spring.redis.cluster.nodes}")
    private String clusterNodes; 

    @Value("${spring.redis.cluster.max-redirects}")
    private Integer mmaxRedirectsac;
    
    @Value("${spring.redis.hosts.password}")
    private String password;


    /**
     * Redis集群的配置
    * @return RedisClusterConfiguration
    * @autor lpl
    * @date 2017年12月22日
    * @throws
     */
    @Bean
    @Conditional(RedisModelCluster.class)
    public RedisClusterConfiguration redisClusterConfiguration(){
    	logger.info("redis创建集群模式配置...........");
        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
        //Set<RedisNode> clusterNodes
        String[] serverArray = clusterNodes.split(",");

        Set<RedisNode> nodes = new HashSet<RedisNode>();

        for(String ipPort:serverArray){
            String[] ipAndPort = ipPort.split(":");
            nodes.add(new RedisNode(ipAndPort[0].trim(),Integer.valueOf(ipAndPort[1])));
        }

        redisClusterConfiguration.setClusterNodes(nodes);
        redisClusterConfiguration.setMaxRedirects(mmaxRedirectsac);

        return redisClusterConfiguration;
    }
    /**
     * 配置工厂
    * @Title: JedisConnectionFactory 
    * @param @param jedisPoolConfig
    * @param @return
    * @return JedisConnectionFactory
    * @autor lpl
    * @date 2017年12月22日
    * @throws
     */
    @Bean
    @Conditional(RedisModelCluster.class)
    public JedisConnectionFactory JedisConnectionFactory(JedisPoolConfig jedisPoolConfig,RedisClusterConfiguration redisClusterConfiguration){
    	logger.info("使用Jedis 配置工厂开始.............");
        JedisConnectionFactory JedisConnectionFactory = new JedisConnectionFactory(redisClusterConfiguration,jedisPoolConfig);
        JedisConnectionFactory.setPassword(password);
        logger.info("使用Jedis 配置工厂结束.............");
        return JedisConnectionFactory; 
    }
    

}
