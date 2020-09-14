package com.bc.mongo.entity;

import java.io.Serializable;
import java.util.List;

/**
 * <p><b>Title:</b><i>TODO</i></p>
 * <p>Desc: TODO</p>
 * * <p>Copyright:Copyright(c)2018</p >
 *  * <p>Create Date:2019/9/1 下午5:14</p >
 *  * <p>Modified By:linxi</p >
 *  * <p>Modified Date:2019/9/1 下午5:14</p >
 *  * @author linxi
 *  * @version Version 0.1
 *  */
public class Page<T> implements Serializable {
	
   private static final long serialVersionUID = 4756735742600835562L;
   
   //当前页
   private int pageNumber;
   //每页的数量
   private int pageSize=10;

   private List rows;
   //总记录数
   private long total;
public int getPageNumber() {
	return pageNumber;
}
public void setPageNumber(int pageNumber) {
	this.pageNumber = pageNumber;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}

public List getRows() {
	return rows;
}
public void setRows(List rows) {
	this.rows = rows;
}
public long getTotal() {
	return total;
}
public void setTotal(long total) {
	this.total = total;
}
   
   
   

}
