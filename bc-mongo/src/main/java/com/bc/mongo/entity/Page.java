package com.bc.mongo.entity;

import java.io.Serializable;
import java.util.List;

/**
 * <p><b>Title:</b><i>TODO</i></p>
 * <p>Desc: TODO</p>
 * <p>source folder:{@docRoot}</p>
 * <p>Copyright:Copyright(c)2018</p>
 * <p>Company:vanke</p>
 * <p>Create Date:2018年10月8日 下午4:41:43</p>
 * <p>Modified By:wanglz08-</p>
 * <p>Modified Date:2018年10月8日 下午4:41:43</p>
 * @author <a href="mailto:wanglz08@vanke.com" title="邮箱地址">wanglz08</a>
 * @version Version 0.1
 *
 */
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
