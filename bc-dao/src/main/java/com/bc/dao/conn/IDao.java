
package com.bc.dao.conn;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.bc.dao.beans.WherePrams;


/**
 * 
 * <p><b>Title:</b><i>基础DAO接口 </i></p>
 * <p>Desc: TODO</p>
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 * @param <T> 业务实体类型
 * @param <PK> PK类型 ，如：String、Long、Integer 等
 */
@Repository
public interface IDao<T> {
	
     
	/**
	 * 
	 * 方法用途: 新增记录(会将序列生成的ID,注入)<br>
	 * 操作步骤: 保存（持久化）对象<br>
	 * @param ob  要持久化的对象
	 * @return 是否插入成功
	 */

	int saveBySelect(T ob) throws Exception;


	/**
	 *
	 * 方法用途: 新增记录(会将序列生成的ID,注入)<br>
	 * 操作步骤: 保存（持久化）对象<br>
	 * @param ob  要持久化的对象
	 * @return 是否插入成功
	 */

	int saveAll(T ob) throws Exception;



    /**
     * 方法用途: 批量新增记录(会将序列生成的ID,注入)<br>
     * 操作步骤: TODO<br>
     * @param list
     */
    void saveList(List<T> list) throws Exception;
    
	/**
	 * 
	 * 方法用途: 更新或保存<br>
	 * 操作步骤: TODO<br>
	 * @param t
	 * @return
	 */
    Integer saveOrUpdate(T t) throws Exception;
    
    /**
     * @param t
     * @param isAllField 是否全字段更新
     * @return 
     * @return boolean返回类型 
     * @throws
     */
    boolean saveOrUpdate(T t, Boolean isAllField);
	/**
	 * 方法用途: 根据属性批量删除业务实体<br>
	 * 操作步骤: TODO<br>
	 * @param name 属性名
	 * @param value 属性值
	 */
	Integer remove(String name, Object value);
	/**
	 * 方法用途: 根据ID删除业务实体。<br>
	 * 操作步骤: TODO<br>
	 * @param id 待删除业务实体ID
	 * @return 删除的对象数量
	 */
	Integer remove(Integer id);
	Integer delete(Integer id);
    /**
     * 方法用途: 根据ids进行批量删除<br>
     * 操作步骤: TODO<br>
     * @param  ids 待删除的业务实体id列表
     * @return 删除记录数
     */
    Integer remove(List<Integer> ids);
	Integer delete(List<Integer> ids);
	/**
	 * 方法用途: 根据ID批量删除业务实体。<br>
	 * 操作步骤: TODO<br>
	 * @param ids 待删除业务实体ID数组 
	 * @return 删除的对象数量
	 */
	Integer remove(Integer[] ids);

	Integer delete(Integer[] ids);
    /**
     * 
     * 方法用途: 更新-默认全字段更新<br>
     * 操作步骤: TODO<br>
     * @param t 要持久化的对象
     * @return 执行成功的记录个数
     */
    Integer updateById(T t);
     
    /**
     * 方法用途: 批量更新<br>
     * 操作步骤: TODO<br>
     * @param list
     */
    void update(List<T> list);
    
    /**
	 * 方法用途: 删除业务实体。<br>
	 * 操作步骤: TODO<br>
	 * @param entity 待删除业务实体
	 * @return  返回删除记录数
	 */
	Integer remove(WherePrams entity);

	Integer delete(WherePrams entity);
    /**
     * 方法用途:根据ID获取对象<br>
     * 操作步骤: TODO<br>
     * @param id 指定的唯一标识符
     * @return  指定的唯一标识符对应的持久化对象，如果没有对应的持久化对象，则返回null。
     */
    T findById(Integer id) throws Exception;
    

	/**
	 * 方法用途: 通过id数组查找对于的实体对象<br>
	 * 操作步骤: TODO<br>
	 * @param idArr  id数组
	 * @return 
	 */
	List<T> findByIds(Integer[] idArr) throws Exception;
	/**
	 * 方法用途: 通过ids[例：1,2,3]查找对于的实体对象<br>
	 * 操作步骤: TODO<br>
	 * @param ids 逗号隔开的id
	 * @return
	 */
	List<T> findByIds(String ids) throws Exception;
	/**
	 * 
	 * 方法用途: 通过属性值获取对象列表<br>
	 * 操作步骤: TODO<br>
	 * @param name 字段属性值
	 * @param values 逗号隔开的多个值
	 * @return
	 */
	List<T> findByMutil(String name, String values);

	/**
	 * 方法用途: 根据属性的值查找唯一的业务实体。<br>
	 * 操作步骤: TODO<br>
	 * @param name  属性名
	 * @param isMutilLineExcpetion 是否抛出异常的形式：如果数据集中有多行记录
	 * @param value 属性值
	 * @return 返回指定唯一的业务实体，如果没有找到则返回null。
	 */
    T findUnique(String name, boolean isMutilLineExcpetion, Object value);

