package com.lfs.dao.entity;

import java.io.Serializable;

/**
 * <p><b>Title:</b><i>TODO</i></p >
 * <p>Desc: TODO</p >
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
public class DaoEntity {

    private Integer id;

    private String paramsSql;

    private Serializable requestParams;

    private String valueSql;

    public String getParamsSql() {
        return paramsSql;
    }

    public void setParamsSql(String paramsSql) {
        this.paramsSql = paramsSql;
    }

    public String getValueSql() {
        return valueSql;
    }

    public void setValueSql(String valueSql) {
        this.valueSql = valueSql;
    }

    public Serializable getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(Serializable requestParams) {
        this.requestParams = requestParams;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
