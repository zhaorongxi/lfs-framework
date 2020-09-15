package com.lfs.dao.beans;

import com.lfs.dao.po.FieldName;
import com.lfs.dao.sql.C;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WherePrams {

	private String pram="";
	
	private String limit;
	
	private String orderBy;

	private Class t;

	private Map<String,Serializable> values;

	public Map<String, Serializable> getValues() {
		return values;
	}

	public WherePrams(Class t){
		this.t=t;
		this.values = new HashMap<>();
	}



	public String getSqlName (String file){
		Field[] fields = t.getFields();
		for(Field f : fields){
			if (f.getName().equals(file)){
				if (f.isAnnotationPresent(FieldName.class)) {
					return f.getAnnotation(FieldName.class).name();
				}else{
					return toTableString(f.getName());
				}
			}
		}
		return file;
	}

	/**
	 * 驼峰标识转下划线标识
	 * @param text
	 * @return
	 */
	public String toTableString(String text){
		String tName = text.substring(0, 1).toLowerCase();
		for(int i = 1; i < text.length(); i++){
			if(!Character.isLowerCase(text.charAt(i))){
				tName += "_";
			}
			tName += text.substring(i, i + 1);
		}
		return tName.toLowerCase();
	}

	public WherePrams between(String file, Serializable start,Serializable end){
		this.values.put(getSqlName(file)+"_start",start);
		this.values.put(getSqlName(file)+"_end",end);
		this.pram += " and " + getSqlName(file) + " between #{requestParams." + getSqlName(file) + "_start} and #{requestParams." + getSqlName(file) + "_end} ";

		return this;
	}

	
	/**
	 * and条件
	 * @param file
	 * @param where
	 * @param value
	 * @return
	 */
	public WherePrams and(String file, String where, Serializable value){
		if (null == value) {
			if (where.equals(C.getSqlWhere(C.EQ))) {
				where = " is ";
			} else {
				where = " not ";
			}
			this.pram += " and " + getSqlName(file) + where + " null";
		} else {
			this.values.put(getSqlName(file),value);
			if (C.getSqlWhere(C.LIKE).equals(where)) {
				this.pram += " and " + getSqlName(file) + " " + where + " concat('%',#{requestParams." + getSqlName(file) + "},'%')";

			}else if (C.getSqlWhere(C.IN).equals(where)){
				this.pram += " and "+getSqlName(file) +" "+where+  getInXml(getSqlName(file),value);
			}else {
				this.pram += " and " + getSqlName(file) + " " + where + " #{requestParams." + getSqlName(file) + "}";
			}
		}
		return this;
	}
	public WherePrams and(String file, C c, Serializable value){
		String where = C.getSqlWhere(c);
		return and(file, where, value);
	}
	
/*	*//**
	 * or条件
	 * @param pram
	 * @return
	 *//*
	public WherePrams or(String pram){
		this.pram += " or " + pram;
		return this;
	}*/
	
	/**
	 * or条件
	 * @param file
	 * @param where
	 * @param value
	 * @return
	 */
	public WherePrams or(String file, String where, Serializable value){
		
		if (null == value) {
			if (where.equals(C.getSqlWhere(C.EQ))) {
				where = " is";
			} else {
				where = " not ";
			}
			this.pram += " or " + getSqlName(file) + where + "null";
		} else {
			this.values.put(getSqlName(file),value);
			if (C.getSqlWhere(C.LIKE).equals(where)) {
				this.pram += " or " + getSqlName(file) + " " + where+ " concat('%',#{requestParams." + getSqlName(file) + "},'%')";
			}else if(C.getSqlWhere(C.IN).equals(where)){
				this.pram += " or "+getSqlName(file) +" "+where+ getInXml(getSqlName(file),value);
			}else{
				this.pram += " or " + getSqlName(file) + where + " #{requestParams." + getSqlName(file) + "}";
			}

		}

		return this;
	}
	public WherePrams or(String file, C c, Serializable value){
		String where = C.getSqlWhere(c);
		return or(file, where, value);
	}
	
	public WherePrams limit(int startNum, int length) {
		// TODO Auto-generated constructor stub
//		this.limit = " limit ? , ? ";
		this.limit = " limit " + startNum + " , " + length + " ";
//		limitParms.add(startNum);
//		limitParms.add(length);
		return this;
	}
	
	public WherePrams orderBy(String file,boolean order){
		if(this.orderBy != null){
			this.orderBy += ","+getSqlName(file);
		}else{
			this.orderBy = getSqlName(file);
		}
		if (order){
			this.orderBy+=" desc";
		}
		return this;
	}

	@Override
	public String toString() {
		return "WherePrams [pram=" + pram + "]";
	}
	
	/**
	 * 获取prams
	 * @return
	 */
	public String getWherePrams(){
		String p = "";
		p += null == this.pram ? "" : this.pram;
		p += null == this.orderBy ? "" : (" order by " + this.orderBy);
		p += null == this.limit ? "" : this.limit;
		return p;
	}
	/**
	 * 获取prams
	 * @return
	 */
	public String getWherePramsUnLimit(){
		String p = "";
		p += null == this.pram ? "" : this.pram;
		p += null == this.orderBy ? "" : (" order by " + this.orderBy);
		return p;
	}

	private String getInXml(String file,Serializable value) {
		List list = new ArrayList();
		if (value instanceof List){
			list = (List) value;
		}else {
			throw new RuntimeException("参数异常，请传入list");
		}
		StringBuffer valsql = new StringBuffer(" ( ");
		for (int i=0 ; i<list.size() ;i++){
			valsql.append("#{requestParams."+file+i+"}");
			this.values.put(file+i, list.get(i).toString());
			if (i>=0){
				valsql.append(",");
			}
		}
		valsql.deleteCharAt(valsql.length() - 1);
		valsql.append(" ) ");
		return valsql.toString();

	}

}
