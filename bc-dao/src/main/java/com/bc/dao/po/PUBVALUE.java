package com.bc.dao.po;
/**
 * <p><b>Title:</b><i>定义公共值得约束类</i></p>
 * <p>Desc: TODO</p>
 * <p>source folder:{@docRoot}</p>
 * <p>Copyright:Copyright(c)2018</p>
 * <p>Company:vanke</p>
 * <p>Create Date:2018年8月30日 上午10:28:54</p>
 * <p>Modified By:wanglz08-</p>
 * <p>Modified Date:2018年8月30日 上午10:28:54</p>
 * @author <a href="mailto:wanglz08@vanke.com title="邮箱地址">wanglz08</a>
 * @version Version 0.1
 *
 */
public class PUBVALUE {

	/**
	 * FieldName注解中默认的name值
	 */
	public static final String FIELD_NAME_DEFAUL_VALUE = "_nullName_this_is_default";
	
	/**
	 * ID注解中type值得类型，该字段表示整数型自增Id
	 */
	public static final int TABLE_ID_TYPE_INTEGER = 0;
	
	/**
	 * ID注解中type值得类型，该字段表示String型UUID
	 */
	public static final int TABLE_ID_TYPE_UUID = 1;
	
}
