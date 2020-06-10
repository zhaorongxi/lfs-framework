package com.bc.base.enums;
/**
 * <p><b>Title:</b><i>HTTP状态码枚举</i></p>
 * <p>Desc: TODO</p>
 * <p>source folder:{@docRoot}</p>
 * <p>Copyright:Copyright(c)2018</p>
 * <p>Company:vanke</p>
 * <p>Create Date:2018年8月21日 下午6:18:53</p>
 * <p>Modified By:wanglz08-</p>
 * <p>Modified Date:2018年8月21日 下午6:18:53</p>
 * @author <a href="mailto:wanglz08@vanke.com" title="邮箱地址">wanglz08</a>
 * @version Version 0.1
 *
 */
public enum HttpStatusEnum {
	
	/**
	 * 200:正常响应成功，返回内容
	 */
	OK(200), 
	/**
	 * 300:多种选择：服务端响应多种结果，响应后，可以选一个结果再次请求
	 */
	MULTIPLE_CHOICES(300), 
	/**
	 * 301:永久重定向：主要用于seo优化中，是给搜索引擎使用检测的
	 */
	MOVED_PERMANENTLY(301), 
	/**
	 * 302:这个返回码指示资源临时在另一个位置，该位置通过Location指定。如果302响应对应的请求方法不是GET或者HEAD，那么客户端在获得用户许可之前是不能自动进行重定向的，因为这有可能会改变请求的条件。在RFC1045和RFC2068中指明客户端在响应重定向时是不可以改变请求的方法的。但是在多数实现中，总是使用GET方法来获取新位置的资源。这样就将其实现为303的要求了。
	 * 注意:303和307的出现是明确了302中的混乱状态。建议以后使用303和307，302在以后将会被淘汰掉
	 */
	FOUND(302), 
	/**
	 * 303：请求的资源可以在另一个URI处找到，客户端必须使用GET方法来获取新位置的资源。不能缓存303响应，但是可以缓存第二次请求的响应。This method exists primarily to allow the output of a POST-activated script to redirect the user agent to a selected resource.很多客户端识别303状态码，302状态码的实现其实就是对303状态码的响应。
	 */
	SEE_OTHER(303),
	/**
	 * 304：内容是否被客户端缓存：比如浏览器中，304状态表示资源被浏览器缓存在本地，一般标识图片和js脚步等被缓存
	 */
	NOT_MODIFIED(304),
	/**
	 * 307：同303一样，对于非GET和HEAD请求不能自动重定向。与302的区别是： The Web client issues a request to the new location of the resource using the same request method it used in the current transaction (rather than always using GET).也就是说307相较于302来说，后续请求资源的方法是使用与当前交互相同的方法而不是全部使用GET。
	 */
	TemporaryRedirect(307),
	/**
	 * 400: 请求前端报错，还未正式处理业务：比如参数无效
	 */
	INVALID(400),
	/**
	 * 403：拒绝访问：没有权限访问
	 */
	FORBIDDEN(403), 
	/**
	 * 401: 未授权：需要验证权限，比如用户名密码的校验
	 */
	UNAUTHORIZED(401),
	/**
	 * 404：资源没发现：比如页面没找到
	 */
	NOT_FOUND(404),
	/**
	 * 500：服务器内部错误
	 */
	INTERNAL_SERVER_ERROR(500),
	/** 
	 * 服务器超时  mapper http code 503
	 */
	TIME_OUT(503);

	private int statusCode;
	HttpStatusEnum(int statusCode) {
		this.statusCode = statusCode;
	}
	public int value() {
		return statusCode;
	}
}
