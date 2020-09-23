package com.lfs.base.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lfs.base.exception.BusinessException;
/**
 * <p><b>Title:</b><i>字符串工具</i></p>
 * <p>Desc: 字符串工具</p>
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils{

	 private static AtomicInteger num = new AtomicInteger(0);
	 private final static int MAXNUM = 9999;
	 private static final Logger LOG = LoggerFactory.getLogger(StringUtils.class);

	/** 下划线 */
	private static final char SEPARATOR = '_';
	 
	 public static final String ALL_INTERFACES="0.0.0.0";
	 public static final String CRLF="\015\012";
	 public static final String __LINE_SEPARATOR=
	     System.getProperty("line.separator","\n");
	    
	 public static final String __ISO_8859_1="ISO-8859-1";
	 public final static String __UTF8="UTF-8";
	 public final static String __UTF8Alt="UTF8";
	 public final static String __UTF16="UTF-16";
	 
	 public final static Charset __UTF8_CHARSET;
	 public final static Charset __ISO_8859_1_CHARSET;
	 
	 static
	 {
	     __UTF8_CHARSET=Charset.forName(__UTF8);
	     __ISO_8859_1_CHARSET=Charset.forName(__ISO_8859_1);
	 }
	 
	 private static char[] lowercases = {
	       '\000','\001','\002','\003','\004','\005','\006','\007',
	       '\010','\011','\012','\013','\014','\015','\016','\017',
	       '\020','\021','\022','\023','\024','\025','\026','\027',
	       '\030','\031','\032','\033','\034','\035','\036','\037',
	       '\040','\041','\042','\043','\044','\045','\046','\047',
	       '\050','\051','\052','\053','\054','\055','\056','\057',
	       '\060','\061','\062','\063','\064','\065','\066','\067',
	       '\070','\071','\072','\073','\074','\075','\076','\077',
	       '\100','\141','\142','\143','\144','\145','\146','\147',
	       '\150','\151','\152','\153','\154','\155','\156','\157',
	       '\160','\161','\162','\163','\164','\165','\166','\167',
	       '\170','\171','\172','\133','\134','\135','\136','\137',
	       '\140','\141','\142','\143','\144','\145','\146','\147',
	       '\150','\151','\152','\153','\154','\155','\156','\157',
	       '\160','\161','\162','\163','\164','\165','\166','\167',
	       '\170','\171','\172','\173','\174','\175','\176','\177' };
	 
	 
	 
	 public static final List<Character> HEX_CHAR_LIST;
		static {
			HEX_CHAR_LIST = new ArrayList<Character>();
			HEX_CHAR_LIST.add(new Character('0'));
			HEX_CHAR_LIST.add(new Character('1'));
			HEX_CHAR_LIST.add(new Character('2'));
			HEX_CHAR_LIST.add(new Character('3'));
			HEX_CHAR_LIST.add(new Character('4'));
			HEX_CHAR_LIST.add(new Character('5'));
			HEX_CHAR_LIST.add(new Character('6'));
			HEX_CHAR_LIST.add(new Character('7'));
			HEX_CHAR_LIST.add(new Character('8'));
			HEX_CHAR_LIST.add(new Character('9'));
			HEX_CHAR_LIST.add(new Character('a'));
			HEX_CHAR_LIST.add(new Character('b'));
			HEX_CHAR_LIST.add(new Character('c'));
			HEX_CHAR_LIST.add(new Character('d'));
			HEX_CHAR_LIST.add(new Character('e'));
			HEX_CHAR_LIST.add(new Character('f'));
		}
		
		
		
		public static String articleCut(String info, int len, String postfix) {
			if (isEmpty(info))
				return info;
			info = StringUtils.removeHtml(info);
			if (isEmpty(info))
				return info;
			if (info.length() > len) {
				return info.substring(0, len) + postfix;
			}
			return info;
		}
		
	/**
	 * 
	 * 方法用途: 不定长参数,其中一个参数为null或空则返回true,负责返回false<br>
	 * 操作步骤: TODO<br>
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(String... str) {
		for (String s : str) {
//			if (isNull(s) || notNull(s).trim().length() < 1) { //TODO 可选用法
			if (StringUtils.isEmpty(s)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * 方法用途: 不定长参数,其中一个参数为null或空则返回true,负责返回false<br>
	 * 操作步骤: TODO 这个方法需要重构<br>
	 * @param str
	 * @return boolean
	 */
	@Deprecated
	public static boolean isEmpty(Integer... str) {
		for (Integer s : str) {
			if (StringUtils.isEmpty(s)) {
				return true;
			}
		}
		return false;
	}
	
	public static int length(String str) {
		try {
			return str.getBytes("GBK").length;
		} catch (UnsupportedEncodingException e) {
			return str.length();
		}
	}

	/**
	 * 方法用途：不定长参数,其中一个参数为null或空或为空格字符串则返回true,负责返回false
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isBlank(String... str) {
		for (String s : str) {
			if (StringUtils.isBlank(s))
				return true;
		}
		return false;
	}

	/**
	 * 方法用途：判断字符串是否是数值. 默认允许有正负号,默认允许有小数点
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		boolean sign = true;
		int point_bef = Integer.MAX_VALUE;// 小数点前有几位
		int point_aft = Integer.MAX_VALUE;// 小数点后有几位
		return isNumeric(str, sign, point_bef, point_aft);
	}

	/**
	 *方法用途：判断字符串是否是数值
	 * 
	 * @param str
	 * @param sign
	 *          是否允许有正负号
	 * @param point
	 *          是否允许有小数点
	 * @return
	 */
	public static boolean isNumeric(String str, boolean sign, boolean point) {
		int point_bef = Integer.MAX_VALUE;// 小数点前有几位
		int point_aft = Integer.MAX_VALUE;// 小数点后有几位
		if (!point)
			point_aft = 0;

		return isNumeric(str, sign, point_bef, point_aft);
	}

	/**
	 *方法用途：判断字符串是否是数值
	 * 
	 * @param str
	 * @param sign
	 *          是否允许有正负号
	 * @param point_bef
	 *          精度,小数点前有几位
	 * @param point_aft
	 *          精度,小数点后有几位,如果为0,则为整数
	 * 
	 * @return
	 */
	public static boolean isNumeric(String str, boolean sign, int point_bef, int point_aft) {
		if (StringUtils.isBlank(str)) {
			return false;
		}
		boolean point = true;// 是否允许小数点
		if (point_aft == 0) {
			point = false;// 不允许有小数点
		} else {
			point = true;
		}
		StringBuffer pat = new StringBuffer();
		if (sign) {
			pat.append("[+|-]?");
		}
		if (point_bef == 0) {
			pat.append("[0]");
		} else {
			pat.append("[0-9]{1,");
			pat.append(point_bef);
			pat.append("}");
		}
		if (point && str.indexOf(".") != -1) {// 允许小数点,并且有小数点
			pat.append("[.]");
			pat.append("[0-9]{1,");// 小数点后必须有一位
			pat.append(point_aft);
			pat.append("}");
		}
		Pattern pattern = Pattern.compile(pat.toString());
		if (!pattern.matcher(str).matches()) {
			return false;
		} else {// 排除如00.1,返回false
			if (str.indexOf(".") != -1 && str.substring(0, str.indexOf(".")).length() > 1
					&& DataUtil.parseInt(str.substring(0, str.indexOf("."))) == 0) {
				return false;
			} else {
				return true;
			}
		}
	}

	/**
	 *方法用途：查看字符串是否有这个子字符串
	 * 
	 * @param str
	 *          主字符串
	 * @param substr
	 *          字字符串
	 * @return
	 */
	public static boolean hasSubstring(String str, String substr) {
		if (str == null || substr == null)
			return false;
		int strLen = str.length();
		int substrLen = substr.length();
		for (int i = 0; (i + substrLen) <= strLen; i++) {
			if (str.substring(i, i + substrLen).equalsIgnoreCase(substr)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * 方法用途: 判断传入的是否手机号<br>
	 * 操作步骤: 正则表达式校验， 推荐方式<br>
	 * @param mobile
	 * @return  true 是 false 否
	 */
	public static boolean isMobileForRegx(String mobile) {
		if (StringUtils.isBlank(mobile)) {
			return false;
		}
		return Pattern.matches("^(1[3|5|8])\\d{9}$", mobile);
	}
	
	/**
	 * 
	 * 方法用途: 判断传入的是否手机号<br>
	 * 操作步骤: 普通方式校验<br>
	 * @param mobile
	 * @return true 是 false 否
	 */
	@Deprecated
	public static boolean isMobileForNormal(String mobile) {
		if (StringUtils.isBlank(mobile)) {
			return false;
		}
		if (mobile.length() != 11) {
			return false;
		}
		if (!mobile.substring(0, 2).equals("13")) {
			return false;
		}
		for (int i = 0; i < 11; i++) {
			if ("0123456789".indexOf(String.valueOf(mobile.charAt(i))) == -1) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * 方法用途: 替换空字符串<br>
	 * 操作步骤: <br>
	 * @param field
	 * @return
	 */
	public static String replaceNull(String field) {
		if (field == null || "undefined".equals(field) || "null".equalsIgnoreCase(field) || "".equals(field.trim())) {
			return "";
		} else {
			return field;
		}
	}

	/**
	 * 方法用途:判断是否为空
	 * 
	 * @param str
	 * @return boolean
	 * @date 2010-8-21
	 * @author yhd
	 */
	public static boolean strIsNull(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 *方法用途：字符串不以"/"结尾，则在串尾加"/"
	 * 
	 * @param s
	 * @return
	 */
	public static String addSlashInEnd(String s) {
		if (s != null) {
			if (!s.endsWith("/")) {
				s = s + "/";
			}
		}
		return s;
	}

	/**
	 *方法用途：传入一个数字类型的参数，返回一个小数点后两位的小数
	 * 
	 * @param parm
	 */
	public static String ConverDouble(String parm) {
		if (isNumeric(parm, false, true)) {
			if (parm.indexOf(".") >= 0) {
				String value = parm.substring(parm.indexOf(".") + 1);
				if (value.length() == 1) {
					return parm + "0";
				} else if (value.length() > 2) {
					return parm.substring(0, parm.indexOf(".") + 1) + value.substring(0, 2);
				} else {
					return parm;
				}

			} else {
				return parm + ".00";
			}
		}
		return null;
	}
	/**
	 * 
	 * 
	 * 方法用途: 判断是否为空指针或是长度为0的字符串<br>
	 * 操作步骤: <br>
	 * @param str
	 * @return
	 */
	public static Boolean isEmpty(String str) {
		return str == null || str.length() == 0;

	}

	/**
	 * * 判断一个对象数组是否为空
	 *
	 * @param objects 要判断的对象数组
	 ** @return true：为空 false：非空
	 */
	public static boolean isEmpty(Object[] objects)
	{
		return isNull(objects) || (objects.length == 0);
	}
	/**
	 * 方法用途: 判断字符串非空<br>
	 * 操作步骤: <br>
	 * @param str
	 * @return
	 */
	public static Boolean isNotBlank(String str) {
		return !isBlank(str);
	}
	/**
	 * 方法用途: 根据指定长度生成字符串类型数字<br>
	 * 操作步骤: <br>
	 * @param len
	 * @return
	 */
	public static String generatorNumber(int len) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < len; i++) {
			int t = Math.abs(new Random().nextInt()) % 10;
			sb.append(t);
		}
		return sb.toString();
	}

	/**
	 * 
	 * 方法用途: 生成新的文件名<br>
	 * 操作步骤: <br>
	 * @return
	 */
	public static String getNewFileName() {
		StringBuffer sb = new StringBuffer();
		Calendar calendar = Calendar.getInstance();
		sb.append(calendar.get(Calendar.YEAR));
		sb.append(calendar.get(Calendar.MONTH) + 1);
		sb.append(calendar.get(Calendar.DAY_OF_MONTH));
		sb.append(calendar.get(Calendar.HOUR_OF_DAY));
		sb.append(calendar.get(Calendar.MINUTE));
		sb.append(calendar.get(Calendar.SECOND));
		sb.append(num.addAndGet(1));
		if (num.get() > MAXNUM) {
			num.set(0);
		}
		return sb.toString();
	}

	/**
	   * 方法用途: 获取定长的字符串
	   * @param val
	   * @param len
	   * @return
	   */
	public static String getFixedLengthSeq(String val, int len) {
		int valLen = val.length();
		if (valLen < len) {
			StringBuffer seq = new StringBuffer();
			for (int i = 0; i < len - valLen; i++) {
				seq.append("0");
			}
			seq.append(val);
			return seq.toString();
		} else {
			return val.substring(0, len);
		}
	}

	/**
	 * 方法用途: 判断字符串是否是大写 <br>
	 * 操作步骤: <br>
	 * @param word
	 * @return true 是 false不是
	 */
	public static boolean isAcronym(String word)
	 {
		  for(int i = 0; i < word.length(); i++){
			   char c = word.charAt(i);
			   if(Character.isLowerCase(c))
			   {
				   return false;
			   }
		  }
		  
		   return true;
	 }
	/**
	 * 方法用途: 判断字符串是否是字母<br>
	 * 操作步骤: <br>
	 * @param word
	 * @return true 是 false不是
	 */
	public static boolean isLetter(String word)
	{
		for(int i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			if(!Character.isLetter(c))
			{
				return false;
			}
		}
		return true;
	}
	/**
	 * 方法用途: 将String 数据转成Sting返回，以逗号分隔。<br>
	 * 操作步骤: <br>
	 * @param array
	 * @return
	 */
	public static String array2String(String[] array)
	{	String rs = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]).append(",");
			
		}
		if(sb.length() >0){
			rs=sb.substring(0, sb.length()-1);
		}
		return rs;
	}
	
	
	/**
	 * 格式化字符
	 * 
	 * @param str
	 * @param args
	 * @return String
	 */
	public static String format(String str, Object... args) {
		String result = str;
		Pattern p = Pattern.compile("\\{(\\d+)\\}");
		java.util.regex.Matcher m = p.matcher(str);
		while (m.find()) {
			int index = DataUtil.parseInt(m.group(1));
			if (index < args.length) {
				result = result.replace(m.group(), ObjectUtils.notNull(args[index], "").toString());
			}
		}
		return result;
	}
	
	/**
	 * 编码
	 * 
	 * @param str
	 * @return
	 */
	public static String coding(String str) {
		return coding(str, "ISO-8859-1");
	}
	
	public static String coding(String str, String charset) {
		//Init.charSet  从配置文件中读取，考虑读取不到，或是没有配置项目，或是配置项为空的默认值的处理或是默认处理逻辑。保证系统不会出错。
//		return coding(str, charset, Init.charSet);
		return coding(str, charset, "UTF-8");
	}
	
	public static String coding(String str, String charset, String tocharset) {
		try {
			return str == null ? "" : new String(str.getBytes(charset), tocharset);
		} catch (Exception E) {
			return str;
		}
	}
	
	
	/**
	 * Escape 解码
	 * 
	 * @param src
	 * @return
	 */
	public static String unescape(String src) {
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length());
		int lastPos = 0, pos = 0;
		char ch;
		while (lastPos < src.length()) {
			pos = src.indexOf("%", lastPos);
			if (pos == lastPos) {
				if (src.charAt(pos + 1) == 'u') {
					ch = (char) DataUtil.parseInt(src.substring(pos + 2, pos + 6), 16);
					tmp.append(ch);
					lastPos = pos + 6;
				} else {
					ch = (char) DataUtil.parseInt(src.substring(pos + 1, pos + 3), 16);
					tmp.append(ch);
					lastPos = pos + 3;
				}
			} else {
				if (pos == -1) {
					tmp.append(src.substring(lastPos));
					lastPos = src.length();
				} else {
					tmp.append(src.substring(lastPos, pos));
					lastPos = pos;
				}
			}
		}
		return tmp.toString();
	}
	
	/**
	 * 截取一定长度字符串，用于页面显示，如果长度超出截取部分，用postfix续尾
	 *
	 * @param str
	 * @param start
	 * @param end
	 * @param postfix
	 * @return string after substring
	 */
	@Deprecated
	public static String substringForEncode(String src, int start, int length, String postfix) {
		if (src != null && length(src) > length) {
			try {
				byte[] rc = src.getBytes("GBK");
				short charlen = 2;
				int count = 0;
				if (!new String(rc).equals(src)) {
					rc = src.getBytes("UTF-8");
					charlen = 3;
				}
				length = Math.max(Math.min(length - start, rc.length), 1);
				byte[] bs = new byte[length];
				System.arraycopy(rc, start, bs, 0, length);
				for (byte c : bs)
					if (c < 0) count++;
				if (count % charlen != 0) return substring(src, start, length - (count % charlen), postfix);
				return new String(bs) + postfix;
			} catch (Exception e) {
				return src.substring(start, length - postfix.length()) + postfix;
			}
		}
		return src;
	}
	/**
	 * 截取一定长度字符串，用于页面显示，如果长度超出截取部分，用postfix续尾
	 *
	 * @param str
	 * @param start
	 * @param end
	 * @param postfix
	 * @return string after substring
	 */
	public static String substring(String str, int start, int end,String postfix) {
		int length = str.length();
		if (length <= start) {
			return str;
		} else if (length <= end) {
			return str.substring(start, length);
		} else {
			return str.substring(start, end) + postfix;
		}
	}
	
	
	/**
	 * 截取一定长度字符串，用于页面显示，如果长度超出截取部分，用"..."续尾
	 *
	 * @param str
	 * @param start
	 * @param end
	 * @param postfix
	 * @return string after substring
	 */
	public static String substring(String str, int start, int end) {
		return substring(str, start, end, "...");
	}

	
	
	/**
	 * bytes to hex string
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bytes2Hex(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			int i = b & 0xFF;
			if (i <= 0xF) {
				sb.append("0");
			}
			sb.append(Integer.toHexString(i));
		}
		return sb.toString();
	}
	
	
	
	private static byte hex2Byte(String s) {
		int high = HEX_CHAR_LIST.indexOf(new Character(s.charAt(0))) << 4;
		int low = HEX_CHAR_LIST.indexOf(new Character(s.charAt(1)));
		
		return (byte) (high + low);
	}
	
	/**
	 * hex string to bytes
	 * 
	 * @param bytes
	 * @return
	 */
	public static byte[] hex2Bytes(String input) {
		int len = input.length() / 2;
		byte[] rtn = new byte[len];
		
		for (int i = 0; i < len; i++) {
			rtn[i] = hex2Byte(input.substring(i * 2, i * 2 + 2));
		}
		return rtn;
	}
	
	// 添加数组转化，将String[]转化成Integer[]
	public static Integer[] convertToIntegerArray(String[] values) throws BusinessException {
		Integer[] result = new Integer[values.length];
		try {
			for (int i = 0; i < values.length; i++) {
				result[i] = DataUtil.parseInt(values[i]);
			}
		} catch (Exception e) {
			throw new BusinessException("convertToIntegerArray error!" + e.getMessage());
		}
		return result;
	}
	
	public static Long[] convertToLongArray(String[] values) {
		Long[] result = new Long[values.length];
		try {
			for (int i = 0; i < values.length; i++) {
				result[i] = Long.valueOf(values[i]);
			}
		} catch (Exception e) {
			throw new BusinessException("convertToIntegerArray error!" + e.getMessage());
		}
		return result;
	}
	
	public static Double[] convertToDoubleArray(String[] values) {
		Double[] result = new Double[values.length];
		try {
			for (int i = 0; i < values.length; i++) {
				result[i] = Double.valueOf(values[i]);
			}
		} catch (Exception e) {
			throw new BusinessException("convertToDoubleArray error!" + e.getMessage());
		}
		return result;
	}
	
	public static Short[] convertToShortArray(String[] values) {
		Short[] result = new Short[values.length];
		try {
			for (int i = 0; i < values.length; i++) {
				result[i] = Short.valueOf(values[i]);
			}
		} catch (Exception e) {
			throw new BusinessException("convertToShortArray error!" + e.getMessage());
		}
		return result;
	}
	
	/**
	 * 去除所有html标签
	 * 
	 * @param content
	 * @return
	 */
	public static String removeHtml(String content) {
		if (null == content) return "";
		Pattern p_html;
		java.util.regex.Matcher m_html;
		try {
			p_html = Pattern.compile("<[^>]+>", Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(content);
			content = m_html.replaceAll("");
		} catch (Exception e) {
			return "";
		}
		return content;
	}
	
	/**
	 * 去除所有html标签
	 * 
	 * @param content
	 * @return
	 */
	public static String removeIframe(String content) {
		if (null == content) return "";
		Pattern p_html;
		java.util.regex.Matcher m_html;
		try {
			p_html = Pattern.compile("<iframe[^>]+>", Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(content);
			content = m_html.replaceAll("");
		} catch (Exception e) {
			return "";
		}
		return content;
	}
	
	/**
	 * 去除样式加载
	 * 
	 * @param content
	 * @return
	 */
	public static String removeStyle(String content) {
		if (null == content) return "";
		Pattern p_html;
		java.util.regex.Matcher m_html;
		try {
			p_html = Pattern.compile("<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>", Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(content);
			content = m_html.replaceAll("");
		} catch (Exception e) {
			return "";
		}
		return content;
	}
	
	/**
	 * 去除脚本
	 * 
	 * @param content
	 * @return
	 */
	public static String removeScript(String content) {
		if (null == content) return "";
		Pattern p_html;
		java.util.regex.Matcher m_html;
		try {
			p_html = Pattern.compile("<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>", Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(content);
			content = m_html.replaceAll("");
		} catch (Exception e) {
			return "";
		}
		return content;
	}
	
	/**
	 * 去除空格
	 * 
	 * @param content
	 * @return
	 */
	public static String removeSpace(String content) {
		if (null == content) return "";
		return content.replaceAll("\\s*(\\r\\n)\\s*", "").replaceAll(">(\\s+)", ">").replaceAll("(\\s+)<", "<");
	}
	
	
	public static String getPrefix(String content , String regex){
		int _index = content.indexOf(regex);
		if(_index >= 0){
			return content.substring(0,_index);
		}
		return content;
	}
	
	//---------------1--------------
	
	/*
	 * 将字符串的首字母改成大写，其余不变。
	 */
	public static String firstUpperCase(String str){
		Character first = new Character((char)(str.charAt(0)-32));
		if(first>='A'&&first<='Z'){
			return first.toString()+str.substring(1);
		}else if(first>='a'&&first<='z'){
			return str;
		}else{
			return str;
		}
	}	
	
	//--------------2--------------
	
	
	

	 /* ------------------------------------------------------------ */
	 /**
	  * fast lower case conversion. Only works on ascii (not unicode)
	  * @param s the string to convert
	  * @return a lower case version of s
	  */
	 public static String asciiToLowerCase(String s)
	 {
	     char[] c = null;
	     int i=s.length();

	     // look for first conversion
	     while (i-->0)
	     {
	         char c1=s.charAt(i);
	         if (c1<=127)
	         {
	             char c2=lowercases[c1];
	             if (c1!=c2)
	             {
	                 c=s.toCharArray();
	                 c[i]=c2;
	                 break;
	             }
	         }
	     }

	     while (i-->0)
	     {
	         if(c[i]<=127)
	             c[i] = lowercases[c[i]];
	     }
	     
	     return c==null?s:new String(c);
	 }


	 /* ------------------------------------------------------------ */
	 public static boolean startsWithIgnoreCase(String s,String w)
	 {
	     if (w==null)
	         return true;
	     
	     if (s==null || s.length()<w.length())
	         return false;
	     
	     for (int i=0;i<w.length();i++)
	     {
	         char c1=s.charAt(i);
	         char c2=w.charAt(i);
	         if (c1!=c2)
	         {
	             if (c1<=127)
	                 c1=lowercases[c1];
	             if (c2<=127)
	                 c2=lowercases[c2];
	             if (c1!=c2)
	                 return false;
	         }
	     }
	     return true;
	 }
	 
	 /* ------------------------------------------------------------ */
	 public static boolean endsWithIgnoreCase(String s,String w)
	 {
	     if (w==null)
	         return true;

	     if (s==null)
	         return false;
	         
	     int sl=s.length();
	     int wl=w.length();
	     
	     if (sl<wl)
	         return false;
	     
	     for (int i=wl;i-->0;)
	     {
	         char c1=s.charAt(--sl);
	         char c2=w.charAt(i);
	         if (c1!=c2)
	         {
	             if (c1<=127)
	                 c1=lowercases[c1];
	             if (c2<=127)
	                 c2=lowercases[c2];
	             if (c1!=c2)
	                 return false;
	         }
	     }
	     return true;
	 }
	 
	 /* ------------------------------------------------------------ */
	 /**
	  * returns the next index of a character from the chars string
	  */
	 public static int indexFrom(String s,String chars)
	 {
	     for (int i=0;i<s.length();i++)
	        if (chars.indexOf(s.charAt(i))>=0)
	           return i;
	     return -1;
	 }
	 
	 /* ------------------------------------------------------------ */
	 
	 /**
	 * 
	 * 方法用途: 字符串替换， <br>
	 * 操作步骤: 注意：可用于替代substring方法的使用<br>
	 * @param s
	 * @param sub
	 * @param with
	 * @return
	 */
	public static String replace(String s, String sub, String with)
	 {
	     int c=0;
	     int i=s.indexOf(sub,c);
	     if (i == -1)
	         return s;
	 
	     StringBuilder buf = new StringBuilder(s.length()+with.length());

	     do
	     {
	         buf.append(s.substring(c,i));
	         buf.append(with);
	         c=i+sub.length();
	     } while ((i=s.indexOf(sub,c))!=-1);

	     if (c<s.length())
	         buf.append(s.substring(c,s.length()));

	     return buf.toString();
	     
	 }
	 
	 /**
	 * 
	 * 方法用途: 旧的字符串替换方式，考虑和replace方法合并，目前废弃<br>
	 * 操作步骤: TODO<br>
	 * @param s
	 * @param s1
	 * @param s2
	 * @return
	 */
	@Deprecated
	 public static String replaceForOld(String s, String s1, String s2) {
			StringBuffer stringbuffer = new StringBuffer();
			int i = s.length();
			int j = s1.length();
			int k;
			int l;
			for (k = 0; (l = s.indexOf(s1, k)) >= 0; k = l + j) {
				stringbuffer.append(s.substring(k, l));
				stringbuffer.append(s2);
			}

			if (k < i)
				stringbuffer.append(s.substring(k));
			return stringbuffer.toString();
		}


	 /* ------------------------------------------------------------ */
	 /** Remove single or double quotes.
	  */
	 public static String unquote(String s)
	 {
	     return null;//QuotedStringTokenizer.unquote(s); //TODO
	 }


	 /* ------------------------------------------------------------ */
	 /** Append substring to StringBuilder 
	  * @param buf StringBuilder to append to
	  * @param s String to append from
	  * @param offset The offset of the substring
	  * @param length The length of the substring
	  */
	 public static void append(StringBuilder buf,
	                           String s,
	                           int offset,
	                           int length)
	 {
	     synchronized(buf)
	     {
	         int end=offset+length;
	         for (int i=offset; i<end;i++)
	         {
	             if (i>=s.length())
	                 break;
	             buf.append(s.charAt(i));
	         }
	     }
	 }

	 
	 /* ------------------------------------------------------------ */
	 /**
	  * append hex digit
	  * 
	  */
	 public static void append(StringBuilder buf,byte b,int base)
	 {
	     int bi=0xff&b;
	     int c='0'+(bi/base)%base;
	     if (c>'9')
	         c= 'a'+(c-'0'-10);
	     buf.append((char)c);
	     c='0'+bi%base;
	     if (c>'9')
	         c= 'a'+(c-'0'-10);
	     buf.append((char)c);
	 }

	 /* ------------------------------------------------------------ */
	 public static void append2digits(StringBuffer buf,int i)
	 {
	     if (i<100)
	     {
	         buf.append((char)(i/10+'0'));
	         buf.append((char)(i%10+'0'));
	     }
	 }
	 
	 /* ------------------------------------------------------------ */
	 public static void append2digits(StringBuilder buf,int i)
	 {
	     if (i<100)
	     {
	         buf.append((char)(i/10+'0'));
	         buf.append((char)(i%10+'0'));
	     }
	 }
	 
	 /* ------------------------------------------------------------ */
	 /** Return a non null string.
	  * @param s String
	  * @return The string passed in or empty string if it is null. 
	  */
	 public static String nonNull(String s)
	 {
	     if (s==null)
	         return "";
	     return s;
	 }
	 
	 /* ------------------------------------------------------------ */
	 public static boolean equals(String s,char[] buf, int offset, int length)
	 {
	     if (s.length()!=length)
	         return false;
	     for (int i=0;i<length;i++)
	         if (buf[offset+i]!=s.charAt(i))
	             return false;
	     return true;
	 }

	 /* ------------------------------------------------------------ */
	 public static String toUTF8String(byte[] b,int offset,int length)
	 {
	     try
	     {
	         return new String(b,offset,length,__UTF8);
	     }
	     catch (UnsupportedEncodingException e)
	     {
	         throw new IllegalArgumentException(e);
	     }
	 }

	 /* ------------------------------------------------------------ */
	 public static String toString(byte[] b,int offset,int length,String charset)
	 {
	     try
	     {
	         return new String(b,offset,length,charset);
	     }
	     catch (UnsupportedEncodingException e)
	     {
	         throw new IllegalArgumentException(e);
	     }
	 }


	 /* ------------------------------------------------------------ */
	 public static boolean isUTF8(String charset)
	 {
	     return charset==__UTF8||__UTF8.equalsIgnoreCase(charset)||__UTF8Alt.equalsIgnoreCase(charset);
	 }


	 /* ------------------------------------------------------------ */
	 public static String printable(String name)
	 {
	     if (name==null)
	         return null;
	     StringBuilder buf = new StringBuilder(name.length());
	     for (int i=0;i<name.length();i++)
	     {
	         char c=name.charAt(i);
	         if (!Character.isISOControl(c))
	             buf.append(c);
	     }
	     return buf.toString();
	 }
	 
	 public static byte[] getBytes(String s)
	 {
	     try
	     {
	         return s.getBytes(__ISO_8859_1);
	     }
	     catch(Exception e)
	     {
	         LOG.warn(e.getMessage());
	         return s.getBytes();
	     }
	 }
	 
	 public static byte[] getBytes(String s,String charset)
	 {
	     try
	     {
	         return s.getBytes(charset);
	     }
	     catch(Exception e)
	     {
	         LOG.warn(e.getMessage());
	         return s.getBytes();
	     }
	 }
	 
	 
	 
	 /**
	  * Converts a binary SID to a string SID
	  * 
	  * http://en.wikipedia.org/wiki/Security_Identifier
	  * 
	  * S-1-IdentifierAuthority-SubAuthority1-SubAuthority2-...-SubAuthorityn
	  */
	 public static String sidBytesToString(byte[] sidBytes)
	 {
	     StringBuilder sidString = new StringBuilder();
	     
	     // Identify this as a SID
	     sidString.append("S-");
	     
	     // Add SID revision level (expect 1 but may change someday)
	     sidString.append(Byte.toString(sidBytes[0])).append('-');
	     
	     StringBuilder tmpBuilder = new StringBuilder();
	     
	     // crunch the six bytes of issuing authority value
	     for (int i = 2; i <= 7; ++i)
	     {
	         tmpBuilder.append(Integer.toHexString(sidBytes[i] & 0xFF));
	     }
	     
	     sidString.append(Long.parseLong(tmpBuilder.toString(), 16)); // '-' is in the subauth loop

	     // the number of subAuthorities we need to attach
	     int subAuthorityCount = sidBytes[1];

	     // attach each of the subAuthorities
	     for (int i = 0; i < subAuthorityCount; ++i)
	     {
	         int offset = i * 4;
	         tmpBuilder.setLength(0);
	         // these need to be zero padded hex and little endian
	         tmpBuilder.append(String.format("%02X%02X%02X%02X", 
	                 (sidBytes[11 + offset] & 0xFF),
	                 (sidBytes[10 + offset] & 0xFF),
	                 (sidBytes[9 + offset] & 0xFF),
	                 (sidBytes[8 + offset] & 0xFF)));  
	         sidString.append('-').append(Long.parseLong(tmpBuilder.toString(), 16));
	     }
	     
	     return sidString.toString();
	 }
	 
	 /**
	  * Converts a string SID to a binary SID
	  * 
	  * http://en.wikipedia.org/wiki/Security_Identifier
	  * 
	  * S-1-IdentifierAuthority-SubAuthority1-SubAuthority2-...-SubAuthorityn
	  */
	 public static byte[] sidStringToBytes( String sidString )
	 {
	     String[] sidTokens = sidString.split("-");
	     
	     int subAuthorityCount = sidTokens.length - 3; // S-Rev-IdAuth-
	     
	     int byteCount = 0;
	     byte[] sidBytes = new byte[1 + 1 + 6 + (4 * subAuthorityCount)];
	     
	     // the revision byte
	     sidBytes[byteCount++] = (byte)Integer.parseInt(sidTokens[1]);

	     // the # of sub authorities byte
	     sidBytes[byteCount++] = (byte)subAuthorityCount;

	     // the certAuthority
	     String hexStr = Long.toHexString(Long.parseLong(sidTokens[2]));
	     
	     while( hexStr.length() < 12) // pad to 12 characters
	     {
	         hexStr = "0" + hexStr;
	     }

	     // place the certAuthority 6 bytes
	     for ( int i = 0 ; i < hexStr.length(); i = i + 2)
	     {
	         sidBytes[byteCount++] = (byte)Integer.parseInt(hexStr.substring(i, i + 2),16);
	     }
	             
	     
	     for ( int i = 3; i < sidTokens.length ; ++i)
	     {
	         hexStr = Long.toHexString(Long.parseLong(sidTokens[i]));
	         
	         while( hexStr.length() < 8) // pad to 8 characters
	         {
	             hexStr = "0" + hexStr;
	         }     
	         
	         // place the inverted sub authorities, 4 bytes each
	         for ( int j = hexStr.length(); j > 0; j = j - 2)
	         {          
	             sidBytes[byteCount++] = (byte)Integer.parseInt(hexStr.substring(j-2, j),16);
	         }
	     }
	   
	     return sidBytes;
	 }
	 
	 //-----------------------3----------------------------
	 

/**
	 * 将str中的特殊字符，如'\n'，'<'等，转换为可显示在页面上的HTML编码
	 *
	 * @param str
	 * @return string after encode
	 */
	public static String filterHtmlEncode(String str) {
		if (str == null)
			return "";
		StringBuffer sb = new StringBuffer(str.length() + str.length() / 4);
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			switch (ch) {
			case '\n':
				sb.append("<br>");
				break;
			case '<':
				sb.append("&lt;");
				break;
			case '>':
				sb.append("&gt;");
				break;
			case '&':
				sb.append("&amp;");
				break;
			case '\'':
				sb.append("&apos;");
				break;
			case '\"':
				sb.append("&quot;");
				break;
			case ' ':
				sb.append("&nbsp;");
				break;
			default:
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	/**
	 * filter null string to ""
	 *
	 * @param s
	 * @return
	 */
	public static String filterNullString(String s) {
		return filterNullString(s, "");
	}

	/**
	 * filter null string to def
	 *
	 * @param s
	 * @param def
	 * @return
	 */
	public static String filterNullString(String s, String def) {
		if (s == null || "".equals(s))
			return def;
		return s;
	}

	private static HashMap<String, SimpleDateFormat> _simpleDateFormat = new HashMap<String, SimpleDateFormat>();

	public static SimpleDateFormat getSimpleDateFormat() {
		return getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * result may be null, the object
	 *
	 * @param form
	 * @return
	 */
	public static SimpleDateFormat getSimpleDateFormat(String form) {
		SimpleDateFormat result = null;
		if (_simpleDateFormat.containsKey(form)) {
			result = (SimpleDateFormat) _simpleDateFormat.get(form);
		}
		if (result == null) {
			try {
				result = new SimpleDateFormat(form);
			} catch (Exception e) {
			}
			if (result != null) {
				_simpleDateFormat.put(form, result);
			}
		}
		return result;
	}

	/**
	 * Convert date format to specified pattern.
	 *
	 * @param date
	 * @param pattern
	 * @return string expression of date according to pattern
	 */
	public static String formatDate(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * Convert date format to specified pattern.
	 *
	 * @param date
	 * @param pattern
	 * @return string expression of date according to pattern
	 */
	public static Date parseDate(String str, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date();
	}

	

	/**
	 * 将GBK编码字符串转换为ISO8859_1编码
	 *
	 * @param origin
	 * @return
	 */
	public static String toASCIIString(String origin) {
		if (null == origin)
			return "";

		try {
			return new String(origin.getBytes("GBK"), "ISO8859_1");
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 将ISO8859_1编码字符串转换为GBK编码
	 *
	 * @param origin
	 * @return
	 */
	public static String toGBKString(String origin) {
		if (null == origin)
			return "";

		try {
			return new String(origin.getBytes("ISO8859_1"), "GBK");
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 根据文件名或路径取得后缀名
	 *
	 * @param filename
	 * @return
	 */
	public static String parseFileExt(String filename) {
		int pos = filename.lastIndexOf('.');
		if (pos >= 0) {
			return filename.substring(pos + 1);
		} else {
			return "";
		}
	}

	/**
	 * 根据文件路径取得文件名
	 *
	 * @param filename
	 * @return
	 */
	public static String parseFileName(String filename) {
		int pos = filename.lastIndexOf(File.separator);
		if (pos >= 0) {
			return filename.substring(pos + 1);
		} else {
			return filename;
		}
	}

	// ======================sms.util.StringUtils.java
	public static void printBytes(byte[] data) {
		try {

			for (int i = 0; i < data.length; i++)
				System.out.print(add0(Integer.toHexString((int) data[i]), 2)
						+ " ");
			System.out.println();
		} catch (Exception e) {
		}
	}

	public static int abs(int v) {
		return v < 0 ? -v : v;
	}

	public static byte[] reverse(byte[] src) {
		if (src != null) {
			byte[] tmp = new byte[src.length];
			for (int i = 0; i < src.length; i++) {
				tmp[src.length - i - 1] = src[i];
			}
			return tmp;
		}
		return null;
	}

	public static String cut(String s1, String s2) {
		if (s1 == null || s2 == null)
			return null;
		int pos = s1.indexOf(s2);
		if (pos > -1) {
			if (s1.length() == s2.length())
				return "";
			return s1.substring(pos + s2.length(), s1.length());
		}
		return s1;
	}

	private static String add0(String s, int length) {
		if (s == null)
			return null;
		if (s.length() >= length)
			return s.substring(s.length() - length, s.length());
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < (length - s.length()); i++)
			bf.append("0");
		bf.append(s);
		return bf.toString();
	}

	public static String cut(String s, int len) {

		if (s == null)
			return null;
		if (s.length() > len)
			return s.substring(0, len);
		return s;
	}

	public static String cutEnd(String s1, String s2) {
		if (s1 == null || s2 == null)
			return null;
		int pos = s1.lastIndexOf(s2);
		if (pos > -1) {
			if (pos == 0)
				return "";
			return s1.substring(0, pos);
		}
		return s1;
	}

	public static String null2String(String s) {
		return s == null ? "" : s;
	}

	public static String null2String(String s, String def) {
		if (s == null)
			return def;
		if ("".equals(s))
			return def;
		return s;
	}

	public static int getIntValue(String v) {
		return getIntValue(v, -1);
	}

	public static int getIntValue(Object obj) {
		return getIntValue(obj.toString(), -1);
	}

	public static int getIntValue(String v, int def) {
		try {
			return DataUtil.parseInt(v.trim());
		} catch (Exception ex) {
			return def;
		}
	}

	public static long getLongValue(String v) {
		return getLongValue(v, -1);
	}

	public static long getLongValue(String v, int def) {
		try {
			return Long.parseLong(v.trim());
		} catch (Exception ex) {
			return def;
		}
	}

	public static float getFloatValue(String v, float def) {
		try {
			return Float.parseFloat(v.trim());
		} catch (Exception ex) {
			return def;
		}
	}

	public static double getDoubleValue(String v, double def) {
		try {
			return Double.parseDouble(v.trim());
		} catch (Exception ex) {
			return def;
		}
	}

	public static String[] split(String s, char c) {
		String as[] = { s, "" };
		int i = s.indexOf(c);
		if (i != -1) {
			as[0] = s.substring(0, i);
			as[1] = s.substring(i + 1);
		}
		return as;
	}

	// //
	// split string

	public static String[] splitString(String s, String delim) {
		if (s == null)
			return null;
		return splitString(new StringTokenizer(s, delim));
	}

	public static String[] splitString(String s) {
		if (s == null)
			return null;
		return splitString(new StringTokenizer(s));
	}

	private static String[] splitString(StringTokenizer st) {
		int i = st.countTokens();
		String as[] = new String[i];
		for (int j = 0; j < i; j++) {
			as[j] = st.nextToken();
		}
		return as;
	}

	public static byte[] chars2bytes(char ac[]) {
		byte ab[] = new byte[ac.length * 2];
		int i = 0;
		for (int j = 0; j < ac.length; j++) {
			char c0 = ac[j];
			char c1 = ac[j];
			ab[i++] = (byte) (c0 >> 8);
			ab[i++] = (byte) (c1);
		}
		return ab;
	}

	public static char[] bytes2chars(byte ab[]) throws Exception {
		if (ab.length % 2 != 0)
			throw new Exception("Can't connvert an odd number of bytes");

		char ac[] = new char[ab.length / 2];
		int i = 0;
		for (int j = 0; j < ac.length; j++) {
			byte b0 = ab[i++];
			byte b1 = ab[i++];
			ac[j] = (char) (b0 << 8 & 0xff00 | b1 & 0xff);
		}
		return ac;
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// current language => unicode
	public static String toUnicode(String s) {
		return toUnicode(s, "ISO8859-1");
	}

	public static String toEncode(String s) {
		return toEncode(s, "ISO8859-1");
	}

	public static String toUnicode(String s, String lang) {
		if (s == null)
			return s;

		try {
			byte[] target_byte = s.getBytes();
			return new String(target_byte, lang); // "gb2312". "ISO8859-1"
			// ."Big5"..
		} catch (Exception ex) {
			return s;
		}
	}

	// unicode => current language
	public static String toEncode(String s, String lang) {
		if (s == null)
			return s;
		try {
			byte[] target_byte = s.getBytes(lang);
			return new String(target_byte);
		} catch (Exception ex) {
			return s;
		}
	}

	/*
	 * check if string have other code @ "wang.wei" return true @ "王.wei" return
	 * false
	 */

	public static boolean isEString(String s) {
		if (s == null)
			return false;
		if (s.equals(""))
			return false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!(Character.isLetterOrDigit(c) || (".-_:".indexOf(c) != -1)))
				return false;
			// if(!Character.isLetterOrDigit(c)) return false;
		}
		return true;
	}

	public static boolean contains(Object a[], Object s) {
		if (a == null || s == null)
			return false;
		for (int i = 0; i < a.length; i++)
			if (a[i] != null && a[i].equals(s))
				return true;
		return false;
	}

	public static String extract(String c, String begin_tag, String end_tag) {
		int begin = begin_tag == null ? 0 : c.indexOf(begin_tag);
		int len = begin_tag == null ? 0 : begin_tag.length();
		int end = end_tag == null ? c.length() : c
				.indexOf(end_tag, begin + len);

		if (begin == -1 || end == -1)
			return "";
		return c.substring(begin + len, end);
	}

	public static String remove(String s1, String s2) {
		int i = s1.indexOf(s2);
		int l = s2.length();
		if (i != -1)
			return s1.substring(0, i) + s1.substring(i + l);
		return s1;
	}

	public static String toDispDate(Date d) {
		String ret = "";
		ret = SimpleDateFormat.getDateInstance().format(d);
		return ret;
	}

	// --------------------------------------------------------------------------
	public static String toHTML(String s) {
		char c[] = s.toCharArray();
		char ch;
		int i = 0;
		StringBuffer buf = new StringBuffer();

		while (i < c.length) {
			ch = c[i++];

			if (ch == '"')
				buf.append("&quot;");
			else if (ch == '&')
				buf.append("&amp;");
			else if (ch == '<')
				buf.append("&lt;");
			else if (ch == '>')
				buf.append("&gt;");
			else if (ch == '\'')
				buf.append("&apos;");
			else
				buf.append(ch);
		}
		return buf.toString();
	}

	public static String formatHTML(String s) {
		char c[] = s.toCharArray();
		char ch;
		int i = 0;
		StringBuffer buf = new StringBuffer();

		while (i < c.length) {
			ch = c[i++];

			if (ch == '\n')
				buf.append("<br>");
			else
				buf.append(ch);
		}
		return buf.toString();
	}

	// --------------------------------------------------------------------------
	// file method
	//
	// --------------------------------------------------------------------------
	public static String extractFileName(String s) {
		int pos = s.lastIndexOf(File.separatorChar);
		if (pos != -1)
			return s.substring(pos + 1);
		else
			return s;
	}

	// --------------------------------------------------------------------------
	public static String extractFileExt(String s) {
		String s_ = extractFileName(s);
		int pos = s_.lastIndexOf(".");
		if (pos != -1)
			return s_.substring(pos + 1);
		else
			return s_;
	}

	// --------------------------------------------------------------------------
	public static String extractFilePath(String s) {
		int pos = s.lastIndexOf(File.separatorChar);
		if (pos != -1)
			return s.substring(0, pos + 1);
		else
			return "";
	}

	// --------------------------------------------------------------------------
	public static String loadFile(String filename) {
		try {
			FileInputStream in = new FileInputStream(new File(filename));
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			convertStream(in, os);
			return os.toString();
		} catch (Exception ex) {
		}
		return "";
	}

	public static void convertStream(InputStream is, OutputStream os)
			throws NullPointerException, IOException {
		if (is == null || os == null)
			throw new NullPointerException();

		byte[] buf = new byte[1024];
		int cnt;
		while ((cnt = is.read(buf)) != -1)
			os.write(buf, 0, cnt);

		is.close();
		os.close();
	}

	public static void swap(Object a[], int i, int j) {
		Object t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static String StringReplace(String sou, String s1, String s2) {
		int idx = sou.indexOf(s1);
		if (idx < 0) {
			return sou;
		}
		return StringReplace(sou.substring(0, idx) + s2
				+ sou.substring(idx + s1.length()), s1, s2);
	}

	public static String replaceRange(String sentence, String oStart,
			String oEnd, String rWord, boolean matchCase) {
		int sIndex = -1;
		int eIndex = -1;
		if (matchCase) {
			sIndex = sentence.indexOf(oStart);
		} else {
			sIndex = sentence.toLowerCase().indexOf(oStart.toLowerCase());
		}
		if (sIndex == -1 || sentence == null || oStart == null || oEnd == null
				|| rWord == null) {
			return sentence;
		} else {
			if (matchCase) {
				eIndex = sentence.indexOf(oEnd, sIndex);
			} else {
				eIndex = sentence.toLowerCase().indexOf(oEnd.toLowerCase(),
						sIndex);
			}
			String newStr = null;
			if (eIndex > -1) {
				newStr = sentence.substring(0, sIndex) + rWord
						+ sentence.substring(eIndex + oEnd.length());
			} else {
				newStr = sentence.substring(0, sIndex) + rWord
						+ sentence.substring(sIndex + oStart.length());
			}
			return replaceRange(newStr, oStart, oEnd, rWord, matchCase);
		}
	}

	public static String getRandomPassword(int length) {
		String Characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String word = "";

		for (int j = 0; j < length; j++) {
			word = word
					+ Characters.charAt((int) (Math.random() * Characters
							.length()));
		}
		return word;
	}

	/** * start token */
	protected static final String START_TOKEN = "${";

	/** * end token */
	protected static final String END_TOKEN = "}";

	/***************************************************************************
	 * interpolate key names to handle ${key} stuff
	 */
	public static String fillValue2String(String base, Map<String,String> map) {
		return fillValue2String(base, "", map);
	}

	public static String fillValue2String(String base, String def, Map<String,String> map) {
		if (base == null) {
			return null;
		}

		int begin = -1;
		int end = -1;
		int prec = 0 - END_TOKEN.length();
		String variable = null;
		StringBuffer result = new StringBuffer();

		// FIXME: we should probably allow the escaping of the start token
		while (((begin = base.indexOf(START_TOKEN, prec + END_TOKEN.length())) > -1)
				&& ((end = base.indexOf(END_TOKEN, begin)) > -1)) {
			result.append(base.substring(prec + END_TOKEN.length(), begin));
			variable = base.substring(begin + START_TOKEN.length(), end);
			String value = null;
			try {
				value = (String) map.get(variable);
			} catch (Exception ex) {
			}
			if (value != null) {
				result.append(value);
			} else {
				// variable not defined - so put it back in the value
				// result.append(START_TOKEN).append(variable).append(END_TOKEN);
				result.append(def);
			}
			prec = end;
		}
		result.append(base.substring(prec + END_TOKEN.length(), base.length()));

		return result.toString();
	}

	public static String fillValue2String(String base, String def,
			String namespace, Map<String,String> map) {
		if (base == null) {
			return null;
		}

		int begin = -1;
		int end = -1;
		int prec = 0 - END_TOKEN.length();
		String variable = null;
		StringBuffer result = new StringBuffer();

		// FIXME: we should probably allow the escaping of the start token
		while (((begin = base.indexOf(START_TOKEN, prec + END_TOKEN.length())) > -1)
				&& ((end = base.indexOf(END_TOKEN, begin)) > -1)) {
			result.append(base.substring(prec + END_TOKEN.length(), begin));
			variable = base.substring(begin + START_TOKEN.length(), end);
			String value = null;
			try {
				value = (String) map.get(namespace + variable);
			} catch (Exception ex) {
			}
			if (value != null) {
				result.append(value);
			} else {
				// variable not defined - so put it back in the value
				// result.append(START_TOKEN).append(variable).append(END_TOKEN);
				result.append(def);
			}
			prec = end;
		}
		result.append(base.substring(prec + END_TOKEN.length(), base.length()));

		return result.toString();
	}

	// ////////////////////
	/**
	 * 判断包含是否全角字母
	 *
	 * @param userName
	 * @return
	 */
	public static boolean isSBC(String userName) {
		for (int i = 0; i < userName.length(); i++) {
			if ("Ａ，Ｂ，Ｃ，Ｄ，Ｅ，Ｆ，Ｇ，Ｈ，Ｉ，Ｊ，Ｋ，Ｌ，Ｍ，Ｎ，Ｏ，Ｐ，Ｑ，Ｒ，Ｓ，Ｔ，Ｕ，Ｖ，Ｗ，Ｘ，Ｙ，Ｚ"
					.indexOf(userName.charAt(i)) != -1) {
				return true;
			}
		}
		return false;
	}

	

	/**
	 * 判断是否邮件
	 *
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		if (email == null || "".equals(email))
			return false;
		if (email.indexOf("@") == -1)
			return false;
		if (email.indexOf(".") == -1)
			return false;
		for (int i = 0; i < email.length(); i++) {
			if ("_qwertyuiopasdfghjklzxcvbnm@.0123456789".indexOf(String
					.valueOf(email.charAt(i))) == -1) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 得到星座信息
	 *
	 * @param month
	 * @return
	 */
	public static String getStar12(String month) {
		if (month.equals("1")) {
			return "山羊座";
		}
		if (month.equals("2")) {
			return "水瓶座";
		}
		if (month.equals("3")) {
			return "双鱼座";
		}
		if (month.equals("4")) {
			return "牡羊座";
		}
		if (month.equals("5")) {
			return "金牛座";
		}
		if (month.equals("6")) {
			return "双子座";
		}
		if (month.equals("7")) {
			return "巨蟹座";
		}
		if (month.equals("8")) {
			return "狮子座";
		}
		if (month.equals("9")) {
			return "处女座";
		}
		if (month.equals("10")) {
			return "天秤座";
		}
		if (month.equals("11")) {
			return "天蝎座";
		}
		if (month.equals("12")) {
			return "射手座";
		}
		return "";
	}

	/**
	 * 根据生日取得星座
	 *
	 * @param birth
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String getStar(Date birth) {
		int month = birth.getMonth() + 1;
		int day = birth.getDate();
		switch (month) {
		case 1:
			if (day > 20) {// 水平1,21-2,19
				return "2";
			} else {// 魔蝎
				return "1";
			}
		case 2:
			if (day > 19) {// 双鱼2,20-3,20
				return "3";
			} else {// 水平
				return "2";
			}
		case 3:
			if (day > 20) {// 白羊3,21-4,20
				return "4";
			} else {// 双鱼
				return "3";
			}
		case 4:
			if (day > 20) {// 金牛4,21-5,21
				return "5";
			} else {// 白羊
				return "4";
			}
		case 5:
			if (day > 21) {// 双子5,22-6,21
				return "6";
			} else {// 金牛
				return "5";
			}
		case 6:
			if (day > 21) {// 巨蟹6,22-7,22
				return "7";
			} else {// 双子
				return "6";
			}
		case 7:
			if (day > 22) {// 狮子7,23-8,23
				return "8";
			} else {// 巨蟹
				return "7";
			}
		case 8:
			if (day > 23) {// 处女8,24-9,23
				return "9";
			} else {// 狮子
				return "8";
			}
		case 9:
			if (day > 23) {// 天平9,24-10,23
				return "10";
			} else {// 处女
				return "9";
			}
		case 10:
			if (day > 23) {// 天蝎10,24-11,22
				return "11";
			} else {// 天平
				return "10";
			}
		case 11:
			if (day > 22) {// 射手11,23-12,21
				return "12";
			} else {// 天蝎
				return "11";
			}
		case 12:
			if (day > 21) {// 摩羯12,22-1,20
				return "1";
			} else {// 射手
				return "12";
			}
		}
		return "";
	}

	/**
	 * 取得 number 位随机数
	 *
	 * @return
	 */
	public static String getRandomString(int number) {
		String[] allLetter = { "0", "1", "2", "3", "4", "5", "6", "7", "8",
				"9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
				"l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
				"x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I",
				"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
				"V", "W", "X", "Y", "Z" };
		Random random = new Random();
		String result = "";
		int rand = (int) (System.currentTimeMillis() % 100000);
		random.setSeed(rand);
		for (int i = 0; i < number; i++) {
			long tmp = random.nextInt(100000);
			int index = (int) (tmp % 62) >= 0 ? (int) (tmp % 62)
					: (int) (tmp % 62) + 62;
			result += allLetter[index];
		}
		return result;
	}

	/**
	 * 将字节转化为16 进制 字符串
	 *
	 * @param ib
	 * @return
	 */
	public static String byteHex(byte ib) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };
		char[] ob = new char[2];
		ob[0] = Digit[(ib >>> 4) & 0X0F];
		ob[1] = Digit[ib & 0X0F];
		String s = new String(ob);
		return s;
	}

	/**
	 * 移动为1，连通2，其他为3
	 *
	 * @param mobile
	 * @return
	 */
	public static int getMobileType(String mobile) {
		if (mobile == null || mobile.equals("")) {
			return 3;
		}
		if (mobile.indexOf("130") == 0 || mobile.indexOf("131") == 0
				|| mobile.indexOf("132") == 0 || mobile.indexOf("133") == 0
				|| mobile.indexOf("134") == 0) {
			return 2;
		} else if (mobile.indexOf("135") == 0 || mobile.indexOf("136") == 0
				|| mobile.indexOf("137") == 0 || mobile.indexOf("138") == 0
				|| mobile.indexOf("139") == 0) {
			return 1;
		}
		return 3;
	}

	/**
	 * ip转换为LONG
	 *
	 * @param ip
	 * @return
	 */
	public static long ipToInt(String ip) {
		StringTokenizer st = new StringTokenizer(ip, ".");
		long numParts = st.countTokens();
		if (numParts == 0)
			throw new IllegalArgumentException(
					"Invalid IP address: empty argument");
		if (numParts > 4)
			throw new IllegalArgumentException(
					"Invalid IP address: too many tokens");
		long ipInt = 0;
		while (st.hasMoreTokens()) {
			long tokenVal = DataUtil.parseInt(st.nextToken());
			ipInt = (ipInt << 8) + tokenVal;
		}
		return ipInt;
	}

	/**
	 * 得到随即字符串，长度4
	 *
	 * @return
	 */
	public static String getRandomString() {
		String[] allLetter = { "0", "1", "2", "3", "4", "5", "6", "7", "8",
				"9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
				"l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
				"x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I",
				"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
				"V", "W", "X", "Y", "Z" };
		Random random = new Random();
		String result = "";
		int rands = (int) (System.currentTimeMillis() % 100000);
		random.setSeed(rands);
		for (int i = 0; i < 4; i++) {
			long tmp = random.nextInt(100000);
			int index = (int) (tmp % 62) >= 0 ? (int) (tmp % 62)
					: (int) (tmp % 62) + 62;
			result += allLetter[index];
		}
		return result;
	}

	/**
	 * 是否包含中文字符
	 *
	 * @param password
	 * @return
	 */
	public static boolean includeChinese(String password) {
		if (password.length() < password.getBytes().length) {
			return true;
		}
		return false;
	}

	/**
	 * 是否包含大写字母
	 *
	 * @param password
	 * @return
	 */
	public static boolean includeBIG(String password) {
		for (int i = 0; i < password.length(); i++) {
			if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(password.charAt(i)) != -1) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 是否包含小写字母
	 *
	 * @param password
	 * @return
	 */
	public static boolean includeSmall(String password) {
		for (int i = 0; i < password.length(); i++) {
			if ("abcdefghijklmnopqrstuvwxyz".indexOf(password.charAt(i)) != -1) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 是否包含数字
	 *
	 * @param password
	 * @return
	 */
	public static boolean includeDigital(String password) {
		for (int i = 0; i < password.length(); i++) {
			if ("0123456789".indexOf(password.charAt(i)) != -1) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 是否包含其他字符
	 *
	 * @param password
	 * @return
	 */
	public static boolean includeOther(String password) {
		for (int i = 0; i < password.length(); i++) {
			if ("%$#@!^&*()'\"?/\\.,`~-_+".indexOf(password.charAt(i)) != -1) {
				return true;
			}
		}
		return false;
	}

	public static String ISO2GBK(String s) throws UnsupportedEncodingException {
		return new String(s.getBytes("ISO-8859-1"), "GBK");
	}

	public static String GBK2ISO(String s) throws UnsupportedEncodingException {
		return new String(s.getBytes("GBK"), "ISO-8859-1");
	}

	public static String replaceChar(String s, char c, char c1) {
		if (s == null)
			return "";
		else
			return s.replace(c, c1);
	}

	public static String replaceString(String s, String s1, String s2) {
		if (s == null || s1 == null || s2 == null)
			return "";
		else
			return s.replaceAll(s1, s2);
	}

	// split string
	public static String[] split(String s, String s1) {
		if (s == null || s.equals(""))
			return new String[0];
		else
			return s.split(s1);
	}

	

	public static String toQuoteMark(String s) {
		s = replaceString(s, "'", "&#39;");
		s = replaceString(s, "\"", "&#34;");
		s = replace(s, "\\", "&#92;");
		s = replaceString(s, "\r\n", "\n");
		return s;
	}

	public static String toHtml(String s) {
		s = replaceString(s, "<", "&#60;");
		s = replaceString(s, ">", "&#62;");
		return s;
	}

	public static String toBR(String s) {
		s = replaceString(s, "\n", "<br>\n");
		s = replaceString(s, "\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
		s = replaceString(s, "  ", "&nbsp;&nbsp;");
		return s;
	}

	public static String toSQL(String s) {
		s = replaceString(s, "\r\n", "\n");
		return s;
	}

	public static String replaceEnter(String s) throws NullPointerException {
		return s.replaceAll("\n", "<br>");
	}

	public static String replacebr(String s) throws NullPointerException {
		return s.replaceAll("<br>", "\n");
	}

	public static String replaceQuote(String s) throws NullPointerException {
		return s.replaceAll("'", "''");
	}
	
	
	/**
	 * 是否为空 是则返回一个空字符
	 * 
	 * @param str
	 * @return String
	 */
	public static String notNull(String str) {
		return str == null ? "" : str;
	}
	
	/**
	 * 是否为空 是则返回参数2
	 * 
	 * @param str
	 *            str1
	 * @return String
	 */
	public static String notNull(String str, String str1) {
		return (str == null || "".equals(str)) ? str1 : str;
	}
	
	/**
	 * 是否为空指针
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isNull(String str) {
		return str == null ? true : false;
	}
		
	

	
	/**
	 * Escape 编码
	 * 
	 * @param src
	 * @return
	 */
	public static String escape(String src) {
		int i;
		char j;
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length() * 6);
		for (i = 0; i < src.length(); i++) {
			j = src.charAt(i);
			if (Character.isDigit(j) || Character.isLowerCase(j) || Character.isUpperCase(j)) tmp.append(j);
			else if (j < 256) {
				tmp.append("%");
				if (j < 16) tmp.append("0");
				tmp.append(Integer.toString(j, 16));
			} else {
				tmp.append("%u");
				tmp.append(Integer.toString(j, 16));
			}
		}
		return tmp.toString();
	}
	
	//------------------------------------------------------------

	/**
	 * 将指定位置的字符转换为小写
	 * 
	 * @param str
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	public static String lowerCase(String str, int beginIndex, int endIndex) {
		StringBuilder builder = new StringBuilder();
		builder.append(str.substring(0, beginIndex));
		builder.append(str.substring(beginIndex, endIndex).toLowerCase());
		builder.append(str.substring(endIndex));
		return builder.toString();
	}

	/**
	 * 将指定位置的字符转换为大写
	 * 
	 * @param str
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	public static String upperCase(String str, int beginIndex, int endIndex) {
		StringBuilder builder = new StringBuilder();
		builder.append(str.substring(0, beginIndex));
		builder.append(str.substring(beginIndex, endIndex).toUpperCase());
		builder.append(str.substring(endIndex));
		return builder.toString();
	}

	/**
	 * 将首字母转换为小写
	 * 
	 * @param iString
	 * @return
	 */
	public static String lowerCaseFirstChar(String iString) {
		StringBuilder builder = new StringBuilder();
		builder.append(iString.substring(0, 1).toLowerCase());
		builder.append(iString.substring(1));
		return builder.toString();
	}

	/**
	 * 将首字母转换为大写
	 * 
	 * @param iString
	 * @return
	 */
	public static String upperCaseFirstChar(String iString) {
		StringBuilder builder = new StringBuilder();
		builder.append(iString.substring(0, 1).toUpperCase());
		builder.append(iString.substring(1));
		return builder.toString();
	}

	/**
	 * 检查子符串出现过几次
	 * 
	 * @param str
	 *            源字符串
	 * @param subStr
	 *            子字符串
	 * @return
	 */
	public static int timesOf(String str, String subStr) {
		int foundCount = 0;
		if (subStr.equals("")) {
			return 0;
		}
		int fromIndex = str.indexOf(subStr);
		while (fromIndex != -1) {
			++foundCount;
			fromIndex = str.indexOf(subStr, fromIndex + subStr.length());
		}
		return foundCount;
	}

	/**
	 * 去除两边空格（包括全角空格）, null 值以空字符代替
	 * 
	 * @param s
	 * @return
	 */
	public static String trim(String s) {
		if (s == null)
			return "";
		else
			return s.trim();
	}

	/**
	 * 去除右边的空格
	 * 
	 * @param str
	 * @return
	 */
	public static String rightTrim(String str) {
		if (str == null) {
			return "";
		}
		int length = str.length();
		for (int i = length - 1; i >= 0; --i) {
			if (str.charAt(i) != ' ') {
				break;
			}
			--length;
		}
		return str.substring(0, length);
	}

	/**
	 * 去除左边的空格
	 * 
	 * @param str
	 * @return
	 */
	public static String leftTrim(String str) {
		if (str == null) {
			return "";
		}
		int start = 0;
		int i = 0;
		for (int n = str.length(); i < n; ++i) {
			if (str.charAt(i) != ' ') {
				break;
			}
			++start;
		}
		return str.substring(start);
	}

	

	/**
	 * 将形如 key1=value1,key2=value2 的字符串，转换为Map
	 * 
	 * @param str
	 * @param splitString
	 * @return
	 */
	public static Map<String, String> toMap(String str, String splitString) {
		return strToMap(str,splitString,"=");
	}

	/**
	 * Json字符串转换为Map
	 * 
	 * @param jsonStr
	 * @param splitStr
	 * @return
	 */
	public static Map<String, String> jsonToMap(String jsonStr, String splitStr) {
		jsonStr = jsonStr.startsWith("{") ? jsonStr.substring(1) : jsonStr;
		jsonStr = jsonStr.endsWith("}") ? jsonStr.substring(0,
				jsonStr.length() - 1) : jsonStr;
		return strToMap(jsonStr,splitStr,":");
	}
	
	/**
	 * 将字符串拆分成Map "str1=1,str2=abc,..."
	 * @param str 待拆分字符串
	 * @param splitStr	拆分字符 ","
	 * @param linkStr 连接字符 "="
	 * @return
	 */
	public static Map<String, String> strToMap(String str,String splitStr,String linkStr){
		Map<String, String> map = Collections.synchronizedSortedMap(new TreeMap<String, String>());
		String[] values = split(str, splitStr);
		for (int i = 0; i < values.length; ++i) {
			String tempValue = values[i];
			int pos = tempValue.indexOf(linkStr);
			String key = "", value = "";
			if (pos > -1) {
				key = tempValue.substring(0, pos);
				value = tempValue.substring(pos + splitStr.length());
			} else {
				key = tempValue;
			}
			map.put(key.replace("\"", ""), value.replace("\"", ""));
		}
		return map;
	}
	
	public static String iso2gbk(String s) {
		if (s == null)
			return "";
		try {
			return new String(s.getBytes("ISO-8859-1"), "GBK").trim();
		} catch (Exception e) {
			return s;
		}
	}

	public static String gbk2iso(String s) {
		if (s == null)
			return "";
		try {
			return new String(s.getBytes("GBK"), "ISO-8859-1").trim();
		} catch (Exception e) {
			return s;
		}
	}

	public static String utf2iso(String s) {
		if (s == null)
			return "";
		try {
			return new String(s.getBytes(), "UTF-8").trim();
		} catch (Exception e) {
			return s;
		}
	}

	

	/**
	 * Escape SQL tags, ' to ''; \ to \\
	 * 
	 * @param input
	 *            string to replace
	 * @return string
	 */
	public static String escapeSQLTags(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		StringBuffer buf = new StringBuffer();
		char ch = ' ';
		for (int i = 0; i < input.length(); i++) {
			ch = input.charAt(i);
			if (ch == '\\') {
				buf.append("\\");
			} else if (ch == '\'') {
				buf.append("\'");
			} else {
				buf.append(ch);
			}
		}
		return buf.toString();
	}

	

	/**
	 * 将指定字符转换为 Unicode 编码
	 * 
	 * @param str
	 * @return
	 */
	public static String native2ascii(String str) {
		char[] ca = str.toCharArray();
		StringBuffer buffer = new StringBuffer(ca.length * 6);
		for (int x = 0; x < ca.length; ++x) {
			char a = ca[x];
			if (a > 255)
				buffer.append("\\u").append(Integer.toHexString(a));
			else {
				buffer.append(a);
			}
		}
		return buffer.toString();
	}

	/**
	 * 将指定长度的字符串用指定字符代替
	 * 
	 * @param str
	 * @param len
	 * @param showStr
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getPartString(String str, int len, String showStr)
			throws UnsupportedEncodingException {
		byte b[];
		int counterOfDoubleByte = 0;
		b = str.getBytes("UTF-8");
		if (b.length <= len)
			return str;
		for (int i = 0; i < len; i++) {
			if (b[i] < 0)
				counterOfDoubleByte++;
		}
		if (counterOfDoubleByte % 2 == 0)
			return new String(b, 0, len, "UTF-8") + showStr;
		else
			return new String(b, 0, len - 1, "UTF-8") + showStr;
	}

	/**
	 * 将指定的字符进行分页
	 * 
	 * @param pageIndex
	 *            当前页索引,从 1 开始
	 * @param pageSize
	 *            规定每页固定输出的字符总长度
	 * @return
	 */
	public static String pagination(String text, int pageIndex, int pageSize) {
		if (isEmpty(text))
			return text;
		return pagination(text, pageIndex, pageSize, text.length());
	}

	/**
	 * 将指定的字符进行分页
	 * 
	 * @param pageIndex
	 *            当前页索引,从 1 开始
	 * @param pageSize
	 *            规定每页固定输出的字符总长度
	 * @param lineLength
	 *            规定每行显示多少个字符,这个变量用于控制显示效果
	 * @return
	 */
	public static String pagination(String text, int pageIndex, int pageSize,
			int lineLength) {
		if (isEmpty(text))
			return text;
		StringBuffer sb = new StringBuffer();
		// 计算总页数
		Integer totalPage = ((text.length() % pageSize == 0) ? text.length()
				/ pageSize : (text.length() / pageSize + 1));
		if (pageIndex > totalPage) {
			return sb.append("页码无效").toString();
		}
		String result = text.toString()
				.substring(
						(pageIndex - 1) * pageSize,
						(((pageIndex - 1) * pageSize + pageSize) >= text
								.length() - 1) ? text.length()
								: ((pageIndex - 1) * pageSize + pageSize));

		char[] chars = result.toCharArray();
		int length = lineLength;
		for (int i = 0; i < chars.length; i++) {
			if (length == 0) {
				length = lineLength;
				sb.append("\n");
			}
			length--;
			sb.append(chars[i]);
		}
		return sb.toString();
	}

	/**
	 * 返回字符串Byte数组长度. <br>
	 * <br>
	 * <b>示例: </b> <br>
	 * StringUtils.getBytesLength(&quot;魅族官网&quot;) 返回值： 6
	 * StringUtils.getBytesLength(&quot;meizu.com&quot;) 返回值：12
	 * StringUtils.getBytesLength(&quot;&quot;) 返回值： 0
	 * StringUtils.getBytesLength(null) 返回值： -1
	 * 
	 * @param str
	 *            中文字符串或者英文字符串，或者null
	 * @return 返回字符串byte数组长度，如果是空字符串则返回0，如果是null则返回-1.
	 */
	public static int getBytesLength(String str) {
		if (str == null) {
			return -1;
		}
		return str.getBytes().length;
	}

	/**
	 * 字符串查找，根据条件字符串在目标字符串中匹配，返回匹配索引 <br>
	 * <br>
	 * <b>示例 </b> <br>
	 * StringUtils.indexOf(&quot;Tom's name is Tom&quot;,
	 * &quot;tom&quot;,0,true) 返回值： -1<br>
	 * StringUtils.indexOf(&quot;Tom's name is Tom&quot;,
	 * &quot;Tom&quot;,0,true) 返回值： 0 <br>
	 * StringUtils.indexOf(&quot;Tom's name is Tom&quot;,
	 * &quot;Tom&quot;,2,true) 返回值： 14 <br>
	 * 
	 * @param str
	 *            目标字符串，不能为null
	 * @param subStr
	 *            匹配条件字符串，不能为null
	 * @param fromIndex
	 *            开始索引
	 * @param caseSensitive
	 *            是否字母大小写匹配，true：区分；false：不区分
	 * @return 返回从fromIndex索引位置开始的查询子字符串在目标字符串中的索引值，如果没有匹配项则返回-1.
	 */
	public static int indexOf(String str, String subStr, int fromIndex,
			boolean caseSensitive) {
		if (caseSensitive == false) {
			return str.toLowerCase().indexOf(subStr.toLowerCase(), fromIndex);
		}
		return str.indexOf(subStr, fromIndex);
	}

	/**
	 * 字符换替换。把字符串str中searchStr字符串替换成replaceStr字符串. <br>
	 * <br>
	 * <b>示例： </b> <br>
	 * StringUtils.replace(&quot;Tom's name is
	 * Tom&quot;,&quot;Tom&quot;,&quot;Peter&quot;,true) 返回值： &quot;Peter's name
	 * is Peter&quot; <br>
	 * StringUtils.replace(&quot;Tom's name is
	 * Tom&quot;,&quot;tom&quot;,&quot;Peter&quot;,true) 返回值：&quot;Tom's name is
	 * Tom&quot; <br>
	 * StringUtils.replace(&quot;Tom's name is
	 * Tom&quot;,&quot;tom&quot;,&quot;Peter&quot;,false) 返回值：&quot;Peter's name
	 * is Peter&quot; <br>
	 * 
	 * @param str
	 *            目标字符串，不能为null
	 * @param searchStr
	 *            查询字符换，不能为null
	 * @param replaceStr
	 *            替换字符串
	 * @param caseSensitive
	 *            是否字母大小写匹配，true：区分；false：不区分
	 * @return 返回替换后的字符串
	 */
	public static String replace(String str, String searchStr,
			String replaceStr, boolean caseSensitive) {
		String result = "";
		int i = 0;
		int j = 0;
		if (str == null) {
			return null;
		}
		if (str.equals("")) {
			return "";
		}
		if (searchStr == null || searchStr.equals("")) {
			return str;
		}
		if (replaceStr == null) {
			replaceStr = "";
		}
		while ((j = indexOf(str, searchStr, i, caseSensitive)) > -1) {
			result = result + str.substring(i, j) + replaceStr;
			i = j + searchStr.length();
		}
		result = result + str.substring(i, str.length());
		return result;
	}

	/**
	 * * 判断一个对象是否非空
	 *
	 * @param object Object
	 * @return true：非空 false：空
	 */
	public static boolean isNotNull(Object object)
	{
		return !isNull(object);
	}

	/**
	 * * 判断一个对象是否为空
	 *
	 * @param object Object
	 * @return true：为空 false：非空
	 */
	public static boolean isNull(Object object)
	{
		return object == null;
	}

	

	/**
	 * 字符替换，根据规则把searchChar替换后返回newStr.<br>
	 * <br>
	 * <b>示例： </b> <br>
	 * StringUtils.replace(null, *, *) = null <br>
	 * StringUtils.replace(&quot;&quot;, *, *) = &quot;&quot; <br>
	 * StringUtils.replace(&quot;aba&quot;, null, null) = &quot;aba&quot; <br>
	 * StringUtils.replace(&quot;aba&quot;, null, null) = &quot;aba&quot; <br>
	 * StringUtils.replace(&quot;aba&quot;, &quot;a&quot;, null) =
	 * &quot;aba&quot; <br>
	 * StringUtils.replace(&quot;aba&quot;, &quot;a&quot;, &quot;&quot;) =
	 * &quot;b&quot; <br>
	 * StringUtils.replace(&quot;aba&quot;, &quot;a&quot;, &quot;z&quot;) =
	 * &quot;zbz&quot; <br>
	 * 
	 * @param str
	 *            目标字符串，如果为null则返回null
	 * @param searchStr
	 *            匹配字符串，如果为null则不匹配任何值
	 * @param replaceStr
	 *            替换字符串，如果为null则不替换任何字符串
	 * @return 返回全部替换后的字符串
	 */
	public static String replace(String str, char searchChar, String replaceStr) {
		return replace(str, searchChar + "", replaceStr, true);
	}

	/**
	 * 替换字符串，从索引位置开始. <br>
	 * <br>
	 * <b>示例 </b> <br>
	 * StringTools.replace(&quot;abcde f g&quot;,1,&quot;xx&quot;) 返回值：
	 * &quot;axxde f g&quot;
	 * 
	 * @param str
	 *            目标字符串，不能为null
	 * @param beginIndex
	 *            开始替换索引位置
	 * @param replaceStr
	 *            替换字符串，不能为null
	 * @return 返回字符串
	 */
	public static String replace(String str, int beginIndex, String replaceStr) {
		String result = null;
		if (str == null) {
			return null;
		}
		if (replaceStr == null) {
			replaceStr = "";
		}
		result = str.substring(0, beginIndex) + replaceStr
				+ str.substring(beginIndex + replaceStr.length());
		return result;
	}

	/**
	 * 去除字符串中所有空格. <br>
	 * <br>
	 * <b>示例： </b> <br>
	 * StringUtils.absoluteTrim(&quot; ab cd e &quot;) 返回结果为： &quot;abcde&quot;
	 * 
	 * @param str
	 *            带空格的字符串参数
	 * @return 不带空格的字符串
	 */
	public static String absoluteTrim(String str) {
		String result = replace(str, " ", "");
		return result;
	}

	/**
	 * 英文数字排序
	 * 
	 * @param map
	 * @return Map
	 */
	public static Map<String, String> sortEnglishNumberWord(
			Map<String, String> map) {
		Map<String, String> resultMap = new LinkedHashMap<String, String>(0);
		Map<Integer, String> tempMap = new LinkedHashMap<Integer, String>(0);

		Set<String> keys = map.keySet();

		int s = Integer.MAX_VALUE;
		for (String key : keys) {
			if (key.indexOf("One") > -1) {
				tempMap.put(1, key);
			} else if (key.indexOf("Two") > -1) {
				tempMap.put(2, key);
			} else if (key.indexOf("Three") > -1) {
				tempMap.put(3, key);
			} else if (key.indexOf("Four") > -1) {
				tempMap.put(4, key);
			} else if (key.indexOf("Five") > -1) {
				tempMap.put(5, key);
			} else if (key.indexOf("Six") > -1) {
				tempMap.put(6, key);
			} else if (key.indexOf("Seven") > -1) {
				tempMap.put(7, key);
			} else if (key.indexOf("Eight") > -1) {
				tempMap.put(8, key);
			} else if (key.indexOf("Nine") > -1) {
				tempMap.put(9, key);
			} else {
				tempMap.put(s, key);
			}
			s--;
		}

		Set<Integer> keyNum = tempMap.keySet();
		Object[] num_obj = keyNum.toArray();
		Integer[] nums = new Integer[num_obj.length];
		Integer tempInt = 0;
		for (int i = 0; i < num_obj.length; i++) {
			nums[i] = new Integer(num_obj[i].toString());
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					tempInt = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = tempInt;
				}
			}
		}

		for (Integer num : nums) {
			resultMap.put(tempMap.get(num), map.get(tempMap.get(num)));
		}
		return resultMap;
	}

	

	

	/**
	 * 以regex字符为分割符将list拼接成字符串
	 * 
	 * @param list
	 * @param regex
	 * @return
	 */
	public static String ListToStr(List<String> list, String regex) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
			if (i < list.size() - 1)
				sb.append(regex);
		}
		return sb.toString();
	}

	/**
	 * 以regex字符为分割符将list拼接成字符串
	 * 
	 * @param list
	 * @param regex
	 * @return
	 */
	public static String ArrToStr(Object[] strArr, String regex) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strArr.length; i++) {
			sb.append(strArr[i]);
			if (i < strArr.length - 1)
				sb.append(regex);
		}
		return sb.toString();
	}

	/**
	 * 数组转换成List
	 * 
	 * @param objArr
	 * @return
	 */
	public static List<String> arrToList(String[] strArr) {
		List<String> strList = new ArrayList<String>();
		for (String string : strArr) {
			strList.add(string);
		}
		return strList;
	}

	/**
	 * 字符编码
	 * 
	 * @param str
	 * @param enc
	 *            字符类型 “UTF-8”
	 * @return
	 */
	public static String encode(String str, String enc) {
		String enstr = "";
		if (str == null || str.equals(""))
			return enstr;
		try {
			enstr = URLEncoder.encode(str, enc);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		return enstr;
	}

	/**
	 * 字符解码
	 * 
	 * @param str
	 * @param enc
	 *            字符类型 “UTF-8”
	 * @return
	 */
	public static String decode(String str, String enc) {
		String enstr = "";
		if (str == null || str.equals(""))
			return enstr;
		try {
			enstr = URLDecoder.decode(str, enc);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		return enstr;
	}

	/**
	 * 下划线转驼峰命名
	 */
	public static String toUnderScoreCase(String str)
	{
		if (str == null)
		{
			return null;
		}
		StringBuilder sb = new StringBuilder();
		// 前置字符是否大写
		boolean preCharIsUpperCase = true;
		// 当前字符是否大写
		boolean curreCharIsUpperCase = true;
		// 下一字符是否大写
		boolean nexteCharIsUpperCase = true;
		for (int i = 0; i < str.length(); i++)
		{
			char c = str.charAt(i);
			if (i > 0)
			{
				preCharIsUpperCase = Character.isUpperCase(str.charAt(i - 1));
			}
			else
			{
				preCharIsUpperCase = false;
			}

			curreCharIsUpperCase = Character.isUpperCase(c);

			if (i < (str.length() - 1))
			{
				nexteCharIsUpperCase = Character.isUpperCase(str.charAt(i + 1));
			}

			if (preCharIsUpperCase && curreCharIsUpperCase && !nexteCharIsUpperCase)
			{
				sb.append(SEPARATOR);
			}
			else if ((i != 0 && !preCharIsUpperCase) && curreCharIsUpperCase)
			{
				sb.append(SEPARATOR);
			}
			sb.append(Character.toLowerCase(c));
		}

		return sb.toString();
	}

	/**
	 * 是否包含字符串
	 *
	 * @param str 验证字符串
	 * @param strs 字符串组
	 * @return 包含返回true
	 */
	public static boolean inStringIgnoreCase(String str, String... strs)
	{
		if (str != null && strs != null)
		{
			for (String s : strs)
			{
				if (str.equalsIgnoreCase(trim(s)))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	
	
}
