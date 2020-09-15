package com.lfs.base.util;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.GenericValidator;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * <p><b>Title:</b><i>参数解析工具</i></p>
 * <p>Desc:提供各种对数据进行处理的方法,待优化和调整 TODO</p>
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
public class DataUtil {


	/**
	 * 数字转换，将object类型转换为defaultValue类型
	 * 方法用途: TODO<br/>
	 * 操作步骤: TODO<br/>
	 * ${tags}
	 */
	private static Number parseNumber(Object param, Number defaultValue) {
		if (param == null) {
			return defaultValue;
		}
		try {
			String value = param.toString();
			if (defaultValue != null) {
				
				//新的判断整型方式 推荐使用，目前只调整int类型，其他类型后续调整
				if(ObjectUtils.isInt(param)) {
					return new Integer(param.toString());
				}
				//久的判断整型方式
				if (defaultValue instanceof Integer) {
					return new Integer(param.toString());
				} else if (defaultValue instanceof Long) {
					return new Long(value);
				} else if (defaultValue instanceof Float) {
					return new Float(value);
				} else {
					return new Double(value);
				}
			}
			if (GenericValidator.isInt(value)) {
				return new Integer(param.toString());
			} else if (GenericValidator.isLong(value)) {
				return new Long(value);
			} else if (GenericValidator.isFloat(value)) {
				return new Float(value);
			} else {
				return new Double(value);
			}
		} catch (Exception e) {
		}
		return defaultValue;
	}

	private static Number addNumber(Number param1, Number param2) {
		if ((param1 == null) && (param2 == null)) {
			return null;
		}
		boolean haveNull = false;
		if (param2 == null) {
			param2 = 0;
			haveNull = true;
		}
		if (param1 == null) {
			param1 = 0;
			haveNull = true;
		}
		if (haveNull) {
			return new Double(param1.doubleValue() + param2.doubleValue());
		}
		if (param1 instanceof Integer) {
			return new Integer(param1.intValue() + param2.intValue());
		} else if (param1 instanceof Double) {
			return new Double(param1.doubleValue() + param2.doubleValue());
		} else if (param1 instanceof Long) {
			return new Long(param1.longValue() + param2.longValue());
		} else if (param1 instanceof Float) {
			return new Float(param1.floatValue() + param2.floatValue());
		}
		return new Double(param1.doubleValue() + param2.doubleValue());
	}

	private static boolean gtNumber(Number param1, Number param2) {
		if (param1 == null || param2 == null) {
			return false;
		}
		return param1.doubleValue() > param2.doubleValue();
	}

	private static boolean geNumber(Number param1, Number param2) {
		if (param1 == null || param2 == null) {
			return false;
		}
		return param1.doubleValue() >= param2.doubleValue();
	}

	/**
	 * 将参数解析为boolean基本类型，解析失败时返回false。
	 * 
	 * @param param
	 * @return
	 */
	public static boolean parseBool(Object param) {
		return parseBool(param, false);
	}

	/**
	 * 将参数解析为boolean基本类型，解析失败时返回defaultValue。
	 * 
	 * @param param
	 * @param defaultValue
	 * @return
	 */
	public static boolean parseBool(Object param, boolean defaultValue) {
		return parseBoolean(param, defaultValue);
	}

	/** 将参数解析为Boolean对象 */
	public static Boolean parseBoolean(Object param) {
		return parseBoolean(param, null);
	}

