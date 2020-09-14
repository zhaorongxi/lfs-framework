package com.bc.cache.base;

import com.bc.base.exception.BusinessException;

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
public interface CacheDao {
	
	/** 
	 * 方法用途: 添加值
	 * 操作步骤: 通过ADD添加数据时不允许相同键值<br>
	 * @param key 保存键
	 * @param value 对象值
	 */
	public void add(String key, Object value) throws BusinessException;
	/** 
	 * 方法用途: 添加值
	 * 操作步骤: 通过ADD添加数据时不允许相同键值<br>
	 * @param key 保存键
	 * @param export 超时时间
	 * @param value 对象值
	 */	
	public void add(String key, int export, Object value) throws BusinessException;
	/** 
	 * 方法用途: 替换
	 * 操作步骤: <br>
	 * @param key 保存键
	 * @param value 对象值
	 */
	public void replace(String key, Object value) throws BusinessException;
	/** 
	 * 方法用途: 替换
	 * 操作步骤: <br>
	 * @param key 保存键
	 * @param export 超时时间
	 * @param value 对象值
	 */
	public void replace(String key, int export, Object value) throws BusinessException;
	/** 
	 * 方法用途: 添加值
	 * 操作步骤: 通过SET添加数据时会替换掉以前的键对应的值<br>
	 * @param key 保存键
	 * @param value 对象值
	 */
	<T> T  set(String key, T value) throws BusinessException;
	/** 
	 * 方法用途: 添加值
	 * 操作步骤: 通过SET添加数据时会替换掉以前的键对应的值<br>
	 * @param key 保存键
	 * @param export 超时时间
	 * @param value 对象值
	 */
	<T> T set(String key, int export, T value) throws BusinessException;
	/** 
	 * 方法用途: 返回值
	 * 操作步骤: <br>
	 * @param key 保存键
	 * @return 缓存保存的对象
	 */
	public Object get(String key) throws BusinessException;
	/** 
	 * 方法用途: 删除值
	 * 操作步骤: <br>
	 * @param key 保存键
	 * @return 删除成功为TRUE失败为FALSE
	 */
	public boolean delete(String key) throws BusinessException;
	/** 
	 * 方法用途: 冲突判定
	 * 操作步骤: <br>
	 * @param key 保存键
	 * @return 有冲突为TRUE无为FALSE
	 */
	public boolean isMutex(String key) throws BusinessException;


}
