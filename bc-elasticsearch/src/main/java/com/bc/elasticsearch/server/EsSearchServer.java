package com.bc.elasticsearch.server;

import com.bc.elasticsearch.entity.BaseESEntity;
import com.bc.elasticsearch.searchParams.SearchParams;

import java.util.List;
import java.util.Map;

/**
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
public interface EsSearchServer<T extends BaseESEntity> {
    /**
     * 单个插入
     *
     * @param index 索引
     * @param type  类型
     * @param t     实体类
     */
    void add(String index, String type, T t);

    /**
     * 批量插入
     *
     * @param index 索引
     * @param type  类型
     * @param list  列表
     */
    void addBatch(String index, String type, List<? extends BaseESEntity> list);

    /**
     * upsert方法: 当id存在的时候更新，当id不存在的时候插入
     *
     * @param index 索引
     * @param type  类型
     * @param t     实体类
     */
    void upSert(String index, String type, T t);

    /**
     * 根据id删除
     *
     * @param index 索引
     * @param type  类型
     * @param id    主键
     */
    void deleteById(String index, String type, String id);

    /**
     * 批量删除
     *
     * @param index 索引
     * @param type  类型
     * @param ids   ids列表
     */
    void deleteByIds(String index, String type, List<String> ids);

    /**
     * 查询方法
     *
     * @param index     索引
     * @param type      类型
     * @param searchParams  ES查询参数
     * @param className className
     * @return
     */
    List searchByParams(String index, String type, SearchParams searchParams, Class<T> className);

    /**
     * map的方式写入
     * @param index
     * @param type
     * @param id
     * @param dataMap
     */
    void insert(String index, String type, String id, Map<String, Object> dataMap);

    /**
     * 局部更新
     * @param index
     * @param type
     * @param id
     * @param dataMap
     */
    void update(String index, String type, String id, Map<String, Object> dataMap);
}
