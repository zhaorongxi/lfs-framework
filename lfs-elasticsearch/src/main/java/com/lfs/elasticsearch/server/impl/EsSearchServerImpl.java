package com.lfs.elasticsearch.server.impl;

import com.lfs.elasticsearch.entity.BaseESEntity;
import com.lfs.elasticsearch.repository.EsSearchRepository;
import com.lfs.elasticsearch.searchParams.SearchParams;
import com.lfs.elasticsearch.server.EsSearchServer;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
@Service
public class EsSearchServerImpl<T extends BaseESEntity> implements EsSearchServer<T> {

    private static final Logger log = LoggerFactory.getLogger(EsSearchServerImpl.class);

    @Resource
    private EsSearchRepository esSearchRepository;

    @Override
    public void add(String index, String type, T t) {
        log.info("es add start,params:index:{},type:{},t:{}", index, type, ToStringBuilder.reflectionToString(t, ToStringStyle.DEFAULT_STYLE));
        esSearchRepository.add(index, type, t);
    }

    @Override
    public void addBatch(String index, String type, List<? extends BaseESEntity> list) {
        log.info("es addBatch start,params:index:{},type:{},t:{}", index, type, list);
        esSearchRepository.addBatch(index, type, list);
    }

    @Override
    public void upSert(String index, String type, T t) {
        log.info("es upSert start,params:index:{},type:{},t:{}", index, type, ToStringBuilder.reflectionToString(t, ToStringStyle.DEFAULT_STYLE));
        esSearchRepository.upSert(index, type, t);
    }

    @Override
    public void deleteById(String index, String type, String id) {
        log.info("es deleteById start,params:index:{},type:{},id:{}", index, type, id);
        esSearchRepository.deleteById(index, type, id);
    }

    @Override
    public void deleteByIds(String index, String type, List<String> ids) {
        log.info("es deleteByIds start,params:index:{},type:{},ids:{}", index, type, ids);
        esSearchRepository.deleteByIds(index, type, ids);
    }

    @Override
    public List searchByParams(String index, String type, SearchParams searchParams, Class<T> className) {
        log.info("es searchByParams start,params:index:{},type:{},esParams:{},className:{}", index, type, searchParams.toString(), className);
        return esSearchRepository.searchByParams(index, type, searchParams, className);
    }

    @Override
    public void insert(String index, String type, String id, Map<String, Object> dataMap) {
        log.info("es insert start,params:index:{},type:{},esParams:{},className:{}", index, type, id, dataMap);
        esSearchRepository.insert(index,type,id,dataMap);
    }

    @Override
    public void update(String index, String type, String id, Map<String, Object> dataMap) {
        log.info("es update start,params:index:{},type:{},esParams:{},className:{}", index, type, id, dataMap);
        esSearchRepository.update(index,type,id,dataMap);
    }
}
