package com.lfs.interfaces.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BaseChargeDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个对象
	 * 
	 * @param sqlId
	 * @return
	 */
	public <T> T selectOne(String sqlId) {
		return sqlSessionTemplate.selectOne(sqlId);
	}

	/**
	 * 查询单个对象
	 * 
	 * @param sqlId
	 * @param sqlParams
	 * @return
	 */
	public <T> T selectOne(String sqlId, Object sqlParams) {
		return sqlSessionTemplate.selectOne(sqlId, sqlParams);
	}

	/**
	 * 查询list
	 * 
	 * @param sqlId
	 * @return
	 */
	public <E> List<E> selectList(String sqlId) {
		return sqlSessionTemplate.selectList(sqlId);
	}

	/**
	 * 查询list
	 * 
	 * @param sqlId
	 * @param sqlParams
	 * @return
	 */
	public <E> List<E> selectList(String sqlId, Object sqlParams) {
		return sqlSessionTemplate.selectList(sqlId, sqlParams);
	}

	/**
	 * 插入
	 * 
	 * @param sqlId
	 * @return
	 */
	public int insert(String sqlId) {
		return sqlSessionTemplate.insert(sqlId);
	}

	/**
	 * 插入
	 * 
	 * @param sqlId
	 * @param sqlParams
	 * @return
	 */
	public int insert(String sqlId, Object sqlParams) {
		return sqlSessionTemplate.insert(sqlId, sqlParams);
	}

	/**
	 * 更新
	 * 
	 * @param sqlId
	 * @return
	 */
	public int update(String sqlId) {
		return sqlSessionTemplate.update(sqlId);
	}

	/**
	 * 更新
	 * 
	 * @param sqlId
	 * @param sqlParams
	 * @return
	 */
	public int update(String sqlId, Object sqlParams) {
		return sqlSessionTemplate.update(sqlId, sqlParams);
	}

	/**
	 * 删除
	 * 
	 * @param sqlId
	 * @return
	 */
	public int delete(String sqlId) {
		return sqlSessionTemplate.delete(sqlId);
	}

	/**
	 * 删除
	 * 
	 * @param sqlId
	 * @param sqlParams
	 * @return
	 */
	public int delete(String sqlId, Object sqlParams) {
		return sqlSessionTemplate.delete(sqlId, sqlParams);
	}

}
