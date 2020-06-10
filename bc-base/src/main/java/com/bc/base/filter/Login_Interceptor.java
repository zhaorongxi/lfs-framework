package com.bc.base.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * <p><b>Title:</b><i>TODO</i></p>
 * <p>Desc: TODO</p>
 * <p>source folder:{@docRoot}</p>
 * <p>Copyright:Copyright(c)2018</p>
 * <p>Company:vanke</p>
 * <p>Create Date:2018年8月27日 下午1:32:12</p>
 * <p>Modified By:wanglz08-</p>
 * <p>Modified Date:2018年8月27日 下午1:32:12</p>
 * @author <a href="mailto:wanglz08@vanke.com" title="邮箱地址">wanglz08</a>
 * @version Version 0.1
 *
 */
public class Login_Interceptor implements HandlerInterceptor {

	//在处理器调用之前被调用
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		//获取请求的URL 
		String url = request.getRequestURI(); 
		if(url.indexOf("/login")>=0){ 
		    return true;    
		}
		HttpSession session = request.getSession(); 
//		UserDto userCur = (UserDto)session.getAttribute("userCur");
		if("" != null){
		  return true; 
		}
		response.setStatus(401);
		return false;
	}

	//在处理器调用之后执行
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		
	}

	//在请求结束之后调用
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
}
