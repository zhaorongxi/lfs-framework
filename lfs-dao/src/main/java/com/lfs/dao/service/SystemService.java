package com.lfs.dao.service;

import com.lfs.base.util.StringUtils;
import com.lfs.cache.redis.RedisBase;
import com.lfs.dto.entity.UserInfoEntity;
import net.sf.cglib.beans.BeanMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
@Service
public class SystemService {

	private static final Logger logger = LoggerFactory.getLogger(SystemService.class);
	//	@Resource
	private static HttpServletRequest request;
	/**
	 * 登录用户信息
	 */
	public static final String USER_INFO="hash:userInfo";
	/**
	 * 
	 * 方法用途: 获取当前用户信息--自动获取注入的当前请求<br>
	 * 操作步骤: TODO<br>
	 * @return
	 */
	public static UserInfoEntity getCurrentUser() {

		/*UserDto userDto = new UserDto();
		userDto.setId(1);
		return userDto;*/

		//todo 模拟用户
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		if(ra != null) {
			request = ((ServletRequestAttributes)ra).getRequest();
		}
		return getCurrentUser(request);
	}
	
	/**
	 * 
	 * 方法用途: 获取当前用户信息-无法注入request的场景使用<br>
	 * 操作步骤: TODO<br>
	 * @param request
	 * @return
	 */
	public static UserInfoEntity getCurrentUser(HttpServletRequest request) {
		String userId = request.getHeader("userId");
		logger.info("############userId: "+userId);
		if(StringUtils.isEmpty(userId)) {
			UserInfoEntity userDto = new UserInfoEntity();
			userDto.setId(0);
			return userDto;
		}
		//根据token获取用户ID
		//根据用户ID获取用户信息
        UserInfoEntity entity= (UserInfoEntity)RedisBase.getStringCache().get(USER_INFO  + userId);
        logger.info("############user: 【"+entity+"】");
        if(null==entity || null == entity.getId()){
			entity = new UserInfoEntity();
			entity.setId(Integer.parseInt(userId));
		}
        logger.info("############user: 【"+entity+"】");
		return entity;
	}
    private  <T> T mapToBean(Map<String, Object> map, T bean) {
        if (null == map){
            return null;
        }
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }
	
	/**
	 * 
	 * 方法用途: 获取当前用户信息--自动获取注入的当前请求<br>
	 * 操作步骤: 如果用户未登录，或抛出未登录异常信息，中断请求并返回<br>
	 * @return
	 * @throws Exception 
	 */
	public UserInfoEntity getCurrentUserForInterrupt() throws Exception {
		UserInfoEntity user = getCurrentUser();
		 if(user == null) {
			 throw new Exception("用户未登录");
		 }
		 return user;
	}

	
	
	/**
	 * 
	 * 方法用途: 获取当前用户信息-无法注入request的场景使用<br>
	 * 操作步骤: TODO<br>
	 * @return
	 */
	public String getInterfaceUserName() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
		return  (String) request.getAttribute("userName");
	}
}
