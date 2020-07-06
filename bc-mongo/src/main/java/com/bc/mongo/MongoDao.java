package com.bc.mongo;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.vanke.base.util.BeanUtilsEx;
import com.vanke.base.util.SpringUtil;
import com.vanke.vkframework.mongo.entity.Page;

/**
 * <p><b>Title:</b><i></i></p>
 * <p>Desc:</p>
 * <p>source folder:{@docRoot}</p>
 * <p>Copyright:Copyright(c)2018</p>
 * <p>Company:vanke</p>
 * <p>Create Date:2018年9月29日 上午11:03:41</p>
 * <p>Modified By:wanglz08-</p>
 * <p>Modified Date:2018年9月29日 上午11:03:41</p>
 * @author <a href="mailto:wanglz08@vanke.com" title="邮箱地址">wanglz08</a>
 * @version Version 0.1
 *
 */
public class MongoDao<T> {
	
/*	private static final int DEFAULT_SKIP = 0;
	private static final int DEFAULT_LIMIT = 200;*/


    private MongoTemplate mongoTemplate;
    private Class<T> calssEntity;
	
	
	public MongoDao(Class<T> calzz){
        this.mongoTemplate = (MongoTemplate) SpringUtil.getApplicationContext().getBean("mongoTemplate");
        this.calssEntity = calzz;
	}
	
	/**
	 * 通过条件查询实体(集合)
	 * 
	 * @param query
	 */
	public  List<T> find(Query query){
		return mongoTemplate.find(query, calssEntity);
	}
	
	
	/**
	 * 通过条件查询实体(集合)分组
	 * 
	 * @param query
	 */
	public  List<T> findGroup(Query query){
		return mongoTemplate.find(query, calssEntity);
	}

	/**
	 * 通过条件查询实体(集合)
	 * 
	 * @param query
	 */
	public  List<T> find(Map<String,Object> map){
		Criteria criter =new Criteria();
		for (Map.Entry<String,Object> entry : map.entrySet()) { 
			 String key =  entry.getKey();
			 Object value = entry.getValue();
			  criter.and(key).is(value);
			}
		Query query= new Query(criter);
		return mongoTemplate.find(query, calssEntity);
	}
	
	
	/**
	 * 通过一定的条件查询一个实体
	 * 
	 * @param query
	 * @return
	 */
	public T findOne(Map<String,Object> map) {
		Criteria criter =new Criteria();
		for (Map.Entry<String,Object> entry : map.entrySet()) { 
			 String key =  entry.getKey();
			 Object value = entry.getValue();
			  criter.and(key).is(value);
			}
		Query query= new Query(criter);
		return mongoTemplate.findOne(query, calssEntity);
	}
	
	/**
	 * 通过一定的条件查询一个实体
	 * 
	 * @param query
	 * @return
	 */
	public T findOne(Query query) {
		return mongoTemplate.findOne(query, calssEntity);
	}
	
	/**
	 * 通过一定的条件查询一个实体
	 * 
	 * @param query
	 * @return
	 */
	public T findOne(String id) {
		Query query=new Query(Criteria.where("_id").is(id));
		T t = mongoTemplate.findOne(query, calssEntity);
		return t;
	}
	
	/**
	 * 通过条件查询更新数据
	 * 
	 * @param query
	 * @param update
	 * @return
	 */
	public void update(Query query, Update update) {
		mongoTemplate.findAndModify(query, update, calssEntity);
	}

	
	
