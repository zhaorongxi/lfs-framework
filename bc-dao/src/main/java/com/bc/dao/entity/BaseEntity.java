package com.bc.dao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <p><b>Title:</b><i>公共基础实体类</i></p>
 * <p>Desc: TODO</p>
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
//@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class BaseEntity<T> implements Serializable{
	
	private static final long serialVersionUID = 1655670000634575040L;

	/**
     * 数据状态  0:删除  1:正常
     */
    private Integer isDel;
    /**
     * 创建时间
     */
	public Date createTime;
    /**
     * 创建用户ID
     */
	public Integer createId;
    /**
     * 更改的时间
     */
	public Date updateTime;
    /**
     * 更改用户ID
     */
	public Integer updateId;
	
    /**
     * 当前页数
     */
    private Integer currentPage;
    /**
     * 每页显示条数
     */
    private Integer pageSize;
    



	public BaseEntity() {

	}


    static {
    	
    }

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateId() {
		return createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getUpdateId() {
		return updateId;
	}
	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
/*	*//**
     * @Title enablePaging
     * @Description 启用分页
     * @return
     *//*
    @SuppressWarnings("unchecked")
    public final T enablePaging() {
        PageHelper.startPage(currentPage, pageSize);
        return (T) this;
    }*/
    
}
