package com.bc.base.util;

import com.bc.base.exception.BusinessException;
import com.bc.base.exception.UncheckedException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.util.ArrayList;
import java.util.List;
/**
 * <p><b>Title:</b><i>TODO</i></p>
 * <p>Desc: TODO</p>
 * <p>source folder:{@docRoot}</p>
 * <p>Copyright:Copyright(c)2018</p>
 * <p>Company:vanke</p>
 * <p>Create Date:2018年8月2日 下午4:04:13</p>
 * <p>Modified By:wanglz08-</p>
 * <p>Modified Date:2018年8月2日 下午4:04:13</p>
 * @author <a href="mailto:wanglz08@vanke.com title="邮箱地址">wanglz08</a>
 * @version Version 0.1
 *
 */
//@Component
//@Lazy(false)
public class SpringContext implements ApplicationContextAware {
	// Spring上下文环境
	private static ApplicationContext applicationContext;
	
	
	/**  
	 * 实现ApplicationContextAware接口的回调方法，设置上下文环境  
	 *   
	 * @param context  
	 */
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		applicationContext = context;
	}

	/**
	 * 
	 * 方法用途: TODO<br>
	 * 操作步骤: TODO<br>
	 * @return applicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	/**
	 * 
	 * 方法用途: 获取Spring容器中对象 <br>
	 * 操作步骤: 这里重写了bean方法，起主要作用  <br>
	 * @param <T>   bean类型
	 * @param name  bean名称  
	 * @return 返回指定名称的bean。
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getInstance(String name) {
		Object obj = null;
		try {
			if (applicationContext == null) {
				throw new BusinessException("ApplicationContext注入失败");
			}
			obj = applicationContext.getBean(name);
		} catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
			throw new NoSuchBeanDefinitionException(noSuchBeanDefinitionException.getMessage());
		} catch (BeansException e) {
			throw new BusinessException(e.getMessage());
		}
		return (T)obj;
	}
	

	/**
	 * 
	 * 方法用途: 获取Spring容器中对象<br>
	 * 操作步骤: TODO<br>
	 * @param clazz
	 * @return 
	 */
	public static <T> T getInstance(Class<T> clazz) {
		T obj = null;
		try {
			obj = applicationContext.getBean(clazz);
		} catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
			noSuchBeanDefinitionException.printStackTrace();
			return null;
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		return obj;
	}
	
	
	
	/**
	 * 根据通配符资源路径获取资源列表。
	 * 
	 * @param wildcardResourcePaths
	 *            通配符资源路径
	 * @return 返回资源列表。
	 */
	public static List<Resource> getResourcesByWildcard(
			String... wildcardResourcePaths) {
		List<Resource> resources = new ArrayList<Resource>();
		try {
			ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
			for (String basename : wildcardResourcePaths) {
				for (Resource resource : resourcePatternResolver
						.getResources(basename)) {
					resources.add(resource);
				}
			}
		} catch (Exception e) {
			throw new UncheckedException("获取资源列表时反生异常。", e);
		}
		return resources;
	}

	/**
	 * 根据通配符资源路径获取资源路径列表。
	 * 
	 * @param resourceDir
	 *            资源目录
	 * @param wildcardResourcePaths
	 *            通配符资源路径
	 * @return 返回实际匹配的资源路径列表。
	 */
	public static List<String> getResourcePathsByWildcard(String resourceDir,
			String... wildcardResourcePaths) {
		List<String> resourcePaths = new ArrayList<String>();
		try {
			for (Resource resource : getResourcesByWildcard(wildcardResourcePaths)) {
				String uri = resource.getURI().toString();
				if (resource instanceof FileSystemResource
						|| resource instanceof UrlResource) {
					String resourcePath = "classpath:" + resourceDir
							+ StringUtils.substringAfter(uri, resourceDir);
					resourcePaths.add(resourcePath);
				}
			}
		} catch (Exception e) {
			throw new UncheckedException("获取资源文件时发生异常。", e);
		}
		return resourcePaths;
	}

	/**
	 * 根据通配符资源路径获取资源基本名称列表。
	 * 
	 * @param resourceDir
	 *            资源目录
	 * @param wildcardResourcePaths
	 *            通配符资源路径
	 * @return 返回实际匹配的资源基本名称列表。
	 */
	public static List<String> getResourceBasenamesByWildcard(
			String resourceDir, String... wildcardResourcePaths) {
		List<String> resourceBasenames = new ArrayList<String>();
		for (String resourcePath : getResourcePathsByWildcard(resourceDir,
				wildcardResourcePaths)) {
			resourceBasenames.add(StringUtils.substringBeforeLast(resourcePath,
					"."));
		}
		return resourceBasenames;
	}
	
}