	/**
	 * 保存一个对象到mongodb
	 * 
	 * @param entity
	 * @return
	 */
	public T save(T entity) {
		mongoTemplate.insert(entity);
		return entity;
	}
	
	
	 /**
     * 删除对象
     * @param id
     */
    public void delete(T entity) {
        mongoTemplate.remove(entity);
    }
    
    
	/**
	 * 
	 * 方法用途: 根据指定条件删除<br>
	 * 操作步骤: <br>
	 * @param map
	 */
	public void delete(Map<String,Object> map) {
		 Query query= this.getQuery(map);
		 mongoTemplate.remove(query, calssEntity);
	}
    
    
    public void delete(Integer id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, calssEntity);
    }
	
	/**
	 * 通过ID获取记录
	 * 
	 * @param id
	 * @return
	 */
	public T findById(String id) {
		return mongoTemplate.findById(id, calssEntity);
	}

	
	/**	通过ID获取记录,并且指定了集合名(表的意思)	 
	 * 	 
	 *  @param id	 
	 *  @param collectionName	           
	 *  集合名	 
	 *  @return	 */
	public T findById(String id, String collectionName) {
		return mongoTemplate.findById(id, calssEntity, collectionName);

	}

	/**
	 * 分页查询
	 * @param page
	 * @param query
	 * @return
	 */
	public Page<T> findPage(Page<T> page,Map<String,Object> map){
		
		Query query= this.getQuery(map);
		
		long count = this.count(query);		
		page.setTotal(count);		
		int pageNumber = page.getPageNumber();		
		int pageSize = page.getPageSize();		
		query.skip((pageNumber - 1) * pageSize).limit(pageSize);		
		List<T> rows = this.find(query);		
		page.setRows(rows);		
		return page;
	}
	
	/**
	 * 求数据总和
	 * @param query
	 * @return
	 */
	public long count(Query query){
		return mongoTemplate.count(query, calssEntity);
	}
	
	
	
	
	
	/**
	 * 获取需要操作的实体类class
	 * 
	 * @return
	 */
	private Class<T> getEntityClass(){
		return BeanUtilsEx.getSuperClassGenricType(getClass());
	}
	
	
	
	public Query getQuery(Map<String,Object> map) {
		Criteria criter =new Criteria();
		for (Map.Entry<String,Object> entry : map.entrySet()) { 
			 String key =  entry.getKey();
			 Object value = entry.getValue();
			  criter.and(key).is(value);
			}
		return  new Query(criter);
	}
	
	
/*public Page<T> findGroup(Page<T> page,String[] groups,String tableName,Map<String,Object> map){
		GroupBy groupBy = new GroupBy(groups);
		
		Criteria criter =new Criteria();
		for (Map.Entry<String,Object> entry : map.entrySet()) { 
			 String key =  entry.getKey();
			 Object value = entry.getValue();
			  criter.and(key).is(value);
			}
		
		GroupByResults<T> res =mongoTemplate.group(criter, tableName, groupBy, calssEntity);
		
          return null;		
	
	}*/
	
	
	/**
	 * 
	 * 方法用途: 分组分页<br>
	 * 操作步骤: <br>
	 * @param page
	 * @param groups 分组字段
	 * @param tableName 表名
	 * @param map 查询条件
	 */
	public Page<T> pageGroup(Page<T> page,String[] groups,String tableName,Map<String,Object> map){
		
		Criteria criter =new Criteria();
		for (Map.Entry<String,Object> entry : map.entrySet()) { 
			 String key =  entry.getKey();
			 Object value = entry.getValue();
			  criter.and(key).is(value);
			}
		 Aggregation agg = Aggregation.newAggregation(    
		            Aggregation.match(criter),//条件  
		            Aggregation.group(groups).count().as("f"),//分组字段    
		            Aggregation.sort(Sort.DEFAULT_DIRECTION,"_id" ),//排序  
		            Aggregation.skip(page.getPageNumber()),//过滤  
		            Aggregation.limit(page.getPageSize())//页数  
		         );    
		 
		    AggregationResults<T> outputType=mongoTemplate.aggregate(agg,tableName,calssEntity);    
		    List<T> list=outputType.getMappedResults();
		    page.setRows(list);
		    return page;

	}
	
	
	/**
	 * 注入mongodbTemplate
	 * 
	 * @param mongoTemplate
	 */
//	protected abstract void setMongoTemplate(MongoTemplate mongoTemplate);

	
	
	
	
	
	
	
	
	
}

