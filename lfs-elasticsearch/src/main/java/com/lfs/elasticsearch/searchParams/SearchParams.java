package com.lfs.elasticsearch.searchParams;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.elasticsearch.index.query.BoolQueryBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
public class SearchParams implements Serializable {

    private static final long serialVersionUID = 2280310209630235104L;

    private Integer page = 0;

    private Integer pageSize = 20;

    private BoolQueryBuilder boolQueryBuilder;

    private List<String> sortParams;


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public BoolQueryBuilder getBoolQueryBuilder() {
        return boolQueryBuilder;
    }

    public void setBoolQueryBuilder(BoolQueryBuilder boolQueryBuilder) {
        this.boolQueryBuilder = boolQueryBuilder;
    }

    public List<String> getSortParams() {
        return sortParams;
    }

    public void setSortParams(List<String> sortParams) {
        this.sortParams = sortParams;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
