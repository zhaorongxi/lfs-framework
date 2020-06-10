package com.bc.dao.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.github.pagehelper.PageHelper;

/**
 * <p><b>Title:</b><i>TODO</i></p>
 * <p>Desc: TODO</p>
 * <p>source folder:{@docRoot}</p>
 * <p>Copyright:Copyright(c)2018</p>
 * <p>Company:vanke</p>
 * <p>Create Date:2018年8月7日 上午11:16:13</p>
 * <p>Modified By:wanglz08-</p>
 * <p>Modified Date:2018年8月7日 上午11:16:13</p>
 * @author <a href="mailto:wanglz08@vanke.com" title="邮箱地址">wanglz08</a>
 * @version Version 0.1
 *
 */
@Configuration//使用@Configuration也可以
@PropertySource("classpath:mybaties-config.properties")//配置文件路径
public class MybatisConfig implements EnvironmentAware{
	   
	private static final Logger log = LoggerFactory.getLogger(MybatisConfig.class);
	
     private Environment env;

    @Override
    public void setEnvironment(final Environment environment) {
        this.env = environment;
    }
	
    @Bean
	public PageHelper mybatisPagehelper(){
		log.info("====================");
		log.info("mybatis.mapper-locations:"+env.getProperty("mybatis.mapper-locations"));
		log.info("mybatis配置加载完成");
		return null;
		
	}
    
	@Bean
	@ConfigurationProperties("spring.datasource.druid")
	public DataSource dataSource() {
		return DruidDataSourceBuilder.create().build();
	}

}
