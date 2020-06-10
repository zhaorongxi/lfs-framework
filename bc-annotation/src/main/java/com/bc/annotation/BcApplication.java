package com.bc.annotation;

import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * <p><b>Title:</b><i>封装启动类注解</i></p >
 * <p>Desc: 继承springbootApplication,enableDiscoveryClient,componentScan 注解，
 * 此注解目的在于，维护公共的微服务启动类注解，默认扫描framework中的配置，将此配置统一维护，避免放于各个微服务中去维护，减少后续改动时的成本
 * componentScan注解默认扫描包：com.bc.*
 * 若需自定义，参考以下使用方式：
 * 第一个参数为com.bc.*,第二个开始为自定义扫描包
 * @VkApplication（"{com.bc.*,pages}"）
 * </p >
 * <p>source folder:com.bc.annotation.BcApplication</p >
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Company:vanke</p >
 * <p>Create Date:2018/9/2 上午9:44</p >
 * <p>Modified By:v-mol01</p >
 * <p>Modified Date:2018/9/2 上午9:44</p >
 *
 * @author <a href=" " title="邮箱地址">v-mol01@vanke.com</a >
 * @version Version 0.1
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(
    excludeFilters = {@ComponentScan.Filter(
            type = FilterType.CUSTOM,
            classes = {TypeExcludeFilter.class}
    ), @ComponentScan.Filter(
            type = FilterType.CUSTOM,
            classes = {AutoConfigurationExcludeFilter.class}
    )}
)
public @interface BcApplication {

    @AliasFor(
            annotation = EnableAutoConfiguration.class
    )
    Class<?>[] exclude() default {};

    @AliasFor(
            annotation = EnableAutoConfiguration.class
    )
    String[] excludeName() default {};

    @AliasFor(
            annotation = ComponentScan.class,
            attribute = "basePackages"
    )
    String[] value() default {"com.bc.*"};


    @AliasFor(
            annotation = ComponentScan.class,
            attribute = "basePackageClasses"
    )
    Class<?>[] scanBasePackageClasses() default {};
}