    /**
	 * 方法用途: 根据属性的值查找唯一的业务实体。<br>
	 * 操作步骤: TODO<br>
	 * @param name  属性名
	 * @param value 属性值
	 * @return 返回指定唯一的业务实体，如果没有找到则返回null。
	 */
	T findUnique(String name, Object value);
	/**
	 * 方法用途: 查找唯一业务实体。<br>
	 * 操作步骤: TODO<br>
	 * @param criteria 查询条件
	 * @return  返回唯一业务实体，如果没有找到返回null。
	 */
	//T findUnique(Query<T> criteria);
	
	
	/**
     * 获取所有的对象
     * @return 返回指定类型的所有业务实体。
     */
    List<T> findAll() throws Exception;

    /**
	 * 分页查询
	 *
    PageBean<T> findPageByPrem(WherePrams wherePrams)throws Exception;

	 */
	/**
	 * 
	 * 不分页查询
	 * 
	 * @param param 查询参数
	 * @return 查询结果列表
	 */
	List<T> findWithParamEquals(T param)throws Exception;
	/**
	 * 方法用途: 通过属性查找列表<br>
	 * 操作步骤: TODO<br>
	 * @param name 属性名
	 * @param value 属性值
	 * @return 返回属性值相符的业务实体集合，如果没有找到返回一个空的集合。
	 */
	List<T> findBy(String name, Object value);
	
	/**
	 * 方法用途: 根据属性的值查找业务实体并进行排序。<br>
	 * 操作步骤: TODO<br>
	 * @param param
	 * @return
	 */
	List<T> findByParm(WherePrams param)throws Exception;
	
	/**
	 * 获取满足查询参数条件的数据总数
	 * 
	 * @param param 查询参数
	 * @return 数据总数
	 */
	Integer count(WherePrams param);

	
	/**
	 * 方法用途: 执行count查询获得记录总数。<br>
	 * 操作步骤: TODO<br>
	 * @param page
	 * @return 返回记录总数。
	 */
	public void flushStatements();



////全文检索功能start--------------------------未实现---------------------------------------------
	
	
	/**
	 * 
	 * 方法用途: 获取mybatis的全文搜索Session。<br>
	 * 操作步骤: TODO<br>
	 * @return 返回mybatis的全文搜索Session。
	 */
//	public FullTextSession getFullTextSession() {
//		return Search.getFullTextSession(getSession());
//	}
	
	/**
	 * 
	 * 方法用途: 创建全文搜索查询条件<br>
	 * 操作步骤: TODO<br>
	 * @return 返回全文搜索查询条件。
	 */
//	@Override
//	public FullTextCriteria createFullTextCriteria() {
//	}

	/**
	 * 
	 * 方法用途: 根据全文搜索查询条件进行全文搜索。<br>
	 * 操作步骤: TODO<br>
	 * @param criteria 全文搜索查询条件
	 * @return 返回符合查询条件的业务实体列表。
	 */
//	@Override
//	public List<T> searchBy(FullTextCriteria criteria) {
//	}

	/**
	 * 
	 * 方法用途: 全文搜索指定类型的所有业务实体。<br>
	 * 操作步骤: TODO<br> 
	 * @return 返回指定类型的所有业务实体。
	 */
//	@Override
//	public List<T> searchAll() {
//	}

	/**
	 * 
	 * 方法用途: 全文搜索指定类型的所有业务实体并进行排序。<br>
	 * 操作步骤: TODO<br>
	 * @param orderBy 排序的属性名
	 * @param isAsc  是否升序
	 * @param type 类型
	 * @return 返回排序后的指定类型的所有业务实体。
	 */
//	@Override
//	public List<T> searchAll(String orderBy, Boolean isAsc, org.apache.lucene.search.SortField.Type type) {
//	}
//	@Deprecated
//	public List<T> searchAll(String orderBy, Boolean isAsc, Integer type) {
//	}

	/**
	 * 
	 * 方法用途: 全文搜索唯一业务实体。<br>
	 * 操作步骤: TODO<br>
	 * @param criteria   全文搜索查询条件
	 * @return 返回唯一业务实体，如果没有找到返回null。
	 */
//	@Override
//	public T searchUnique(FullTextCriteria criteria) {
//	}

	/**
	 * 
	 * 方法用途: 根据属性的值全文搜索唯一的业务实体。<br>
	 * 操作步骤: TODO<br>
	 * @param name 属性名
	 * @param value  属性值
	 * @return 返回唯一业务实体，如果没有找到则返回null。
	 */
//	@Override
//	public T searchUnique(String name, Object value) {
//	}

	/**
	 * 
	 * 方法用途: 根据全文搜索查询条件进行分页全文搜索。<br>
	 * 操作步骤: TODO<br> 
	 * @param criteria  全文搜索查询条件
	 * @param pageNo 待获取的页数
	 * @param pageSize 每页的记录数
	 * @return 返回搜索得到的分页对象。
	 */
//	@Override
//	public Page<T> searchPage(FullTextCriteria criteria, Integer pageNo,
//			Integer pageSize) {
//	}

	/**
	 * 
	 * 方法用途: 重建全文索引。<br>
	 * 操作步骤: TODO<br> 
	 * @param sync 是否同步创建
	 */
//	@Override
//	public void rebuildIndex(Boolean sync) {
//	}

	/**
	 * 
	 * 方法用途: 获取查询所能获得的对象总数。<br>
	 * 操作步骤: TODO<br>  
	 * @param criteria  全文搜索查询对象
	 * @return 返回查询结果总数。
	 */
//	@Override
//	public Integer count(FullTextCriteria criteria) {
//	}

}
