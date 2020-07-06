package com.bc.base.util;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p><b>Title:</b><i>日期处理工具</i></p>
 * <p>Desc: 日期处理工具</p>
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
public class DateUtils {
	private static final long SECOND = 1000;
	private static final long MINUTE = SECOND * 60;
	private static final long HOUR = MINUTE * 60;
	private static final long DAY = HOUR * 24;
	private static final long WEEK = DAY * 7;
	private static final long MONTH = DAY * 30;
	private static final long YEAR = DAY * 365;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat();
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat dateFormatDB = new SimpleDateFormat("yyyyMMdd");// 数据库使用的日期格式
	public static SimpleDateFormat dateFormatMothDB = new SimpleDateFormat("yyyyMM");// 数据库使用的日期格式
	public static SimpleDateFormat dataTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static HashMap<String, SimpleDateFormat> _simpleDateFormat = new HashMap<String, SimpleDateFormat>();

	private static final Log log = LogFactory.getLog(DateUtils.class);
	
	public static final long TIME_CARRY = 60; /*时间进位制*/
	public static final long SECOND_MILLIS = 1000; /*一秒的毫秒数*/
	public static final long MINUTE_MILLIS = SECOND_MILLIS * 60; /*一分钟的毫秒数*/
	public static final long HOUR_MILLIS = MINUTE_MILLIS * 60;  /*一个小时的毫秒数*/
	public static final long DAY_MILLIS = HOUR_MILLIS * 24; /*一天的毫秒数*/

	
	
	public static String formatDateTime(Date date) {
		return dataTimeFormat.format(date);
	}

	/**
	 * 创建一个"yyyy-MM-dd"日期的格式化对象
	 * @return "yyyy-MM-dd"日期的格式化对象
	 */
	private static SimpleDateFormat newLongYMDFormat() {
		return new SimpleDateFormat("yyyy-MM-dd");
	}

	/**
	 * 创建一个"yyyy-MM-dd HH:mm:ss"日期的格式化对象
	 * @return "yyyy-MM-dd HH:mm:ss"日期的格式化对象
	 */
	private static SimpleDateFormat newLongYMDHMSFormat() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * "yyyyMMddHHmmss"格式的日期转换为"yyyy-MM-dd HH:mm:ss"格式的日期
	 * @param shortYMDHMS "yyyyMMddHHmmss"格式的日期
	 * @return "yyyy-MM-dd HH:mm:ss"格式的日期
	 * @throws ParseException
	 */
	public static String toLongYMDHMS(String shortYMDHMS) throws ParseException {
		return newLongYMDHMSFormat().format(newShortYMDHMSFormat().parse(shortYMDHMS));
	}

	/**
	 * 获得"yyyy-MM-dd"格式的当前日期
	 * @return 返回"yyyy-MM-dd"格式的当前日期
	 */
	public static String getLongYMD() {
		return newLongYMDFormat().format(new Date());
	}

	/**
	 * 创建一个"yyyyMMdd"日期的格式化对象
	 * @return "yyyyMMdd"日期的格式化对象
	 */
	private static SimpleDateFormat newShortYMDFormat() {
		return new SimpleDateFormat("yyyyMMdd");
	}

	/**
	 * 创建一个"yyyyMMddHHmmss"日期的格式化对象
	 * @return "yyyyMMddHHmmss"日期的格式化对象
	 */
	private static SimpleDateFormat newShortYMDHMSFormat() {
		return new SimpleDateFormat("yyyyMMddHHmmss");
	}

	/**
	 * 获得"yyyyMMddHHmmss"格式的当前日期
	 * @return 返回"yyyyMMddHHmmss"格式的当前时间
	 */
	public static String getShortYMDHMS() {
		return newShortYMDHMSFormat().format(new Date());
	}

