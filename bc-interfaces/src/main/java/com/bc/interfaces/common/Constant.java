package com.bc.interfaces.common;

/**
 * 项目中使用到的常量
 * 
 * 
 * @author linxi
 */
public class Constant {

	// http连接超时时间
	public static final int SO_TIMEOUT = 30 * 1000;
	// 数据传输超时时间
	public static final int SO_TIMEOUT_DATA = 60 * 1000;

	public static final String ORDER_SEND_READY = "1";// 待发
	public static final String ORDER_SEND_SEND = "2";// 已发
	public static final String ORDER_SEND_SUCCESS = "6";// 成功
	public static final String ORDER_SEND_FAIL = "4";// 失败
	public static final String ORDER_SEND_FENG = "5";// 风控

	public static final String REC_SEND_READY = "0";// 待发
	public static final String REC_SEND_SEND = "1";// 已发
	public static final String REC_SEND_SUCCESS = "2";// 成功
	public static final String REC_SEND_REPEAT = "3";// 重发
	public static final String REC_SEND_FAIL = "4";// 失败

	public static final int ADAPTER_SUCCESS = 0;// 适配器解析成功
	public static final int ADAPTER_ERROR = 1;// 适配器解析失败
	
	public static final String DEL_REDIS_URL = "del_redis_url";
	public static final String ADD_REDIS_URL = "add_redis_url";
	public static final String GET_REDIS_URL = "get_redis_url";
	public static final String DELALL = "DELALL";
	public static final String T_CHANNEL_SUPPLIER = "channel_supplier";// 表
	public static final String T_SMS_TEMPLATE = "sms_template";// 表
	public static final String HASH_APP_AUTH_LIST = "hash:appAuthList";
	public static final String HASH_BANK_INFO_LIST = "hash:bankInfoList";
	public static final String HASH_BANK_INFO_COUNT = "hash:bankInfoCount";
	public static final String HASH_AGENT_INFO_LIST = "hash:agtInfoList";

}