	/** 将参数解析为Boolean对象，解析失败时返回defaultValue */
	public static Boolean parseBoolean(Object param, Boolean defaultValue) {
		if (param == null) {
			return defaultValue;
		}
		try {
			return new Boolean(param.toString());
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/** 将参数解析为int类型，为空时返回0 */
	public static Integer parseInt(Object param) {
		return parseInteger(param, 0);
	}

	/** 将参数解析为int类型，为空时返回defaultValue */
	public static int parseInt(Object param, int defaultValue) {
		return parseInteger(param, defaultValue);
	}

	/** 解析不小于minValue，缺省为defaultValue的int数 */
	public static int parseNoLessInt(Object param, int defaultValue, int minValue) {
		int result = parseInt(param, defaultValue);
		if (result < minValue) {
			return minValue;
		}
		return result;
	}

	/** 解析不大于maxValue，缺省为defaultValue的int数 */
	public static int parseNoBiggerInt(Object param, int defaultValue, int maxValue) {
		int result = parseInt(param, defaultValue);
		if (result > maxValue) {
			return maxValue;
		}
		return result;
	}

	/** 解析不小于minValue不大于maxValue，缺省为defaultValue的int数 */
	public static int parseBetweenInt(Object param, int defaultValue, int minValue, int maxValue) {
		int result = parseInt(param, defaultValue);
		if (result < minValue) {
			return minValue;
		}
		if (result > maxValue) {
			return maxValue;
		}
		return result;
	}

	/** 将参数解析为Integer对象 */
	public static Integer parseInteger(Object param) {
		return parseInteger(param, null);
	}

	/** 将参数解析为Integer对象 */
	public static Integer parseInteger(Object param, Integer defaultValue) {
		return (Integer) parseNumber(param, defaultValue);
	}

	/** 解析不小于minValue，缺省为defaultValue的long数 */
	public static long parseNoLessLong(Object param, long defaultValue, long minValue) {
		long result = parseLong(param, defaultValue);
		if (result < minValue) {
			return minValue;
		}
		return result;
	}

	/** 解析不大于maxValue，缺省为defaultValue的long数 */
	public static long parseNoBiggerLong(Object param, long defaultValue, long maxValue) {
		long result = parseLong(param, defaultValue);
		if (result > maxValue) {
			return maxValue;
		}
		return result;
	}

	/** 解析不小于minValue不大于maxValue，缺省为defaultValue的long数 */
	public static long parseBetweenLong(Object param, long defaultValue, long minValue, long maxValue) {
		long result = parseLong(param, defaultValue);
		if (result < minValue) {
			return minValue;
		}
		if (result > maxValue) {
			return maxValue;
		}
		return result;
	}

	/** 将参数解析为long基本类型，解析失败时返回0 */
	public static long parseL(Object param) {
		return parseL(param, 0);
	}

	/** 将参数解析为long基本类型，解析失败时返回defaultValue */
	public static long parseL(Object param, long defaultValue) {
		return parseLong(param, defaultValue);
	}

	/** 解析不小于minValue，缺省为defaultValue的long数 */
	public static long parseNoLessL(Object param, long defaultValue, long minValue) {
		long result = parseL(param, defaultValue);
		if (result < minValue) {
			return minValue;
		}
		return result;
	}

	/** 解析不大于maxValue，缺省为defaultValue的long数 */
	public static long parseNoBiggerL(Object param, long defaultValue, long maxValue) {
		long result = parseL(param, defaultValue);
		if (result > maxValue) {
			return maxValue;
		}
		return result;
	}

	/** 解析不小于minValue不大于maxValue，缺省为defaultValue的long数 */
	public static long parseBetweenL(Object param, long defaultValue, long minValue, long maxValue) {
		long result = parseL(param, defaultValue);
		if (result < minValue) {
			return minValue;
		}
		if (result > maxValue) {
			return maxValue;
		}
		return result;
	}

	/** 将参数解析为Long对象 */
	public static Long parseLong(Object param) {
		return parseLong(param, null);
	}

	/** 将参数解析为Long对象，解析失败时返回defaultValue */
	public static Long parseLong(Object param, Long defaultValue) {
		return (Long) parseNumber(param, defaultValue);
	}

	/** 将参数解析为Duoble对象，解析失败时返回0 */
	public static double parseD(Object param) {
		return parseD(param, 0D);
	}

	/** 将参数解析为Duoble对象，解析失败时返回defaultValue */
	public static double parseD(Object param, double defaultValue) {
		return parseDouble(param, defaultValue);
	}

	/** 解析不小于minValue，缺省为defaultValue的double数 */
	public static double parseNoLessD(Object param, double defaultValue, double minValue) {
		double result = parseD(param, defaultValue);
		if (result < minValue) {
			return minValue;
		}
		return result;
	}

	/** 解析不大于maxValue，缺省为defaultValue的double数 */
	public static double parseNoBiggerD(Object param, double defaultValue, double maxValue) {
		double result = parseD(param, defaultValue);
		if (result > maxValue) {
			return maxValue;
		}
		return result;
	}

	/** 解析不小于minValue不大于maxValue，缺省为defaultValue的double数 */
	public static double parseBetweenD(Object param, double defaultValue, double minValue, double maxValue) {
		double result = parseD(param, defaultValue);
		if (result < minValue) {
			return minValue;
		}
		if (result > maxValue) {
			return maxValue;
		}
		return result;
	}

	/** 将参数解析为Duoble对象 */
	public static Double parseDouble(Object param) {
		return parseDouble(param, null);
	}

	/** 将参数解析为Duoble对象，解析失败时返回defaultValue */
	public static Double parseDouble(Object param, Double defaultValue) {
		return (Double) parseNumber(param, defaultValue);
	}

	/** 将参数解析为Float对象，解析失败时返回0 */
	public static Float parseF(Object param) {
		return parseF(param, 0);
	}

	/** 将参数解析为Float对象，解析失败时返回defaultValue */
	public static Float parseF(Object param, float defaultValue) {
		return parseFloat(param, defaultValue);
	}

	/** 将参数解析为Float对象 */
	public static Float parseFloat(Object param) {
		return parseFloat(param, null);
	}

	/** 将参数解析为Float对象，解析失败时返回defaultValue */
	public static Float parseFloat(Object param, Float defaultValue) {
		return (Float) parseNumber(param, defaultValue);
	}

	/** 将两个参数叠加成Integer对象，任何空数字都做0处理 */
	public static Integer addInteger(Object param1, Object param2) {
		return addNumber(parseInt(param1), parseInteger(param2)).intValue();
	}

	/** 将两个参数叠加成Long对象，任何空数字都做0处理 */
	public static Long addLong(Object param1, Object param2) {
		return addNumber(parseL(param1), parseL(param2)).longValue();
	}

	/** 将两个参数叠加成Double对象，任何空数字都做0处理 */
	public static Double addDouble(Object param1, Object param2) {
		return addNumber(parseD(param1), parseD(param2)).doubleValue();
	}

	/** 将两个参数叠加成Float对象，任何空数字都做0处理 */
	public static Float addFloat(Object param1, Object param2) {
		return addNumber(parseF(param1), parseF(param2)).floatValue();
	}

	/** 判断前一个参数是否大于后一个参数。如果两个参数有一个为空，就返回false */
	public static boolean gtInteger(Object param1, Object param2) {
		return gtNumber(parseInteger(param1), parseInteger(param2));
	}

	/** 判断前一个参数是否大于后一个参数。如果两个参数有一个为空，就返回false */
	public static boolean gtLong(Object param1, Object param2) {
		return gtNumber(parseLong(param1), parseLong(param2));
	}

	/** 判断前一个参数是否大于后一个参数。如果两个参数有一个为空，就返回false */
	public static boolean gtDouble(Object param1, Object param2) {
		return gtNumber(parseDouble(param1), parseDouble(param2));
	}

	/** 判断前一个参数是否大于后一个参数。如果两个参数有一个为空，就返回false */
	public static boolean gtFloat(Object param1, Object param2) {
		return gtNumber(parseFloat(param1), parseFloat(param2));
	}

	/** 判断前一个参数是否大于后一个参数。如果两个参数有一个为空，就返回false */
	public static boolean geInteger(Object param1, Object param2) {
		return geNumber(parseInteger(param1), parseInteger(param2));
	}

	/** 判断前一个参数是否大于后一个参数。如果两个参数有一个为空，就返回false */
	public static boolean geLong(Object param1, Object param2) {
		return geNumber(parseLong(param1), parseLong(param2));
	}

	/** 判断前一个参数是否大于后一个参数。如果两个参数有一个为空，就返回false */
	public static boolean geDouble(Object param1, Object param2) {
		return geNumber(parseDouble(param1), parseDouble(param2));
	}

	/** 判断前一个参数是否大于后一个参数。如果两个参数有一个为空，就返回false */
	public static boolean geFloat(Object param1, Object param2) {
		return geNumber(parseFloat(param1), parseFloat(param2));
	}

	/** 判断两个数字是否相等。都不为空 */
	public static boolean eq(Number number1, Number number2) {
		if (number1 == null || number2 == null) {
			return false;
		}
		return number1.doubleValue() == number2.doubleValue();
	}

	/** 判断前一个数字是否大于后一个。 */
	public static boolean gt(Number number1, Number number2) {
		if (number1 == null) {
			return false;
		}
		if (number2 == null) {
			return true;
		}
		return number1.doubleValue() > number2.doubleValue();
	}

	public static final String DATE_PATTEN_DEFAULT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_PATTEN_DAY = "yyyy-MM-dd";

	/** 格式化日期 */
	public static String formatDate(Date date) {
		return formatDate(date, DATE_PATTEN_DEFAULT);
	}

	/** 格式化日期 */
	public static String formatDate(Date date, String patten) {
		if (date == null) {
			return null;
		}
		return getDateFormat(patten).format(date);
	}

	/** 解析日期 */
	public static Date parseDate(Object param) {
		return parseDate(param, DATE_PATTEN_DEFAULT);
	}

	/** 解析日期 */
	public static Date parseDate(Object param, String patten) {
		if (param == null) {
			return null;
		}
		try {
			return getDateFormat(patten).parse(param.toString());
		} catch (Exception e) {
			return null;
		}
	}

	/** 判断targetDate是否在sourceDate之前。假定都不为空。 */
	public static boolean before(Date sourceDate, Date targetDate) {
		return targetDate.before(sourceDate);
	}

	/** 取得当前月的第一天 */
	public static Date getCurrentMonthFirstDat(Date date) {
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		}
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/** 取得当前月是一年中的第几个月 */
	public static Integer getMonthOfThisYear() {
		return getMonthOfThisYear(new Date());
	}

	/** 取得日期是一年中的第几个月 */
	public static Integer getMonthOfThisYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH) + 1;

	}

