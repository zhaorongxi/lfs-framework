package com.bc.elasticsearch.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
@Configuration
public class ESconfig {
    private final static Logger logger = LoggerFactory.getLogger(ESconfig.class);

    //是否有集群
    @Value("${cluster.frag}")
    private boolean clusterFrag;

    //单个ES连接的ip
    @Value("${elasticsearch.ip}")
    private String elasticsearchIp;
   //单个ES的端口
    @Value("${elasticsearch.port}")
    private Integer elasticsearchPort;

    //集群的情况下,ES的节点配置,配置为下面eg的形式  ip+port,集群的集器用 , 分割
    //eg: elasticsearch.cluster.nodes = 10.72.8.87:9300,10.72.8.88:9300,10.72.8.89:9300
    @Value("${elasticsearch.cluster.nodes}")
    private String elasticsearchClusterNodes;


    @Value("${clusterName}")
    private  String clusterName;

    /**
     * 初始化ES连接
     * @return
     */
    @Bean(destroyMethod = "close")
    public TransportClient transportClient() {
        Settings settings = Settings.builder().put("cluster.name", clusterName).build();
        final TransportClient transportClient = new PreBuiltTransportClient(settings);
        //配置ES集群的情况
        if (clusterFrag){
            String[] hostPorts = elasticsearchClusterNodes.split(",");
            Arrays.stream(hostPorts).forEach(hostPort ->{
                String[] ipPort=hostPort.split(":");
                transportClient.addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress(ipPort[0],Integer.parseInt(ipPort[1]))));
            });
            return transportClient;
        }else {
            //没有配置集群的情况下
            try {
                InetSocketTransportAddress node = new InetSocketTransportAddress(InetAddress.getByName(elasticsearchIp), elasticsearchPort);
                transportClient.addTransportAddress(node);
            } catch (UnknownHostException e) {
                e.printStackTrace();
                logger.error("TransportClient ERROR ");
            }
            return transportClient;
        }
    }
}
