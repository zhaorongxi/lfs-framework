package com.bc.dao.beans;

/**
 * <p><b>Title:</b><i>POJO字段封装类</i></p>
 * <p>Desc: TODO</p>
 * <p>source folder:{@docRoot}</p>
 * <p>Copyright:Copyright(c)2018</p>
 * <p>Company:vanke</p>
 * <p>Create Date:2018年7月27日 上午10:57:04</p>
 * <p>Modified By:wanglz08-</p>
 * <p>Modified Date:2018年7月27日 上午10:57:04</p>
 * @author <a href="mailto:wanglz08@vanke.com title="邮箱地址">wanglz08</a>
 * @version Version 0.1
 *
 */
public class Pram {

	private String file;
	
	private Object value;

	public Pram(){}
	public Pram(String file, Object value){
		this.file = file;
		this.value = value;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	

}
