package com.bc.elasticsearch.repository;

import com.bc.elasticsearch.entity.BaseESEntity;
import com.bc.elasticsearch.searchParams.SearchParams;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xuy99
 */
@Repository
public class EsSearchRepository<T extends BaseESEntity> {

    private static final Logger log = LoggerFactory.getLogger(EsSearchRepository.class);

    @Resource
    private TransportClient transportClient;

    @Resource
    private ObjectMapper jsonObjectMapper;

    /**
     * 单个新增
     *
     * @param index
     * @param type
     * @param t
     */
    public void add(String index, String type, T t) {
        try {
            transportClient.prepareIndex(index, type, t.getId()).setSource(jsonObjectMapper.writeValueAsBytes(t), XContentType.JSON).get();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量新增
     *
     * @param index
     * @param type
     * @param list
     */
    public void addBatch(String index, String type, List<? extends BaseESEntity> list) {

        BulkRequestBuilder bulkRequest = transportClient.prepareBulk();
        list.stream().forEach(it -> {
            try {
                bulkRequest.add(transportClient.prepareIndex(index, type, it.getId()).setSource(jsonObjectMapper.writeValueAsBytes(it), XContentType.JSON));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        bulkRequest.get();
    }

    /**
     * 单个更新
     *
     * @param index
     * @param type
     * @param t
     */
    public void upSert(String index, String type, T t) {
        try {
            transportClient.prepareUpdate(index, type, t.getId()).setDoc(jsonObjectMapper.writeValueAsBytes(t), XContentType.JSON).setDocAsUpsert(true).get();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据ids删除
     *
     * @param index
     * @param type
     * @param id
     */
    public void deleteById(String index, String type, String id) {
        transportClient.prepareDelete(index, type, id).get();
    }

    /**
     * 批量删除
     *
     * @param index
     * @param type
     * @param ids
     */
    public void deleteByIds(String index, String type, List<String> ids) {
        BulkRequestBuilder bulkRequest = transportClient.prepareBulk();
        ids.stream().forEach(it -> {
            bulkRequest.add(transportClient.prepareDelete(index, type, it));
        });
        bulkRequest.get();
    }

    /**
     * 根据参数查询
     *
     * @param index
     * @param type
     * @param searchParams
     * @param className
     * @return
     */
    public List searchByParams(String index, String type, SearchParams searchParams, Class className) {
        //设置索引,分页数
        SearchRequestBuilder searchRequestBuilder = transportClient.prepareSearch(index).setTypes(type).setSearchType(SearchType.QUERY_THEN_FETCH).setPostFilter(searchParams.getBoolQueryBuilder())
                .setFrom(searchParams.getPage() * searchParams.getPageSize()).setSize(searchParams.getPageSize());
        //设置排序
        addSortParams(searchParams.getSortParams(), searchRequestBuilder);
        //处理结果集
        SearchResponse response = searchRequestBuilder.get();
        List resultList = Arrays.stream(response.getHits().getHits()).map(searchHit -> {
            try {
                return jsonObjectMapper.readValue(searchHit.getSourceAsString(), className);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
        return resultList;
    }


    public void insert(String index, String type, String id, Map<String, Object> dataMap){
        transportClient.prepareIndex(index, type, id).setSource(dataMap).get();
    }

    public void update(String index, String type, String id, Map<String, Object> dataMap){
        StringBuffer updateParams =new StringBuffer();
        if(null !=dataMap){
            for (Map.Entry<String, Object> item : dataMap.entrySet()){
                if(StringUtils.isNotBlank(updateParams.toString())){
                    updateParams.append(",");
                }
                updateParams.append(item.getKey()).append(",").append(item.getValue());
            }
        }
        if(StringUtils.isNotBlank(updateParams.toString())){
            Object[] arr=updateParams.toString().split(",");
            transportClient.prepareUpdate(index,type,id).setDoc(arr).setDocAsUpsert(true).get();
        }
    }


    /**
     * 封装排序参数
     *
     * @param list
     * @param searchRequestBuilder
     * @return
     */
    private SearchRequestBuilder addSortParams(List<String> list, SearchRequestBuilder searchRequestBuilder) {
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(it -> {
                if (it.contains(",")) {
                    String[] arr = it.split(",");
                    if (arr.length > 1) {
                        searchRequestBuilder.addSort(arr[0], swicth(arr[1]));
                    } else {
                        log.info("sort params error");
                    }
                }
            });
        }
        return searchRequestBuilder;
    }


    /**
     * 转化为ES需要的排序
     *
     * @param value
     * @return
     */
    private SortOrder swicth(String value) {
        if ("ASC".equalsIgnoreCase(value)) {
            return SortOrder.ASC;
        } else if ("DESC".equalsIgnoreCase(value)) {
            return SortOrder.DESC;
        } else {
            return SortOrder.ASC;
        }
    }

}