	/** 取得该周是一年的第几周 */
	public static Integer getWeekOfThisYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.WEEK_OF_YEAR);
	}

	/** 取得日期中某一项的值。valueType： Calendar中对应的类型 */
	public static Integer getTimeValue(Date date, int valueType) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(valueType);
	}

	/** 设置日期中某一项的值。valueType： Calendar中对应的类型 */
	public static Date setTimeValue(Date date, int valueType, int value) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(valueType, value);
		return cal.getTime();
	}

	/** 增加日期中某一项的值。valueType： Calendar中对应的类型 */
	public static Date addTimeValue(Date date, int valueType, int value) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(valueType, value);
		return cal.getTime();
	}

	/** 取得某个月份的改天 */
	public static Date getTimeByMonth(Integer month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.MONTH, month - 1);
		return cal.getTime();
	}

	/** 取得某月的第一天。与getCurrentMonthFirstDat相同 */
	public static Date getMonthBegin(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, 0, 0, 0);
		return cal.getTime();
	}

	/** 取得某月的最后一天 */
	public static Date getMonthEnd(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, 1, 0, 0, 0);
		cal.set(Calendar.SECOND, cal.get(Calendar.SECOND) - 1);
		return cal.getTime();
	}

	/** 取得该周第一天 */
	public static Date getWeekBegin(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		Date mm = nDaysAgo(cal.get(Calendar.DAY_OF_WEEK) - 2, date);
		return getDayBegin(mm);
	}

	/** 取得该周的最后一天 */
	public static Date getWeekEnd(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		Date mm = nDaysAfter(cal.get(8 - Calendar.DAY_OF_WEEK), date);
		return getDayEnd(mm);

	}

	/** 取得n天后的时间 */
	public static Date nDaysAfter(int n, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + n);
		return cal.getTime();
	}

	public static Date getDayBegin(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		return cal.getTime();
	}

	public static Date getDayEnd(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH) + 1, 0, 0, 0);
		cal.set(Calendar.SECOND, cal.get(Calendar.SECOND) - 1);
		return cal.getTime();
	}

	/** 取得n月前的时间 */
	public static Date nMonthsAgo(Integer n, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - n);
		return cal.getTime();
	}

	/** 取得n天前的时间 */
	public static Date nDaysAgo(Integer n, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - n);
		return cal.getTime();
	}

	public static String formatNumber(Number number, String patten) {
		return getNumberFormat(patten).format(number);
	}

	public static NumberFormat getNumberFormat(String patten) {
		if (numberFormatMap == null) {
			numberFormatMap = new HashMap<String, NumberFormat>();
		}
		if (!numberFormatMap.containsKey(patten)) {
			numberFormatMap.put(patten, new DecimalFormat(patten));
		}
		return numberFormatMap.get(patten);
	}

	private static Map<String, NumberFormat> numberFormatMap;

	public static DateFormat getDateFormat(String patten) {
		if (dateFormatMap == null) {
			dateFormatMap = new HashMap<String, DateFormat>();
		}
		if (!dateFormatMap.containsKey(patten)) {
			dateFormatMap.put(patten, new SimpleDateFormat(patten));
			// dateFormatMap.put(patten, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
		}
		return dateFormatMap.get(patten);
	}

	private static Map<String, DateFormat> dateFormatMap;

	/** 将分钟数转为时间。 */
	public static Date minuteToDate(long minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(minute * 60000);
		return calendar.getTime();
	}

	/** 将时间转为分钟数 */
	public static int dateToMinute(Date date) {
		if (date == null) {
			return 0;
		}
		return (int) (date.getTime() / 60000);
	}


	/**
	 * 增加权限
	 * 
	 * @param priValue
	 *            权限值
	 * @param pri
	 *            加入的权限码
	 */
	public static int addPriviledge(int priValue, int pri) {
		if (pri > 30 || pri < 1) {
			return priValue;
		}
		return priValue | (int) Math.pow(2, pri - 1);
	}

	/**
	 * 减权限
	 * 
	 * @param priValue
	 * @param pri
	 * @return
	 */
	public static int deletePriviledge(int priValue, int pri) {
		if (pri > 30 || pri < 1) {
			return priValue;
		}
		return priValue & ~(int) Math.pow(2, pri - 1);
	}

	/**
	 * 判断是否具有某种权限
	 * 
	 * @param priValue
	 * @param pri
	 * @return
	 */
	public static boolean havePriviledge(int priValue, int pri) {
		if (pri > 30 || pri < 1) {
			return false;
		}
		return (priValue & (int) Math.pow(2, pri - 1)) > 0;
	}

	/**
	 * 取得所有权限
	 * 
	 * @param priValue
	 * @return
	 */
	public static Set<Integer> getAllPriviledge(int priValue) {
		Set<Integer> result = new LinkedHashSet<Integer>();
		for (int i = 1; i <= 30; i++) {
			if (havePriviledge(priValue, i)) {
				result.add(i);
			}
		}
		return result;
	}

	/**
	 * 把Collection中的对象，toString为key，转为map
	 * 
	 * @param collection
	 * @return
	 */
	public static Map<String, Object> toMap(Collection collection) {
		Map result = new HashMap();
		if (collection != null && collection.size() > 0) {
			for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				result.put(object.toString(), object);
			}
		}
		return result;
	}

	/**
	 * 从ip的字符串形式得到字节数组形式
	 * 
	 * @param ip
	 *            字符串形式的ip
	 * @return 字节数组形式的ip
	 */
	public static byte[] getIpByteArrayFromString(String ip) {
		byte[] ret = new byte[4];
		java.util.StringTokenizer st = new java.util.StringTokenizer(ip, ".");
		try {
			ret[0] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
			ret[1] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
			ret[2] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
			ret[3] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}

	/**
	 * 对原始字符串进行编码转换，如果失败，返回原始的字符串
	 * 
	 * @param s
	 *            原始字符串
	 * @param srcEncoding
	 *            源编码方式
	 * @param destEncoding
	 *            目标编码方式
	 * @return 转换编码后的字符串，失败返回原始字符串
	 */
	public static String getString(String s, String srcEncoding, String destEncoding) {
		try {
			return new String(s.getBytes(srcEncoding), destEncoding);
		} catch (UnsupportedEncodingException e) {
			return s;
		}
	}

	/**
	 * 根据某种编码方式将字节数组转换成字符串
	 * 
	 * @param b
	 *            字节数组
	 * @param encoding
	 *            编码方式
	 * @return 如果encoding不支持，返回一个缺省编码的字符串
	 */
	public static String getString(byte[] b, String encoding) {
		try {
			return new String(b, encoding);
		} catch (UnsupportedEncodingException e) {
			return new String(b);
		}
	}

	/**
	 * 根据某种编码方式将字节数组转换成字符串
	 * 
	 * @param b
	 *            字节数组
	 * @param offset
	 *            要转换的起始位置
	 * @param len
	 *            要转换的长度
	 * @param encoding
	 *            编码方式
	 * @return 如果encoding不支持，返回一个缺省编码的字符串
	 */
	public static String getString(byte[] b, int offset, int len, String encoding) {
		try {
			return new String(b, offset, len, encoding);
		} catch (UnsupportedEncodingException e) {
			return new String(b, offset, len);
		}
	}

	/**
	 * @param ip
	 *            ip的字节数组形式
	 * @return 字符串形式的ip
	 */
	public static String getIpStringFromBytes(byte[] ip) {
		StringBuffer sb = new StringBuffer();
		sb.append(ip[0] & 0xFF);
		sb.append('.');
		sb.append(ip[1] & 0xFF);
		sb.append('.');
		sb.append(ip[2] & 0xFF);
		sb.append('.');
		sb.append(ip[3] & 0xFF);
		return sb.toString();
	}

	/**
	 * @param ip
	 *            ip的字节数组形式
	 * @return 字符串形式的ip
	 */
	public static String getIpStringFromLong(long ip) {
		String ipstr = "";
		ipstr = (ip % 256) + ipstr;
		ip = ip / 256;
		ipstr = "." + ipstr;
		ipstr = (ip % 256) + ipstr;
		ip = ip / 256;
		ipstr = "." + ipstr;
		ipstr = (ip % 256) + ipstr;
		ip = ip / 256;
		ipstr = "." + ipstr;
		ipstr = (ip % 256) + ipstr;
		return ipstr;
	}

	/**
	 * 将IP地址转为数字
	 * 
	 * @param ip
	 * @return
	 */
	public static long getLongFromIp(String ip) {
		if (ip == null || ip.trim().length() == 0) {
			return 0;
		}
		String[] ipSeg = ip.split("\\.");
		if (ipSeg.length != 4) {
			return 0;
		}
		try {
			int p0 = DataUtil.parseInt(ipSeg[0]);
			int p1 = DataUtil.parseInt(ipSeg[1]);
			int p2 = DataUtil.parseInt(ipSeg[2]);
			int p3 = DataUtil.parseInt(ipSeg[3]);
			long ipValue = p0 * 256L * 256L * 256L + p1 * 256L * 256L + p2 * 256L + p3;
			return ipValue;
		} catch (Exception e) {
		}
		return 0;
	}

	/**
	 * 将IP地址C段转为数字
	 * 
	 * @param ip
	 * @return
	 */
	public static long getLongFromIpCSeg(String ip) {
		if (ip == null || ip.trim().length() == 0) {
			return 0;
		}
		String[] ipSeg = ip.split("\\.");
		if (ipSeg.length != 4) {
			return 0;
		}
		try {
			int p0 = DataUtil.parseInt(ipSeg[0]);
			int p1 = DataUtil.parseInt(ipSeg[1]);
			int p2 = DataUtil.parseInt(ipSeg[2]);
			// int p3 = DataUtil.parseInt(ipSeg[3]);
			int p3 = 0;
			long ipValue = p0 * 256L * 256L * 256L + p1 * 256L * 256L + p2 * 256L + p3;
			return ipValue;
		} catch (Exception e) {
		}
		return 0;
	}

	public static String replaceNoPrint(String input) {
		if (input == null || input == "") {
			return input;
		}
		char[] chs = input.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < chs.length; i++) {
			// 
			// / 把一个字符串中的 低序位 ASCII 字符 替换成 &#x 字符
			// / 转换 ASCII 0 - 8 -> &#x0 - &#x8
			// / 转换 ASCII 11 - 12 -> &#xB - &#xC
			// / 转换 ASCII 14 - 31 -> &#xE - &#x1F
			if ((chs[i] <= 8) || (chs[i] >= 11 && chs[i] <= 12) || (chs[i] >= 14 && chs[i] <= 31)) {
				sb.append("&#x" + Integer.toHexString((char) chs[i]));
			} else {
				sb.append((char) chs[i]);
			}
		}
		return sb.toString();
	}


	//---------------------------
	
	private static final BigDecimal ONE = new BigDecimal("1");
	private static Log logger = LogFactory.getLog(DataUtil.class);

	/** mergePO 时支持的数据类型 */
	private static Map<Class, String> supportTypeMap = new HashMap<Class, String>();
	static {
		supportTypeMap.put(Integer.class, "");
		supportTypeMap.put(Long.class, "");
		supportTypeMap.put(Double.class, "");
		supportTypeMap.put(BigDecimal.class, "");
		supportTypeMap.put(String.class, "");
		supportTypeMap.put(Date.class, "");
		supportTypeMap.put(Boolean.class, "");
		supportTypeMap.put(byte[].class, "");
	}

	/**
	 * 添加mergePO时支持的类型
	 * 
	 * @param clazz
	 */
	public static void addSupportType(Class clazz) {
		supportTypeMap.put(clazz, "");
	}

	/**
	 * 构造方法，禁止实例化
	 */
	private DataUtil() {
	}

	/**
	 * 当整型数值为0时,返回字符串"",否则将整型值转化为字符串返回. <br>
	 * <br>
	 * <b>示例 </b> <code>
	 * <br>DataUtils.zeroToEmpty(0) 返回 &quot;&quot;
	 * <br>DataUtils.zeroToEmpty(1) 返回 &quot;1&quot;
	 * </code>
	 * 
	 * @param i
	 *            输入的整型值
	 * @return 返回字符串
	 */
	public static String zeroToEmpty(int i) {
		return i == 0 ? "" : String.valueOf(i);
	}

	/**
	 * 当浮点型数值为0时,返回字符串"",否则将浮点型值转化为字符串返回. <br>
	 * <br>
	 * <b>示例 </b> <code>
	 * <br>DataUtils.zeroToEmpty(0d) 返回 &quot;&quot;
	 * <br>DataUtils.zeroToEmpty(1.2d) 返回 &quot;1.2&quot;
	 * </code>
	 * 
	 * @param d
	 *            输入的浮点型值
	 * @return 返回字符串
	 */
	public static String zeroToEmpty(double d) {
		return d == 0 ? "" : String.valueOf(d);
	}

	/**
	 * 当字符串为null时,返回字符串"". <br>
	 * <br>
	 * <b>示例 </b> <code>
	 * <br>DataUtils.nullToEmpty(null) 返回 &quot;&quot;
	 * <br>DataUtils.nullToEmpty(&quot;null&quot;) 返回 &quot;null&quot;
	 * <br>DataUtils.nullToEmpty(&quot;abc&quot;) 返回 &quot;abc&quot;
	 * </code>
	 * 
	 * @param str
	 *            输入字符串
	 * @return 返回字符串
	 */
	public static String nullToEmpty(String str) {
		return str == null ? "" : str;
	}

	/**
	 * 当字符串为""时,返回null. <br>
	 * <br>
	 * <b>示例 </b> <code>
	 * <br>DataUtils.nullToEmpty(null) 返回 null
	 * <br>DataUtils.nullToEmpty(&quot;&quot;) 返回 null
	 * <br>DataUtils.nullToEmpty(&quot;abc&quot;) 返回 &quot;abc&quot;
	 * </code>
	 * 
	 * @param str
	 *            输入字符串
	 * @return 返回字符串
	 */
	public static String emptyToNull(String str) {
		if (str == null) {
			return null;
		}
		if (str.trim().length() == 0) {
			return null;
		}
		return str;
	}

	/**
	 * 当字符串为"null"或为null时,返回字符串"". <br>
	 * <br>
	 * <b>示例 </b> <code>
	 * <br>DataUtils.dbNullToEmpty(null) 返回 &quot;&quot;
	 * <br>DataUtils.dbNullToEmpty(&quot;null&quot;) 返回 &quot;&quot;
	 * <br>DataUtils.dbNullToEmpty(&quot;abc&quot;) 返回 &quot;abc&quot;
	 * </code>
	 * 
	 * @param str
	 *            输入字符串
	 * @return 返回字符串
	 */
	public static String dbNullToEmpty(String str) {
		if (str == null || str.equalsIgnoreCase("null")) {
			return "";
		}
		return str;
	}

	/**
	 * 当字符串为null或""或全部为空格时,返回字符串"0",否则将字符串原封不动的返回. <br>
	 * <br>
	 * <b>示例 </b> <code>
	 * <br>DataUtils.nullToZero(null) 返回 &quot;0&quot;
	 * <br>DataUtils.nullToZero(&quot;&quot;) 返回 &quot;0&quot;
	 * <br>DataUtils.nullToZero(&quot;123&quot;) 返回 &quot;123&quot;
	 * <br>DataUtils.nullToZero(&quot;abc&quot;) 返回 &quot;abc&quot; 注意：从方法的本意出发，请用于数值型字符串
	 * </code>
	 * 
	 * @param str
	 *            输入字符串
	 * @return 返回字符串
	 */
	public static String nullToZero(String str) {
		if (str == null || str.trim().length() == 0) {
			return "0";
		}
		return str;
	}

	/**
	 * 对表达布尔型含义的字符串转换为中文的"是"/"否". <br>
	 * <br>
	 * <b>示例 </b> <code>
	 * <br>DataUtils.getBooleanDescribe(&quot;y&quot;) 返回 &quot;是&quot;
	 * <br>DataUtils.getBooleanDescribe(&quot;yes&quot;) 返回 &quot;是&quot;
	 * <br>DataUtils.getBooleanDescribe(&quot;Y&quot;) 返回 &quot;是&quot;
	 * <br>DataUtils.getBooleanDescribe(&quot;true&quot;) 返回 &quot;是&quot;
	 * <br>DataUtils.getBooleanDescribe(&quot;T&quot;) 返回 &quot;是&quot;
	 * <br>
	 * <br>DataUtils.getBooleanDescribe(&quot;n&quot;) 返回 &quot;否&quot;
	 * <br>DataUtils.getBooleanDescribe(&quot;No&quot;) 返回 &quot;否&quot;
	 * <br>DataUtils.getBooleanDescribe(&quot;N&quot;) 返回 &quot;否&quot;
	 * <br>DataUtils.getBooleanDescribe(&quot;false&quot;) 返回 &quot;否&quot;
	 * <br>DataUtils.getBooleanDescribe(&quot;f&quot;) 返回 &quot;否&quot;
	 * </code>
	 * 
	 * @param str
	 *            表达布尔型含义的字符串. <br>
	 *            合法的输入包括"y","n","yes","no","true","false","t","f","是","否","1","0",""这些字符串的各种大小写形式也属于合法的
	 *            <br>
	 *            除了上述合法的入参值之外，输入其它的字符串，将抛出异常
	 * @return 布尔变量对应的中文描述："是"/"否"/""
	 */
	public static String getBooleanDescribe(String str) {
		if (str == null) {
			throw new IllegalArgumentException("argument is null");
		} 
		if (str.equalsIgnoreCase("y") || str.equalsIgnoreCase("yes")
				|| str.equalsIgnoreCase("true") || str.equalsIgnoreCase("t")
				|| str.equalsIgnoreCase("是") || str.equalsIgnoreCase("1")) {
			return "是";
		} else if (str.equalsIgnoreCase("n") || str.equalsIgnoreCase("no")
				|| str.equalsIgnoreCase("false") || str.equalsIgnoreCase("f")
				|| str.equalsIgnoreCase("否") || str.equalsIgnoreCase("0")) {
			return "否";
		} else if (str.trim().equals("")) {
			return "";
		}
		throw new IllegalArgumentException(
				"argument not in ('y','n','yes','no','true','false','t','f','是','否','1','0','')");
	}

	/**
	 * 对表达布尔型含义的字符串转换为boolean型的true/false. <br>
	 * <br>
	 * <b>示例 </b> <code>
	 * <br>DataUtils.getBoolean(&quot;y&quot;) 返回 true
	 * <br>DataUtils.getBoolean(&quot;yes&quot;) 返回 true
	 * <br>DataUtils.getBoolean(&quot;Y&quot;) 返回 true
	 * <br>DataUtils.getBoolean(&quot;true&quot;) 返回 true
	 * <br>DataUtils.getBoolean(&quot;T&quot;) 返回 true
	 * <br>
	 * <br>DataUtils.getBoolean(&quot;n&quot;) 返回 false
	 * <br>DataUtils.getBoolean(&quot;No&quot;) 返回 false
	 * <br>DataUtils.getBoolean(&quot;N&quot;) 返回 false
	 * <br>DataUtils.getBoolean(&quot;false&quot;) 返回 false
	 * <br>DataUtils.getBoolean(&quot;f&quot;) 返回 false
	 * </code>
	 * 
	 * @param str
	 *            表达布尔型含义的字符串. <br>
	 *            合法的输入包括"y","n","yes","no","true","false","t","f","是","否","1","0",""这些字符串的各种大小写形式也属于合法的
	 *            <br>
	 *            除了上述合法的入参值之外，输入其它的字符串，将抛出异常
	 * @return boolean型的true/false
	 */
	public static boolean getBoolean(String str) {
		if (str == null) {
			throw new IllegalArgumentException("argument is null");
		}
		if (str.equalsIgnoreCase("y") || str.equalsIgnoreCase("yes")
				|| str.equalsIgnoreCase("true") || str.equalsIgnoreCase("t")
				|| str.equalsIgnoreCase("是") || str.equalsIgnoreCase("1")) {
			return true;
		} else if (str.equalsIgnoreCase("n") || str.equalsIgnoreCase("no")
				|| str.equalsIgnoreCase("false") || str.equalsIgnoreCase("f")
				|| str.equalsIgnoreCase("否") || str.equalsIgnoreCase("0")) {
			return false;
		} else if (str.trim().equals("")) {
			return false;
		}
		throw new IllegalArgumentException(
				"argument not in ('y','n','yes','no','true','false','t','f','是','否','1','0','')");
	}

	/**
	 * 返回对应boolean型变量的字符串型中文描述：'是'/'否'. <br>
	 * <br>
	 * <b>示例 </b> <code>
	 * <br>DataUtils.getBooleanDescribe(true) 返回 '是'
	 * <br>DataUtils.getBooleanDescribe(false) 返回 '否'
	 * </code>
	 * 
	 * @param bln
	 *            布尔型变量. <br>
	 * @return 字符串型中文描述：'是'/'否'
	 */
	public static String getBooleanDescribe(boolean bln) {
		if (bln) {
			return getBooleanDescribe("true");
		}
		return getBooleanDescribe("false");
	}

	/**
	 * 比较两个存放了数字的字符串的大小，如果不为数字将抛出异常. <br>
	 * <br>
	 * <b>示例 </b> <code>
	 * <br>DataUtils.compareByValue(&quot;19&quot;,&quot;2&quot;) 返回 1
	 * <br>DataUtils.compareByValue(&quot;0021&quot;,&quot;21&quot;) 返回 0
	 * <br>DataUtils.compareByValue(&quot;3001&quot;,&quot;5493&quot;) 返回 -1
	 * </code>
	 * 
	 * @param str1
	 *            第一个字符串
	 * @param str2
	 *            第二个字符串
	 * @return 返回比较的结果 str1>str2返回1，str1 <str2返回-1，str1=str2返回0
	 */
	public static int compareByValue(String str1, String str2) {
		BigDecimal big1 = new BigDecimal(str1);
		BigDecimal big2 = new BigDecimal(str2);
		return big1.compareTo(big2);
	}

	/**
	 * 提供精确的小数位四舍五入处理. <br>
	 * <br>
	 * <b>示例 </b> <code>
	 * <br>DataUtils.round(0.574,2) 返回 0.57
	 * <br>DataUtils.round(0.575,2) 返回 0.58
	 * <br>DataUtils.round(0.576,2) 返回 0.58
	 * </code>
	 * 
	 * @param value
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double round(double value, int scale) {
		BigDecimal b = new BigDecimal(Double.toString(value));
		return b.divide(ONE, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 拷贝简单对象.(null也将拷贝)
	 * 
	 * @param source
	 *            传入的源对象
	 * @param target
	 *            传入的目标对象
	 */
	public static void copySimpleObject(Object source, Object target) {
		copySimpleObject(source, target, true);
	}

	/**
	 * 拷贝简单对象.
	 * 
	 * @param source
	 *            传入的源对象
	 * @param target
	 *            传入的目标对象
	 * @param isCopyNull
	 *            是否拷贝Null值
	 */
	public static void copySimpleObject(Object source, Object target,
			boolean isCopyNull) {
		if (target == null || source == null) {
			return;
		}
		List targetMethodList = BeanUtilsEx.getSetter(target.getClass());
		List sourceMethodList = BeanUtilsEx.getGetter(source.getClass());
		Map<String, Method> map = new HashMap<String, Method>();
		for (Iterator iter = sourceMethodList.iterator(); iter.hasNext();) {
			Method method = (Method) iter.next();
			map.put(method.getName(), method);
		}
		for (Iterator iter = targetMethodList.iterator(); iter.hasNext();) {
			Method method = (Method) iter.next();
			String fieldName = method.getName().substring(3);
			try {
				Method sourceMethod = (Method) map.get("get" + fieldName);
				if (sourceMethod == null) {
					sourceMethod = (Method) map.get("is" + fieldName);
				}
				if (sourceMethod == null) {
					continue;
				}
				if (!supportTypeMap.containsKey(sourceMethod.getReturnType())) {
					continue;
				}

				Object value = sourceMethod.invoke(source, new Object[0]);
				if (isCopyNull) {
					method.invoke(target, new Object[] { value });
				} else {
					if (value != null) {
						method.invoke(target, new Object[] { value });
					}
				} 
			} catch (Exception e) {
				if(logger.isDebugEnabled()){
					logger.debug(e); 
				}
			}
		}
	}

	/**
	 * 把通过JdbcTemplate查出的结果集封装到List中<br>
	 * 只要字段名和DTO的属性名能对应上的就把值封装进去，对应不上的就不管了
	 * 
	 * @param jdbcResultList
	 *            用JdbcTemplate查出的结果集
	 * @param clazz
	 *            DTO的Class对象
	 * @return 把每行数据封装到一个DTO对象中，最后返回DTO的List
	 */
	public static List generateListFromJdbcResult(List jdbcResultList,
			Class clazz) {
		List<Object> objectList = new ArrayList<Object>();
		try {
			List methodList = BeanUtilsEx.getSetter(clazz);
			for (int i = 0; i < jdbcResultList.size(); i++) {
				Map rowMap = (Map) jdbcResultList.get(i);
				Object[] rowKeys = rowMap.keySet().toArray();
				Object object = clazz.newInstance();
				for (int j = 0; j < rowKeys.length; j++) {
					String column = (String) rowKeys[j];
					for (int k = 0; k < methodList.size(); k++) {
						Method method = (Method) methodList.get(k);
						String upperMethodName = method.getName().toUpperCase();
						if (upperMethodName.equals("SET" + column)) {
							Class type = method.getParameterTypes()[0];
							Object value = rowMap.get(column);
							if (value != null) {
								if (type == Integer.class) {
									value = new Integer(value.toString());
								} else if (type == Double.class) {
									value = new Double(value.toString());
								} else if (type == Long.class) {
									value = new Long(value.toString());
								}
							}
							method.invoke(object, new Object[] { value });
							break;
						}
					}
				}
				objectList.add(object);
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return objectList;
	}

	/**
	 * 把Object对象转换为Integer对象。
	 * 
	 * @param object
	 * @return Integer对象或null（如果object是null）。
	 */
	public static Integer getInteger(Object object) {
		Integer _integer = null;
		if (object != null) {
			_integer = new Integer(object.toString());
		}
		return _integer;
	}

	/**
	 * 把Object对象转换为Long对象。
	 * 
	 * @param object
	 * @return Long对象或null（如果object是null）。
	 */
	public static Long getLong(Object object) {
		Long _long = null;
		if (object != null) {
			_long = new Long(object.toString());
		}
		return _long;
	}

	/**
	 * 把Object对象转换为Double对象。
	 * 
	 * @param object
	 * @return Double对象或null（如果object是null）。
	 */
	public static Double getDouble(Object object) {
		Double _double = null;
		if (object != null) {
			_double = new Double(object.toString());
		}
		return _double;
	}

	/**
	 * 把Object对象转换为String对象。
	 * 
	 * @param object
	 * @return String对象或null（如果object是null）。
	 */
	public static String getString(Object object) {
		String string = null;
		if (object != null) {
			string = new String(object.toString());
		}
		return string;
	}

	public static String getPlainNumber(Integer integer) {
		if (integer == null) {
			return "";
		}
		DecimalFormat df = new DecimalFormat("###0");
		String plainNumber = df.format(integer);
		return plainNumber;
	}

	public static String getPlainNumber(Long _long) {
		if (_long == null) {
			return "";
		}
		DecimalFormat df = new DecimalFormat("###0");
		String plainNumber = df.format(_long);
		return plainNumber;
	}

	public static String getPlainNumber(Double _double) {
		if (_double == null) {
			return "";
		}
		DecimalFormat df = new DecimalFormat("###0.00");
		String plainNumber = df.format(_double);
		return plainNumber;
	}

	/**
	 * 判断字符串是不是数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		if (str == null) return false;
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}
	/**----------------------JSON转换模块 ----------------------**/
	private static ObjectMapper objectMapper = new ObjectMapper();
	/**
	 * 对象返回Json字符串
	 * 
	 * @param obj
	 * @param <T>
	 * @return
	 */
	public static <T> String obj2json(T obj) {

		try {
			if (obj == null) {
				return null;
			}
			if (obj.equals(String.class)) {
				return obj.toString();
			}
			return objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			logger.error("Parse object to String error", e);
			return null;
		}
	}

	/**
	 * Json字符串转成对象
	 * 
	 * @param str
	 * @param clazz
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	public static <T> T json2Obj(String str, Class<T> clazz) {

		try {
			if (StringUtils.isEmpty(str) || clazz == null) {
				return null;
			}
			if (clazz.equals(String.class)) {
				return (T) str;
			}
			return objectMapper.readValue(str, clazz);
		} catch (Exception e) {
			logger.error("Parse String to Object error", e);
			return null;
		}
	}

	/**
	 * 泛型反序列化
	 * 
	 * @param str
	 * @param typeReference
	 *            对应返回值的类型
	 * @param <T>
	 * @return
	 */
	public static <T> T json2Obj(String str, TypeReference<T> typeReference) {

		try {
			if (StringUtils.isEmpty(str) || typeReference == null) {
				return null;
			}
			if (typeReference.getType().equals(String.class)) {
				return (T) str;
			}
			return  objectMapper.readValue(str, typeReference);
		} catch (IOException e) {
			logger.error("Parse String to Object error", e);
			return null;
		}
	}

	/**
	 * 泛型反序列化
	 * 
	 * @param str
	 * @param collectionClass
	 *            集合的类型
	 * @param elementClasses
	 *            集合中元素的类型
	 * @param <T>
	 * @return
	 */
	public static <T> T json2Obj(String str, Class<?> collectionClass, Class<?>... elementClasses) {
		try {
			TypeFactory typeFactory = objectMapper.getTypeFactory();
			JavaType javaType = typeFactory.constructParametricType(collectionClass, elementClasses);
			return objectMapper.readValue(str, javaType);
		} catch (Exception e) {
			logger.error("Parse String to Object error", e);
			return null;
		}
	}
	/**----------------------JSON转换模块 ----------------------**/
}