	/**
	 * "yyyyMMdd"格式的日期转换为"yyyy-MM-dd"格式的日期
	 * @param shortYMD "yyyyMMdd"格式的日期
	 * @return "yyyy-MM-dd"格式的日期
	 * @throws ParseException
	 */
	public static String toLongYMD(String shortYMD) {
		try {
			return newLongYMDFormat().format(newShortYMDFormat().parse(shortYMD));
		} catch (ParseException e) {
			// Auto-generated catch block

			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 
	 * 功能：生成日期yyyyMMdd
	 *
	 * @return
	 */
	public static String getDbDate() {
		return dateFormatDB.format(new Date());
	}
	
	
	/**
	 * 
	 * 功能：生成日期yyyyMM
	 *
	 * @return
	 */
	public static String getDbMothDate() {
		return dateFormatMothDB.format(new Date());
	}
	

	/**
	 * 
	 * 功能：把日期yyyy-MM-dd格式转换成yyyyMMDD日期格式
	 *
	 * @param dateStr
	 * @return
	 */
	public static String convertClientDateToDbDate(String dateStr) {
		String dbDateStr = null;
		try {
			dbDateStr = dateFormatDB.format(dateFormat.parse(dateStr));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dbDateStr;
	}
//  parse 相关start
	/**
	 * 
	 * 方法用途: 字符串转时间，转失败返回默认<br>
	 * 操作步骤: TODO<br>
	 * @param dateString
	 * @param pattern yyyy-MM-dd HH:mm:ss 或是 yyyy-MM-dd
	 * @param defaultValue
	 * @return
	 */
	public static Date parse(String dateString, String pattern, Date defaultValue){
		if(StringUtils.isEmpty(dateString) || StringUtils.isEmpty(pattern)){
			return defaultValue;
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			Date date = sdf.parse(dateString);
			return date;
		} catch (Exception e) {
			log.error("parse date error", e);
		}
		return defaultValue;
	}
	
	/**
	 * 根据传过来的字符串型的date，转换成对应的日期
	 * @param date
	 * @return
	 */
	public static Date str2Date(String date) {
		Date ret = null;
		if (date.length() == 10) {
			try {
				ret = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (date.length() == 16) {
			try {
				ret = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (date.length() == 19) {
			try {
				ret = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (date.length() == 13) {
			try {
				ret = new SimpleDateFormat("yyyy-MM-dd HH").parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (date.length() == 7) {
			try {
				ret = new SimpleDateFormat("yyyy-MM").parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
	/**
	 * 获取当前日期时间 格式: yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static Date getDateTime() {
		return getDateTime(getDate("yyyy-MM-dd HH:mm:ss"));
	}
	/**
	 * 获取当前日期 格式:参数 例如 yyyy-MM-dd
	 * 
	 * @param formatStr
	 * @return
	 */
	public static String getDate(String formatStr) {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat(formatStr);
		// TimeZone zone = new SimpleTimeZone(28800000, "Asia/Shanghai");
		// df.setTimeZone(zone);
		return df.format(c.getTime());
	}

	/**
	 * 获取当前日期时间 格式: yyyy-MM-dd HH:mm:ss
	 * 
	 * @param dtime
	 * @return Date
	 */
	public static Date getDateTime(String dtime) {
		try {
			DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return format1.parse(dtime);
		} catch ( ParseException e ) {}
		return null;
	}

	/**
	 * 获取当前日期时间 格式:参数 例如 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param dtime
	 * @param formatStr
	 * @return
	 */
	public static Date getDateTime(String dtime, String formatStr) {
		try {
			DateFormat format1 = new SimpleDateFormat(formatStr);
			return format1.parse(dtime);
		} catch ( ParseException e ) {}
		return null;
	}
	/**
	 * 格式为yyyy-MM-dd的字符串格式化字符串为日期
	 * 
	 * @param date
	 *            字符串形式的日期
	 * @param formatPattern
	 *            格式化格式
	 * @return Date 根据字符串格式化后的日期
	 */
	public static Date getStringDate(String date) {
		return getStringDate(date, null);
	}

	/**
	 * 根据参数格式化字符串为日期，默认格式为yyyy-MM-dd
	 * 
	 * @param date
	 *            字符串形式的日期
	 * @param formatPattern
	 *            格式化格式
	 * @return Date 根据字符串格式化后的日期
	 */
	public static Date getStringDate(String date, String formatPattern) {
		try {
			if ((formatPattern == null) || formatPattern.equals("")) {
				formatPattern = "yyyy-MM-dd";
			}
			sdf.applyPattern(formatPattern);
			return sdf.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取格式为yyyy-MM-dd HH:mm:ss的日期
	 * 
	 * @param date
	 *            字符串形式的日期
	 * @return 根据字符串格式化后的日期
	 */
	public static Date getStringDateTime(String date) {
		return getStringDateTime(date, null);
	}

	/**
	 * 根据参数格式化字符串为日期，默认格式为yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 *            字符串形式的日期
	 * @param formatPattern
	 *            格式化格式
	 * @return Date 根据字符串格式化后的日期
	 */
	public static Date getStringDateTime(String date, String formatPattern) {
		try {
			if ((formatPattern == null) || formatPattern.equals("")) {
				formatPattern = "yyyy-MM-dd HH:mm:ss";
			}
			sdf.applyPattern(formatPattern);
			return sdf.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	 public static Date StringToDate(String dateStr, String mode) throws ParseException {
	        SimpleDateFormat s = new SimpleDateFormat(mode);
	        return s.parse(dateStr);
	    }
	/**
	 * 
	 * 方法用途: TODO<br>
	 * 操作步骤: TODO<br>
	 * @param str
	 * @param pattern
	 * @return
	 */
	public static Date parse(String str, String pattern) {
		return parse(str,pattern,new Date());
	}
	
//	parse 相关end

	/**
	 * 
	 * 功能：格式化日期字符串
	 * 例如：2008-8-8  转换为2008-08-08
	 *
	 * @param dateStr
	 * @return
	 */
	public static String getDateStrFormat(String dateStr) {
		try {
			Date date = dateFormat.parse(dateStr);
			return dateFormat.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	

	/**
	 * 计算两个日期之间的天数
	 * 
	 * @param startDate
	 *          开始时间
	 * @param endDate
	 *          结束时间
	 * @return
	 */
	public static int calcDays(String startDate, String endDate) {
		int days = 1;
		try {
			long start = dateFormat.parse(startDate).getTime();
			long end = dateFormat.parse(endDate).getTime();
			days = (int) ((end - start) / (24 * 60 * 60 * 1000));
		} catch (ParseException e) {
			e.printStackTrace();
			return -1;
		}
		return days;
	}

	/**
	 * 计算两个日期之间的天数
	 * 
	 * @param startDate
	 *          开始时间
	 * @param endDate
	 *          结束时间
	 * @return
	 */
	public static int calcDay(String startDate, String endDate) {
		int days = 1;
		try {
			long start = dateFormatDB.parse(startDate).getTime();
			long end = dateFormatDB.parse(endDate).getTime();
			days = (int) ((end - start) / (24 * 60 * 60 * 1000));
		} catch (ParseException e) {
			e.printStackTrace();
			return -1;
		}
		return days;
	}

	/**
	 * 功能：指定日期加上指定天数
	 * 
	 * @param date
	 *          日期
	 * @param day
	 *          天数
	 * @return 返回相加后的日期
	 */
	public static Date addDate(Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
		return c.getTime();
	}

	/**
	 * 功能：指定日期加上指定天数
	 * 
	 * @param date
	 *          日期
	 * @param minute
	 *          分钟
	 * @return 返回相加后的日期
	 */
	public static Date addMinute(Date date, int minute) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) + ((long) minute) * 60 * 1000);
		return c.getTime();
	}

	/**
	 * 
	 * 功能：添加指定秒杀的时间
	 *
	 * @param date
	 * @param second
	 * @return
	 */
	public static Date addSecond(Date date, int second) {
		long s = date.getTime();
		s = s + second * 1000;
		return new Date(s);
	}

	/**
	 * 功能：指定日期减去指定天数
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date diffDate(Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) - ((long) day) * 24 * 3600 * 1000);
		return c.getTime();
	}

	
	
	/**
	 * 
	 * 功能：分钟相差 minute的时间值
	 * 
	 * @param date
	 * @param minute
	 * @return
	 */
	public static Date getDateByMinuteAdd(Date date, int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minute);
		return calendar.getTime();
	}

	

    
    /**
     * 
     * 方法用途: 日期相减<br>
     * 操作步骤: 两个日期相隔天数<br>
     * @param startDate  开始日期
     * @param endDate 结束日期
     * @return 返回相减后的日期
     */
    public static int diffDate(Date startDate, Date endDate) {
        return (int) ((getMillis(endDate) - getMillis(startDate)) / (24 * 3600 * 1000));
    }
//已整体开始 日期字符串格式化成其他字符串
	/**
	 * 
	 * 方法用途: 传入时间按所需格式返回时间字符串<br>
	 * 操作步骤: TODO<br>
	 * @param date java.util.Date格式
	 * @param format yyyy-MM-dd HH:mm:ss | yyyy年MM月dd日 HH时mm分ss秒
	 * @return
	 */
	public static String format(Date date, String format) {
		String result = "";
		try {
			if (date == null) {
				date = new Date();// 如果时间为空,则默认为当前时间
			}
			if (StringUtils.isBlank(format)) {// 默认格式化形式
				format = "yyyy-MM-dd";
			}
			DateFormat df = new SimpleDateFormat(format);
			result = df.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	

	/**
	 * 
	 * 方法用途: 时间字符串格式转换<br>
	 * 操作步骤: TODO<br>
	 * @param dateStr 时间字符串
	 * @param format 时间字符串的格式
	 * @param toFormat 格式为的格式
	 * @return
	 */
	public static String format(String dateStr, String format, String toFormat) {
		return format(format(dateStr, format), toFormat);
	}
	/**
	 * 
	 * 方法用途: 传入时间字符串按所需格式返回时间<br>
	 * 操作步骤: TODO<br>
	 * @param dateStr 时间字符串
	 * @param format 跟传入dateStr时间的格式必须一样 yyyy-MM-dd HH:mm:ss | yyyy年MM月dd日 HH时mm分ss秒
	 * @return
	 */
	public static Date format(String dateStr, String format) {
		if (StringUtils.isBlank(dateStr)) {
			return new Date();
		}
		if (StringUtils.isBlank(format)) {
			format = "yyyy-MM-dd";
		}
		Date date = null;
		try {
			DateFormat f = new SimpleDateFormat(format);
			date = f.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;

	}
	//已整体结束 日期字符串格式化成其他字符串
	/**
	 * 
	 * 方法用途: 格式化rss的时间<br>
	 * 操作步骤: TODO<br>
	 * @param date
	 * @return
	 */
	public static String formatRssDate(Date date) {
		if (date == null) {
			date = new Date();// 如果时间为空,则默认为当前时间
		}
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
		SimpleTimeZone zone = new SimpleTimeZone(8, "GMT");
		sdf.setTimeZone(zone);
		return sdf.format(date);
	}

	/**
	 * 
	 * 方法用途: 返回年<br>
	 * 操作步骤: TODO<br>
	 * @param date
	 * @return
	 */
	public static int getYear(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);

	}

	/**
	 * 
	 * 方法用途: 返回月<br>
	 * 操作步骤: TODO<br>
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH) + 1;
	}

	/**
	 * 
	 * 方法用途: 返回日<br>
	 * 操作步骤: TODO<br>
	 * @param date
	 * @return
	 */
	public static int getDay(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 
	 * 方法用途: 返回小时<br>
	 * 操作步骤: TODO<br>
	 * @param date
	 * @return
	 */
	public static int getHour(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 
	 * 方法用途: 返回分<br>
	 * 操作步骤: TODO<br>
	 * @param date
	 * @return
	 */
	public static int getMinute(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MINUTE);
	}

	/**
	 * 
	 * 方法用途: 返回星期 1：星期一，2:星期二 ... 6:星期六 7:星期日<br>
	 * 操作步骤: TODO<br>
	 * @param date
	 * @return
	 */
	public static int getChinaWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int week = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (week == 0) {
			return 7;
		} else {
			return week;
		}
	}

	/**
	 * 
	 * 方法用途: 返回秒<br>
	 * 操作步骤: TODO<br>
	 * @param date
	 * @return
	 */
	public static int getSecond2(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.SECOND);
	}

	/**
	 * 
	 * 方法用途: 返回毫秒<br>
	 * 操作步骤: TODO<br>
	 * @param date 日期
	 * @return 返回毫秒
	 */
	public static long getMillis(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * 
	 * 方法用途: 获取当前月的第一天日期<br>
	 * 操作步骤: TODO<br>
	 * @return
	 */
	public static Date getMonFirstDay() {
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.set(getYear(date), getMonth(date) - 1, 1);
		return c.getTime();
	}

	/**
	 * 
	 * 方法用途: 获取当前月的最后一天日期<br>
	 * 操作步骤: TODO<br>
	 * @return
	 */
	public static Date getMonLastDay() {
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.set(getYear(date), getMonth(date), 1);
		c.setTimeInMillis(c.getTimeInMillis() - (24 * 3600 * 1000));
		return c.getTime();
	}
	
	/**
	 * 
	 * 方法用途: 获得本月的第一天的日期<br>
	 * 操作步骤: TODO<br>
	 * @return
	 */
	public static String getCurrMonthFirstDay() {
		Calendar cal = Calendar.getInstance();
		String s = (getYear(cal)) + "-" + (getMonth(cal)) + "-01";
		return s;
	}

	/**
	 * 
	 * 方法用途: 获得本月的最后一天的日期 <br>
	 * 操作步骤: TODO<br>
	 * @return
	 */
	public static String getCurrMonthLastDay() {
		Calendar cal = Calendar.getInstance();
		String s = (getYear(cal)) + "-" + (getMonth(cal)) + "-" + getDays(cal);
		return s;
	}
	
	/**
	 * 
	 * 方法用途: 获得给定日期当月的天数<br>
	 * 操作步骤: TODO<br>
	 * @param cal
	 * @return
	 */
	public static int getDays(Calendar cal) {
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 
	 * 方法用途: 获得给定日历的年<br>
	 * 操作步骤: TODO<br>
	 * @param cal
	 * @return
	 */
	public static int getYear(Calendar cal) {
		return cal.get(Calendar.YEAR);
	}
	
	/**
	 * 
	 * 方法用途: 获得给定日历的月<br>
	 * 操作步骤: TODO<br>
	 * @param cal
	 * @return
	 */
	public static int getMonth(Calendar cal) {
		return (cal.get(Calendar.MONTH) + 1);
	}

	/**
	 * 
	 * 方法用途: 获得给定日期字符串对应的年<br>
	 * 操作步骤: TODO<br>
	 * @param date_str
	 * @param type
	 * @return
	 */
	public static int getYear(String date_str, String type) {
		return (convertStrToCal(date_str, type).get(Calendar.YEAR));
	}
	
	/**
	 * 
	 * 方法用途: 日期转日历<br>
	 * 操作步骤: TODO<br>
	 * @param date
	 * @return
	 */
	public static Calendar convertDateToCal(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	
	/**
	 * 
	 * 方法用途: 字符转换日历(动态格式转换)<br>
	 * 操作步骤: TODO<br>
	 * @param date_str
	 * @param type
	 * @return
	 */
	public static Calendar convertStrToCal(String date_str, String type) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(parse(date_str, type));
		return cal;
	}
	
	

	/**
	 * 
	 * 方法用途: 获取当前日期 格式:2008-02-02 23:11:10<br>
	 * 操作步骤: TODO<br>
	 * @return
	 */
	public static String getCurrentDateTimeForString() {
		Date date = new Date();
		return dataTimeFormat.format(date);
	}

	/**
	 * 
	 * 方法用途: 获取当前日期 格式:20101010<br>
	 * 操作步骤: TODO<br>
	 * @return
	 */
	public static String getCurrentDateForString() {
		Date date = new Date();
		return dateFormat.format(date);
	}
	/**
	 * 
	 * 方法用途: 获取当前日期对象<br>
	 * 操作步骤: TODO<br>
	 * @return
	 */
	public static Date getCurrentDate() {
		Date date = new Date();
		return date;
	}

	/**
	 * 创建一个"yyyyMM"日期的格式化对象
	 * @return "yyyyMM"日期的格式化对象
	 */
	private static SimpleDateFormat newShortYMFormat() {
		return new SimpleDateFormat("yyyyMM");
	}

	/**
	 * 获得距离输入月份的diffMonth月的日期
	 * @param month "yyyyMM"格式的日期
	 * @param diffMonth 相差的月数
	 * @return "yyyyMM"格式的日期
	 * @throws ParseException
	 */
	public static String getShortYMDiffMonth(String month, int diffMonth) {
		SimpleDateFormat sdf = newShortYMFormat();
		try {
			sdf.parse(month);
		} catch (ParseException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		Calendar c = sdf.getCalendar();
		c.add(Calendar.MONTH, diffMonth);
		return sdf.format(c.getTime());
	}

	/**
	 * 获得距离给定日期diffDay天的日期
	 * @param shortYMD "yyyyMMdd"格式的日期
	 * @param diffDay 相差的天数
	 * @return "yyyyMMdd"格式的日期
	 * @throws ParseException
	 */
	public static String getShortYMDDiffDay(String shortYMD, int diffDay) {
		SimpleDateFormat sdf = newShortYMDFormat();
		try {
			sdf.parse(shortYMD);
		} catch (ParseException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		Calendar c = sdf.getCalendar();
		c.add(Calendar.DATE, diffDay);
		return sdf.format(c.getTime());
	}

	/**
	 * 获取某月份的最后一天
	 * @param shortYM 月份
	 * @return 输入月份的最后一天
	 * @throws Exception
	 */
	public static String getEndDayOfMonth(String shortYM) {
		String month = "";
		try {
			month = DateUtils.getShortYMDiffMonth(shortYM, 1);
		} catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return DateUtils.getShortYMDDiffDay(month + "01", -1);
	}

	/**
	* 获得"yyyyMMdd"格式的当前日期
	* @return 返回"yyyyMMdd"格式的当前日期
	*/
	public static String getShortYMD() {
		return newShortYMDFormat().format(new Date());
	}

	/**
	 * 获得两个日期之间的所有日期列表（包括起始日期和结束日期）
	 * @param startShortYMD "yyyyMMdd"格式的起始日期
	 * @param endShortYMD "yyyyMMdd"格式的结束日期
	 * @return "yyyyMMdd"格式的日期列表
	 * @throws ParseException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getShortYMDList(String startShortYMD, String endShortYMD) throws ParseException {
		SimpleDateFormat startDateFormat = newShortYMDFormat();
		startDateFormat.parse(startShortYMD);
		Calendar startCal = startDateFormat.getCalendar();

		SimpleDateFormat endDateFormat = newShortYMDFormat();
		endDateFormat.parse(endShortYMD);
		Calendar endCal = endDateFormat.getCalendar();

		List dateList = new ArrayList();
		while (startCal.before(endCal)) {
			dateList.add(startDateFormat.format(startCal.getTime()));
			startCal.add(Calendar.DATE, 1);
		}

		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			dateList.add(startDateFormat.format(endCal.getTime()));
		}

		return dateList;
	}

	/**
	 * 获得两个日期之间的所有日期列表（包括起始日期和结束日期）
	 * @param startShortYM "yyyyMM"格式的起始日期
	 * @param endShortYM "yyyyMM"格式的结束日期
	 * @return "yyyyMM"格式的日期列表
	 * @throws ParseException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getShortYMList(String startShortYM, String endShortYM) throws ParseException {
		SimpleDateFormat startDateFormat = newShortYMFormat();
		startDateFormat.parse(startShortYM);
		Calendar startCal = startDateFormat.getCalendar();

		SimpleDateFormat endDateFormat = newShortYMFormat();
		endDateFormat.parse(endShortYM);
		Calendar endCal = endDateFormat.getCalendar();

		List dateList = new ArrayList();
		while (startCal.before(endCal)) {
			dateList.add(startDateFormat.format(startCal.getTime()));
			startCal.add(Calendar.MONTH, 1);
		}

		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			dateList.add(startDateFormat.format(endCal.getTime()));
		}

		return dateList;
	}

	/**
	 * 验证输入的日期是否合法
	 * @param expDate
	 * @return
	 */
	public static boolean checkExpDate(String expDate) {
		int year = DataUtil.parseInt(expDate.substring(0, 4));
		int month = DataUtil.parseInt(expDate.substring(4, 6));
		int day = DataUtil.parseInt(expDate.substring(6, 8));
		if (month > 12 || month < 1) {
			return false;
		}

		int[] monthLengths = new int[] { 0, 31, -1, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (isLeapYear(year)) {
			monthLengths[2] = 29;
		} else {
			monthLengths[2] = 28;
		}

		int monthLength = monthLengths[month];
		if (day < 1 || day > monthLength) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * 方法用途: 是否是闰年 <br>
	 * 操作步骤: TODO<br>
	 * @param year
	 * @return
	 */
	private static boolean isLeapYear(int year) {
		return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);

//		return ((year % 4 == 0 && year % 100 != 0) || ((year % 4 == 0) &&year % 400 == 0)); //bug修复，不是这个算法

//		if ((year % 4) == 0 && (year % 100 != 0))
//			return true;
//		else if ((year % 4 == 0) && (year % 400 == 0))
//			return true;
//		return false;
	}
	/**
	 * 
	 * 方法用途: 结束时间（end）与start时间进行比较<br>
	 * 操作步骤: 如果相等返回0，如果end大于start返回1，如果end小于start返回-1<br>
	 * @param start
	 * @param end
	 * @return
	 * @throws Exception
	 */
	public static int compareEndAndStart(String start, String end) throws Exception {
		long s = 0;
		if (8 == start.length()) {
			s = dateFormatDB.parse(start).getTime();
		} else if (10 == start.length()) {
			s = dateFormat.parse(start).getTime();
		} else {
			s = dataTimeFormat.parse(start).getTime();
		}
		long e = 0;
		if (8 == end.length()) {
			e = dateFormatDB.parse(end).getTime();
		} else if (10 == end.length()) {
			e = dateFormat.parse(end).getTime();
		} else {
			e = dataTimeFormat.parse(end).getTime();
		}
		if (e > s) {
			return 1;
		} else if (e < s) {
			return -1;
		}
		return 0;
	}

	
	
	/**
	 * 获取8位随机数
	 * @return
	 */
	public static String getRandomNum(){
		Random r=new Random();
		int a = r.nextInt(99999999);
		String	cardNum = ""+a;
		int length = cardNum.length();
		if(length<8){
			for(int j=0; j<(8-length); j++){
				cardNum = "0"+cardNum;
			}
		}
		return cardNum;
	}
	
	/**
	 * 将日期类型转换为 long 
	 * */
	public static long strToDateLong(Date date){
		  long time=date.getTime();
		   return time ;
		 }
	

	/**
	 * 将long类型时间转换成Date类型
	 * @param time        long 类型时间
	 * @param dateFormat  Date时间格式
	 * @return  Date时间
	 */
	public static Date longToDate(long time, String dateFormat){
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date= new Date(time);
		try {
			String dateTime = sdf.format(date);
			date = sdf.parse(dateTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return date; 
	}
	/**
	 * 获取当前日期 格式: yyyy-M-d
	 * 
	 * @return
	 */
	public static String getDate() {
		Date date = new Date();
		String formater = "yyyy-M-d"; // yyyy-M-d
		SimpleDateFormat format = new SimpleDateFormat(formater);
		return format.format(date);
	}

	
	

	/**
	 * 格式化指定日期 格式:参数 例如 yyyy-MM-dd
	 * 
	 * @param date
	 * @param formatStr
	 * @return
	 */
	public static String getDate(Date date, String formatStr) {
		SimpleDateFormat format = new SimpleDateFormat(StringUtils.notNull(formatStr, "yyyy-MM-dd HH:mm:ss"));// yyyy-MM-dd
		// HH:mm:ss
		return date == null ? "" : format.format(date);
	}

	

	/**
	 * 格式化时间 格式: yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return String
	 */
	public static String formatDate(String date) {
		String formater = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		return date == null ? null : format.format(getDateTime(date));
	}

	/**
	 * 格式化时间 格式:第2参数 例如 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @param formatStr
	 * @return String
	 */
	public static String formatDate(String date, String formatStr) {
		String formater = formatStr;
		SimpleDateFormat format = new SimpleDateFormat(formater);
		return date == null ? null : format.format(getDateTime(date));
	}

	/**
	 * 取得某一特定的日期
	 * 
	 * @param sDate
	 * @param iDay
	 * @param sformat
	 * @return
	 */
	public static String getSomeDate(String sDate, int iDay, String sformat) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(sformat);
			format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
			Date date = format.parse(sDate);
			long Time = (date.getTime() / 1000) + 60 * 60 * 24 * iDay;
			date.setTime(Time * 1000);
			return format.format(date);
		} catch ( Exception ex ) {
			return "";
		}
	}

	/**
	 * 时间间隔 是否在当前时间范围
	 * 
	 * @param btime
	 * @param etime
	 * @return
	 */
	public static boolean dateBound(String btime, String etime) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date sd = formatter.parse(btime, new ParsePosition(0));
		Date ed = formatter.parse(etime, new ParsePosition(0));
		return dateBound(sd, ed);
	}

	public static boolean dateBound(Date sd, Date ed) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date td = formatter.parse(getDate(), new ParsePosition(0)); // 当前时间
		if (sd == null || ed == null || td == null) return false;
		if (sd.getTime() > td.getTime() || ed.getTime() < td.getTime()) return false;
		return true;
	}
	
	/**
	 * 显示当前时间与目标时间的距离
	 * 
	 * **秒前  ** 分钟前  ** 小时前 超过7天显示时间
	 * @param ctime
	 * @param format
	 * @return
	 */
	public static String distance(Date ctime, String format) {
		if (ctime == null) return "";
		format = StringUtils.notNull(format, "yyyy-MM-dd HH:mm");
		long result = Math.abs(System.currentTimeMillis() - ctime.getTime());
		if (result < 60000) {
			return (result / 1000) + "秒钟前";
		} else if (result >= 60000 && result < 3600000) {
			return (result / 60000) + "分钟前";
		} else if (result >= 3600000 && result < 86400000) {
			return (result / 3600000) + "小时前";
		} else if (result >= 86400000 && result < 86400000 * 7) {
			return (result / 86400000) + "天前";
		} else {
			return getDate(ctime, format);
		}
	}
	
	//-----------------------1--------------------------



	/**
	 * 获取可距离某段时间内月份字符串的方法：getAvailableMonth() 使用说明： getAvailableMonth( -1,-5) 如果当前是200205的话，那么返回的月份就是200101到200204，包括当前月份 getAvailableMonth( 3,7)
	 * 如果当前是200202的话，那么返回的月份就是200205到200209，包括当前月份 注意，开始月份永远是靠近当前月份的。
	 * 
	 * @param begin
	 *            开始月份(距离当前月份)
	 * @param end
	 *            结束月份(距离当前月份)
	 * @return string[] 月份数组，格式为200011
	 */
	public static String[] getAvailableMonth(int begin, int end) {
		// 需取得月份的个数
		int numberOfMonth = end - begin;
		// 月份数的绝对值
		int index = Math.abs(numberOfMonth) + 1;
		// 返回的月份数组
		String[] strMonth = new String[index];
		// 回滚年数
		int roll = (end > begin) ? (begin - 1) : (end - 1);
		try {
			for (int i = 1; i <= index; i++) {
				// 依次回滚，计算当前回滚后的月份
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.MONTH, roll + i);
				Date now = calendar.getTime();
				// 月份格式YYYYMM
				strMonth[i - 1] = getDateString(now, "yyyyMM");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strMonth;
	}

	/**
	 * 根据日期获取年月日的字符串，格式为yyyy-MM-dd
	 * 
	 * @param date
	 * @return 年月日的字符串
	 */
	public static String getDateStr(Date date) {
		return dateFormat.format(date);
	}

	/**
	 * 获得格式为yyyy-MM-dd的格式化日期为字符串
	 * 
	 * @param date
	 *            被格式化日期
	 * @param formatPattern
	 *            格式化格式
	 * @return String 格式化后的日期字符串
	 */
	public static String getDateString(Date date) {
		return getDateString(date, null);
	}

	/**
	 * 根据参数格式化日期为字符串，默认格式为yyyy-MM-dd
	 * 
	 * @param date
	 *            被格式化日期
	 * @param formatPattern
	 *            格式化格式
	 * @return String 格式化后的日期字符串
	 */
	public static String getDateString(Date date, String formatPattern) {
		if (date == null) {
			return "";
		}
		if ((formatPattern == null) || formatPattern.equals("")) {
			formatPattern = "yyyy-MM-dd";
		}
		sdf.applyPattern(formatPattern);
		return sdf.format(date);
	}

	/**
	 * 获取格式为yyyy-MM-dd hh:mm:ss的格式化日期时间为字符串
	 * 
	 * @param date
	 *            被格式化日期
	 * @return String 格式化后的日期字符串
	 */
	public static String getDateTimeString(Date date) {
		return getDateTimeString(date, null);
	}

	/**
	 * 根据参数格式化日期时间为字符串，默认格式为yyyy-MM-dd hh:mm:ss
	 * 
	 * @param date
	 *            被格式化日期
	 * @param formatPattern
	 *            格式化格式
	 * @return String 格式化后的日期字符串
	 */
	public static String getDateTimeString(Date date, String formatPattern) {
		if (date == null) {
			return "";
		}
		if ((formatPattern == null) || formatPattern.equals("")) {
			formatPattern = "yyyy-MM-dd HH:mm:ss";
		}
		sdf.applyPattern(formatPattern);
		return sdf.format(date);
	}

	/**
	 * 根据指定日期，获得指定天数差别的日期
	 * 
	 * @param strDate
	 *            参照日期
	 * @param days
	 *            差别的天数，正数－获得以后的日期，负数－获得以前的日期
	 * @return 获得的日期
	 */
	public static Date getDistDate(Date date, int days) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, days);
			return cal.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Date();

	}

	/**
	 * 根据指定日期，获得指定天数差别的日期
	 * 
	 * @param strDate
	 *            代表参照日期的字符串
	 * @param days
	 *            差别的天数，正数－获得以后的日期，负数－获得以前的日期
	 * @return 获得的日期
	 */
	public static Date getDistDate(String strDate, int days) {
		try {
			Date date = dateFormat.parse(strDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, days);
			return cal.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date();
	}

	/**
	 * 获得下一天的日期对象（Date）
	 * 
	 * @param strDate
	 *            参照日期
	 * @return 获得的日期
	 */
	public static Date getNextDate(Date date) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, 1);
			return cal.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Date();

	}

	/**
	 * 获得下一天的日期对象（Date）
	 * 
	 * @param strDate
	 *            代表参照日期的字符串，格式：yyyy-MM-dd
	 * @return 获得的日期
	 */
	public static Date getNextDate(String strDate) {
		try {
			Date date = dateFormat.parse(strDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, 1);
			return cal.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date();
	}

	/**
	 * 获得下一天的日期字符串（String）
	 * 
	 * @param strDate
	 *            参照日期的
	 * @return 下一天的字符串
	 */
	public static String getNextDayString(Date date) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, 1);
			return dateFormat.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateFormat.format(new Date());
	}

	/**
	 * 获得下一天的日期字符串,格式为yyyy-MM-dd
	 * 
	 * @param strDate
	 *            代表参照日期的字符串，格式：yyyy-MM-dd
	 * @return 下一天的字符串
	 */
	public static String getNextDayString(String strDate) {
		try {
			Date date = dateFormat.parse(strDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, 1);
			return dateFormat.format(cal.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateFormat.format(new Date());
	}


	

	/**
	 * <p>
	 * 定格式获取时间，时间格式为{u}n，其中u为时间单位，n为多少个时间单位
	 * </p>
	 * 比如{h}3表示3天，{y}1表示一年
	 * 
	 * @param timestr
	 *            时间格式字符串
	 * @return long 相应时间
	 * @throws Exception
	 */
	public static long getTime(String timestr) throws Exception {
		// 格式分析
		int begin = timestr.indexOf("{");
		int end = timestr.indexOf("}");
		String timeUnit = timestr.substring(begin + 1, end);
		int time = DataUtil.parseInt(timestr.substring(end + 1));

		return getTimeByUnit(timeUnit) * time;
	}

	/**
	 * <p>
	 * 根据时间单位获取相应时间的毫秒刻度
	 * </p>
	 * 时间单位的含义为：h表示小时，d表示天，w表示周，M表示月，y表示年，m表示分，s表示秒
	 * 
	 * @param unit
	 *            字符串形式的时间单位
	 * @return long 相应时间毫秒刻度
	 */
	public static long getTimeByUnit(String unit) throws Exception {
		switch (unit.charAt(0)) {
		case 'h':
			return HOUR;
		case 'd':
			return DAY;
		case 'w':
			return WEEK;
		case 'm':
			return MINUTE;
		case 'n':
			return MONTH;
		case 'y':
			return YEAR;
		case 's':
			return SECOND;
		default:
			throw new IllegalArgumentException("unknown time unit");
		}
	}

	/**
	 * 
	 * @param nowdate
	 * @return
	 */
	public static Date getYesterdayDate(Date nowdate) {
		return new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
		/*
		 * int year = nowdate.getYear(); int month = nowdate.getMonth(); int date = nowdate.getDate(); if (((date - 1) <= 0)) { if (month > 0) { month
		 * = month - 1; if (month == 0 || month == 2 || month == 4 || month == 6 || month == 7 || month == 9 || month == 11) { date = 31; } else if
		 * (month == 1) { if (isLeapYear(year + 1900)) date = 29; else date = 28; } else date = 30;
		 * 
		 * } else { year = year - 1; month = 11; date = 31; } } else date = date - 1; Date yesterdayDate = new Date(year, month, date); return
		 * yesterdayDate;
		 */
	}

    //---------------------------------//
	

	public static Date getStartTime(Calendar calendar) {
        Calendar c = (Calendar) calendar.clone();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    public static Date getEndTime(Calendar calendar) {
        Calendar c = (Calendar) calendar.clone();
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }

    public static long intervalTimeOfSecond(String start,String end){
        long interval = 0;
        try {
            Date sDate = StringToDate(start,"yyyy-MM-dd hh:mm:ss");
            Calendar sCalendar = Calendar.getInstance();
            sCalendar.setTime(sDate);
            Date eDate = StringToDate(end,"yyyy-MM-dd hh:mm:ss");
            Calendar eCalendar = Calendar.getInstance();
            eCalendar.setTime(eDate);
            if(eCalendar.getTimeInMillis() - sCalendar.getTimeInMillis()>0) {interval = (eCalendar.getTimeInMillis() - sCalendar.getTimeInMillis())/1000;}else {return 0;}
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return interval;
    }

    public static boolean isSameMonth(Date d1, Date d2) {
        if (d1 == null || d2 == null) return false;

        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);
        return isSameMonth(c1, c2);
    }

    public static boolean isSameMonth(Calendar c1, Calendar c2) {
        return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH);
    }

    //--------------------------//


    //返回一个月的第一天
    public static Calendar getFirstDateOfMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c;
    }


    //返回一个月的最后一天
    public static Calendar getLastDateOfMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        int maxDate = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        c.set(Calendar.DAY_OF_MONTH, maxDate);
        return c;
    }

    /**
     *   获取几天是周几 周日为一周的第一天
     */
    public static int getTodayOfWeek(){
        Date  nowTime = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(nowTime);
        return c.get(Calendar.DAY_OF_WEEK);
    }


    /**
     * 取得当前日期所在周的第一天
     */
    public static Calendar getFirstDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {             //特殊处理星期天是第一天的情况！按中国人习惯把周1看成第一天，星期天看成最后一天
            c.add(Calendar.DAY_OF_WEEK, -1);
        }
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // Sunday
        return c;
    }

    //获取当前日期的第二天
    public static Calendar getTomorrow(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, 1);
        return c;
    }

    


   

    public static Date getCurrentDateTime(){
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    public static String getDateStr(Date date, String format) {
        if(date==null)
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String str = sdf.format(date);
        return str;
    }

    public static Timestamp getCurrentTimestamp(){
		Calendar cal=Calendar.getInstance();
		return new Timestamp(cal.getTimeInMillis());
	}
    public static String getCurrentDateTimeStr(){
    	Calendar calendar = Calendar.getInstance();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str = sdf.format(calendar.getTime());
        return str;
    }
    
   //-------------------//
    
	
	
	
	
	
	/**
	 * getWeekTime
	 * @param flag: 0 本周 1下周 n下n周
	 * @return
	 */
	public static Date getWeekTime(int flag){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.WEEK_OF_YEAR, flag);
		calendar.set(Calendar.MILLISECOND,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
		return new Date(calendar.getTimeInMillis());
	}
	
	/**
	 * 返回当前是一周的第几天，周日为第一天
	 * @return
	 */
//	public static int getDayOfWeek(){
//		Calendar calendar = Calendar.getInstance();
//		int dayOfWeek =  calendar.get(Calendar.DAY_OF_WEEK);
//		if (dayOfWeek==1) {
//			return 7;
//		}
//		else return dayOfWeek-1;
//	}
	/**
	 * 返回当前是一周的第几天，周日为第一天
	 * @return
	 */
	public static int getDayOfWeek(){
		GregorianCalendar gc = new GregorianCalendar();
		return gc.get(GregorianCalendar.DAY_OF_WEEK);
	}
	
	public static boolean withinPeriod(long bTime,long eTime){	
		return withinPeriod(System.currentTimeMillis(), bTime, eTime);
	}
	
	public static boolean withinPeriod(long nowTime, long bTime,long eTime){	
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		long beginTime = calendar.getTimeInMillis() + bTime;
		long endTime = calendar.getTimeInMillis() + eTime;
		if (nowTime >= beginTime && nowTime <= endTime) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String format(long time, String format) {
		if (format == null) {
			format = "MM-dd HH:mm:ss";
		}
		SimpleDateFormat f = new SimpleDateFormat(format);
		return f.format(new Date(time)).toString();
	}
	
	public static String format(long time) {		
		return format(time,null);
	}
	
	public static String format2(long time) {
		return format(time, "MM月dd日 HH:mm:ss");
	}
	
	/**
	 * 获得当天零时零分零秒 的毫秒数
	 * 
	 * @return long
	 */
	public static long getDailyTime(){
		Calendar cal = Calendar.getInstance();       
		cal.set(Calendar.HOUR_OF_DAY, 0);       
		cal.set(Calendar.SECOND, 0);    
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);	
		return cal.getTimeInMillis();
	}
	
	/**
	 * 获得当时零分零秒 的毫秒数
	 * 
	 * @return long
	 */
	public static long getHourlyTime(long time) {
		return getHourlyTime(time, 0);
	}
	
	/**
	 * 获得当前时间的 小时的数值
	 * @return int
	 */
	public static int getHour(long time){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
	/**
	 * 获得当前时间的 分钟数
	 * @return int
	 */
	public static int getMinute(long time){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		return calendar.get(Calendar.MINUTE);
	}
	/**
	 * 获得当前时间是这个月的几号
	 * @return int
	 */
	public static int getDayOfMonth(long time){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	/**
	 * 获得当前时间是周几？ SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, and SATURDAY
	 * @return int
	 */
	public static int getDayOfWeek(long time){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	/**
	 * 获得此刻前N个或后N个小时零分零秒 的毫秒数
	 * 
	 * @return long
	 */
	public static long getHourlyTime(long time, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		int hour = calendar.get(Calendar.HOUR_OF_DAY) + n;
		calendar.set(Calendar.HOUR_OF_DAY,  hour);

		return calendar.getTimeInMillis();
	}
	
	public static long getDailyTime(long time, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		int day = calendar.get(Calendar.DAY_OF_MONTH) + n;
		calendar.set(Calendar.DAY_OF_MONTH,  day);

		return calendar.getTimeInMillis();
	}
	
	public static long getDailyTime(long time){
		return getDailyTime(time,0);
	}
	
	/* 格式化时间，从毫秒-> hh:mm:ss*/
	public static String formatTime(long time){
		if ( time <= 0) {
			return  "0:0:0";
		}
		time = time / 1000;
	    int h = (int)Math.floor(time / 3600);
	    int m = (int)Math.floor((time - h * 3600) / 60);
	    int s = (int)time - h*3600 - m*60 ;
	    String fmt = h + ":" + m + ":" + s; 
	    return fmt;
	}
	
	/**
	 * 判断日期是否在今天之前
	 * @param endTime
	 * @return 
	 */
	public static boolean isBeforeToday(long endTime){
		return endTime < getDailyTime(System.currentTimeMillis(),0);
	}
	
	/**
	 * 判断是否是0时0分0秒
	 * @param time
	 * @return
	 */
	public static boolean isDailyTime(long time){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		return calendar.get(Calendar.HOUR)==0 && calendar.get(Calendar.MINUTE)==0 && calendar.get(Calendar.SECOND)==0;
	}
	
	/**
	 * 判断是否在同一天
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static boolean isInOneDay(long beginTime,long endTime){
		return   endTime == beginTime;
	}
	
	/**
	 * 判断是否是今天
	 * @return
	 */
	public static boolean isToday(long beginTime,long endTime){
		return isTodayBegin(beginTime) && isTodayEnd(endTime);
	}
	
	/**
	 * 判断是否为一天开始时间
	 * @param beginCa
	 * @return
	 */
	public static boolean isTodayBegin(long time) {
		return time == getDailyTime();
	}

	/**
	 * 判断是否为一天结束时间
	 * @param endCa
	 * @return
	 */
	public static boolean isTodayEnd(long time) {
		return time == getDailyTime();//getDailyTime(System.currentTimeMillis(),1);
	}
	
	/**
	 * 获得当日0时0分0秒
	 * @param time
	 * @return Calendar
	 */
	public static Calendar getAdjustedCalendar(long time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}
	
	/**
	 * 计算总共经历了多少天.如1.1-1.2结果为2天.
	 * @author shiyue[jianpingcao@sohu-inc.com][2012-2-7]
	 * @param fDate
	 * @param eDate
	 * @return
	 */
	public static long getDisDays(Date fDate, Date eDate){
		Calendar fc = Calendar.getInstance();
		fc.setTime(fDate);
		fc.set(Calendar.HOUR_OF_DAY, 0);
		fc.set(Calendar.MINUTE, 0);
		fc.set(Calendar.SECOND, 0);
		fc.set(Calendar.MILLISECOND, 0);
		//System.out.println(fc.getTime());
		
		Calendar ec = Calendar.getInstance();
		ec.setTime(eDate);
		ec.set(Calendar.HOUR_OF_DAY, 0);
		ec.set(Calendar.MINUTE, 0);
		ec.set(Calendar.SECOND, 0);
		ec.set(Calendar.MILLISECOND, 0);
		//System.out.println(ec.getTime());
		
		long days = (ec.getTimeInMillis() - fc.getTimeInMillis())/(24 * 60 * 60 * 1000);
		return days < 0 ? -1 : days + 1;
	}
	
	

	
	//---------------------------------
	/**
	 * 
	 * 将给定时间 增加 到指定的 年月日，返回增加后的 字符串
	 *
	 * @param endTime 默认时间格式为 yyyy-MM-dd
	 * @param year 年数,如果设置值大于0，则增加。如果设置值小于0，则减
	 * @param month 月数,如果设置值大于0，则增加。如果设置值小于0，则减
	 * @param day 日数,如果设置值大于0，则增加。如果设置值小于0，则减
	 * @return    
	 * @throws Exception 
	 * @throws
	 */
	public static String addTime(String endTime,String formater,int year,int month,int day) throws Exception{
		formater = StringUtils.isEmpty(formater) ? "yyyy-MM-dd" : formater;
		if(!StringUtils.isEmpty(endTime)){
			SimpleDateFormat sdf = new SimpleDateFormat(formater);
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(endTime));
			if(0 != year){
				c.add(Calendar.YEAR, year);
			}
			if(0 != month){
				c.add(Calendar.MONTH, month);
			}
			if(0 != day){
				c.add(Calendar.DAY_OF_MONTH, day);
			}
			return sdf.format(c.getTime());
		}else{
			throw new Exception("日期格式不正确");
		}
	}
	

	/**
	 * 比较一个日期字符串是否在指定 日期区间
	 * 
	 * @param currTime
	 *            当前时间
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return
	 */
	private static boolean equalsTime(String currTime, String startTime,
			String endTime,String formater) {
		boolean flag = false;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formater);

			// 将 字符串时间 转换为 日期 类型
			Date currTimeDate = sdf.parse(currTime);
			Date startTimeDate = sdf.parse(startTime);
			Date endTimeDate = sdf.parse(endTime);
			// 如果当前时间 大于 指定时间，将返回大于 0 的数，小于则返回小于 0 的数，等于则返回 0
			int startFlag = currTimeDate.compareTo(startTimeDate);
			int endFlag = currTimeDate.compareTo(endTimeDate);

			// 第一种情况,与 起始时间 或者 结束时间相等
			// 第二种情况 在 两者之间
			if ((0 == startFlag || 0 == endFlag)
					|| (0 < startFlag && 0 > endFlag)) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 
	 * 获取系统日期，默认格式  yyyy-MM-dd
	 *
	 * @return    
	 * @throws
	 */
	public static String sysdate(){
		return sysdate("yyyy-MM-dd");
	}
	
	/**
	 * 获取系统日期
	 * @param formater
	 * @return
	 */
	public static String sysdate(String formater){
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(formater);
		return sdf.format(c.getTime());
	}
	
	/**
	 * 获取当月的第一天，并格式化
	 * @param dateTime
	 * @param formater
	 * @return
	 */
	public static String firstDayOfMonth(String dateTime,String formater){
		String result = "";
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(formater);
			Date date = sdf.parse(dateTime);
			date.setDate(1);
			result = sdf.format(date);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 获取当月的最后一天
	 *
	 * @param datetime
	 * @param formater
	 * @return    
	 * @throws
	 */
	 public static String lastDayOfMonth(String datetime,String formater) {
		 try
		 {
			SimpleDateFormat sdf = new SimpleDateFormat(formater);
			Date date = sdf.parse(datetime);
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	        cal.set(Calendar.DAY_OF_MONTH, value);
	        datetime = sdf.format(cal.getTime());
	      }catch(Exception e){
	    	  e.printStackTrace();
	      }
	        return datetime;
	    }
	 
	 /**
		 * 返回格式化的当前日期，格式为yyyy-MM-dd
		 * 
		 * @return
		 */
		public static String getFullDate() {
			String formater = "yyyy-MM-dd";
			SimpleDateFormat format = new SimpleDateFormat(formater);
			format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
			Date myDate = new Date();
			return format.format(myDate);
		}

		/**
		 * 返回格式化的当前日期，格式为yyyy-M-d
		 * 
		 * @return
		 */
		public static String getSimpleDate() {
			String formater = "yyyy-M-d";
			SimpleDateFormat format = new SimpleDateFormat(formater);
			format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
			Date myDate = new Date();
			return format.format(myDate);
		}

		/**
		 * 返回本周的区间的格式化的日期对，格式为yyyy-MM-dd HH:mm:ss
		 * 
		 * @return
		 */
		public static String[] getSimpleDateRangeOfWeek() {
			String today = getFullDate();
			int endWeekDay = getWeekDay(today);
			// 以取出的第一个时间为准，向前推算第一个星期一的时间
			String startDate = getSomeDate(today + " 00:00:00",
					-(endWeekDay - 1), "yyyy-MM-dd");
			String endDate = getSomeDate(startDate, 6, "yyyy-MM-dd")
					.substring(0, 10)
					+ " 24:00:00";
			String DateRang[] = new String[2];
			DateRang[0] = startDate;
			DateRang[1] = endDate;
			return DateRang;
		}

		

		/**
		 * 计算两个日期间的天数差
		 * @param sDate1
		 * @param sDate2
		 * @param formter
		 * @return
		 * @exception return 0
		 */
		public static long getDaysFrom2Dates(String sDate1, String sDate2, String formter) {
			try {
				SimpleDateFormat format = new SimpleDateFormat(formter);
				Date date = format.parse(sDate1);
				Date date1 = format.parse(sDate2);
				return (date.getTime()-date1.getTime())/(1000*60*60*24);
			} catch (Exception ex) {
				System.out.println("Error in TimeUtil.getDaysFrom2Dates,"+ex.toString());
				return 0L;
			}
		}
		
		/**
		 * 返回格式化的间隔iDay天的时间
		 * 
		 * @param sDate
		 *            时间
		 * @param iDay
		 *            间隔天数
		 * @param formter
		 *            时间格式："yyyy-MM-dd HH:mm:ss"或"yyyy-M-d H:m:s"
		 * @return
		 */
		public static String getSomeTime(String sDate, int iDay, String formter) {
			try {
				SimpleDateFormat format = new SimpleDateFormat(formter);
				Date date = format.parse(sDate);
				long Time = (date.getTime() / 1000) + 60 * 60 * 24 * iDay;
				date.setTime(Time * 1000);
				return format.format(date);
			} catch (Exception ex) {
				return "";
			}
		}

		/**
		 * 求得某天是一周的第几天，以周一为第1天记起
		 * 
		 * @param strDate
		 * @return
		 */
		public static int getWeekDay(String strDate) {
			int strWeekDay = 0;
			SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
			Date mydate = null;
			Calendar cal = Calendar.getInstance();
			try {
				mydate = myFormatter.parse(strDate);
				cal.setTime(mydate);
				strWeekDay = cal.get(Calendar.DAY_OF_WEEK);
				if (strWeekDay == 1)
					strWeekDay = 7;
				else
					strWeekDay = strWeekDay - 1;
			} catch (ParseException e) {
				System.out.println("Error in TimeUtil.getWeekDay()"
						+ e.getMessage());
			}
			return strWeekDay;
		}

		/**
		 * 判断第一个参数日期是否晚于第二个参数日期
		 * 
		 * @param sDate1
		 * @param sDate2
		 * @return
		 */
		public static boolean isDateLater(String sDate1, String sDate2) {
			try {
				SimpleDateFormat format = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				Date date1 = format.parse(sDate1);
				Date date2 = format.parse(sDate2);
				if (date1.after(date2))
					return true;
				else
					return false;
			} catch (Exception ex) {
				return false;
			}
		}

		/**
		 * 根据年和月计算出所给的月份最后一天
		 * @param year 年
		 * @param month 月
		 * @return
		 */
		public static int getEndday(int year,int month){
			int endDay=0;
			if(month<1||month>12||year<1753||year>9999)
				return 0;
			switch(month){
				case 4:
					endDay = 30;
					break;
				case 6:
					endDay = 30;
					break;
				case 9:
					endDay = 30;
					break;
				case 11:
					endDay = 30;
					break;
				case 2:
					if (year % 4 == 0)
						endDay = 29;
					else
						endDay = 28;
					break;
				default:
					endDay = 31;
					break;
			}
			return endDay;
		}
		
		/**
		 * 判断是否为合法日期
		 * @param sDate 日期
		 * @param sFormat 格式
		 * @return
		 */
		public static boolean isDate(String sDate, String sFormat) {
			if (sDate == null)
				return false;
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat(sFormat);
				dateFormat.setLenient(false);
				dateFormat.parse(sDate);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
		/**
		 * 当前年份
		 * @return
		 */
		public static int getYear(){
			GregorianCalendar gc = new GregorianCalendar();
			return gc.get(GregorianCalendar.YEAR);
		}
		
		/**
		 * 当前月份
		 * @return
		 */
		public static int getMonth(){
			GregorianCalendar gc = new GregorianCalendar();
			return gc.get(GregorianCalendar.MONTH)+1;
		}
		
		/**
		 * 当前日
		 * @return
		 */
		public static int getDayOfMonth(){
			GregorianCalendar gc = new GregorianCalendar();
			return gc.get(GregorianCalendar.DAY_OF_MONTH);
		}

		

		
		/**
		 * 格式化日期
		 * 
		 * @param date
		 * @return
		 */
		public static String formatDate(Date date, String formater) {
			try
			{
				SimpleDateFormat format = new SimpleDateFormat(formater);
				return format.format(date);
			}catch(Exception e){
				System.out.println("Format error :" + e.getMessage());
				return "";
			}
		}

		/**
		 * 返回格式化的当前时间，格式为yyyy-MM-dd HH:mm:ss
		 * 
		 * @return
		 */
		public static String getCurDateTime() {
			String formater = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat format = new SimpleDateFormat(formater);
			Date myDate = new Date();
			return format.format(myDate);
		}

		/**
		 * 返回上个月1号和本月1号的格式化的日期对
		 * 
		 * @param formater
		 *            日期格式："yyyy-M-d"或"yyyy-MM-dd"
		 * @return
		 */
		public static String[] getDatesRangeOfLastMonth(String formater) {
			String DateRang[] = new String[2];
			SimpleDateFormat format = new SimpleDateFormat(formater);
			Date myDate = new Date();
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(myDate);
			calendar.set(calendar.get(GregorianCalendar.YEAR), calendar
					.get(GregorianCalendar.MONTH), 1);
			Date cDate = calendar.getTime();
			DateRang[1] = format.format(cDate);
			calendar.add(GregorianCalendar.MONTH, -1);
			cDate = calendar.getTime();
			DateRang[0] = format.format(cDate);
			return DateRang;
		}

		/**
		 * 返回startDate之后numberOfDays天的日期
		 * 
		 * @param startDate
		 * @param numberOfDays
		 * @return exception: return ""
		 */
		public static String getEndDate(java.sql.Date startDate, int numberOfDays) {
			try {
				GregorianCalendar calendar = new GregorianCalendar();
				calendar.setTime(startDate);
				calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
				Date endDate = calendar.getTime();
				return endDate.toString();
			} catch (Exception e) {
				System.out.println("Error:TimeUtil.getEndDate()," + e.getMessage());
				return "";
			}
		}

		public static Date parseDateTime(String endTime) {
			return parse(endTime,"yyyy-MM-dd HH:mm:ss");
		}
}

