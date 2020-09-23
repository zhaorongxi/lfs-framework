package com.lfs.common.core.redis.config;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
/**
 * @ProjectName:
 * @Package: com.lfs.base.utils
 * @ClassName: ApplicationContextProvider
 * @Description: 获取bean对象的工具类
 * @Author: v-zhaorx04
 * @CreateDate: 2019/226 13:26
 * @Version: 1.0
 */

/**
 * Author:v-zhaorx04
 * Date:2019/02/28
 */
@Component
public class RedisContextUtils implements ApplicationContextAware {
 /**
  * 上下文对象实例
  */
 private static  ApplicationContext applicationContext;

 /**
  * 设置获取上下文
  * @param applicationContext
  * @throws BeansException
  */
 @Override
 public void  setApplicationContext(ApplicationContext applicationContext) throws BeansException {
  RedisContextUtils.applicationContext = applicationContext;
 }
 /**
  * 获取applicationContext
  *
  * @return
  */
 public static ApplicationContext getApplicationContext() {
  return applicationContext;
 }
 /**
  * 通过name获取 Bean.
  *
  * @param name
  * @return
  */
 public static Object getBean(String name) {
  return getApplicationContext().getBean(name);
 }
 /**
  * 通过class获取Bean.
  *
  * @param clazz
  * @param <T>
  * @return
  */
 public static <T> T getBean(Class<T> clazz) {
  return getApplicationContext().getBean(clazz);
 }
 /**
  * 通过name,以及Clazz返回指定的Bean
  *
  * @param name
  * @param clazz
  * @param <T>
  * @return
  */
 public static <T> T getBean(String name, Class<T> clazz) {
  return getApplicationContext().getBean(name, clazz);
 }

 /**
  * 获取aop代理对象
  *
  * @param invoker
  * @return
  */
 @SuppressWarnings("unchecked")
 public static <T> T getAopProxy(T invoker)
 {
  return (T) AopContext.currentProxy();
 }

}