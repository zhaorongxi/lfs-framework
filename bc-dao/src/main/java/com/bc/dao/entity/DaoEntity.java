package com.bc.dao.entity;

import java.io.Serializable;

/**
 * <p><b>Title:</b><i>TODO</i></p >
 * <p>Desc: TODO</p >
 * <p>source folder:com.bc.dao.entity.SaveEntity</p >
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Company:vanke</p >
 * <p>Create Date:2018/9/6 上午11:28</p >
 * <p>Modified By:v-mol01</p >
 * <p>Modified Date:2018/9/6 上午11:28</p >
 *
 * @author <a href=" " title="邮箱地址">v-mol01@vanke.com</a >
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
