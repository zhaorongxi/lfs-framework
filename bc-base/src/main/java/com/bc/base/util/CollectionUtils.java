package com.bc.base.util;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * <p><b>Title:</b><i> 集合工具类</i></p>
 * <p>Desc: TODO</p>
 * <p>source folder:{@docRoot}</p>
 * <p>Copyright:Copyright(c)2018</p>
 * <p>Company:vanke</p>
 * <p>Create Date:2018年7月23日 上午9:09:33</p>
 * <p>Modified By:wanglz08-</p>
 * <p>Modified Date:2018年7月23日 上午9:09:33</p>
 * @author <a href="mailto:wanglz08@vanke.com title="邮箱地址">wanglz08</a>
 * @version Version 0.1
 *
 */
public abstract class CollectionUtils {
	/**
	 * 判断指定的集合是否为空。
	 * 
	 * @param collection
	 *            待判断的集合
	 * @return 返回指定的集合是否为空。
	 */
	public static Boolean isEmpty(Collection<?> collection) {
		return (collection == null || collection.isEmpty());
	}

	/**
	 * 判断指定的集合是否不为空。
	 * 
	 * @param collection
	 *            待判断的集合
	 * @return 返回指定的集合是否不为空。
	 */
	public static Boolean isNotEmpty(Collection<?> collection) {
		return !isEmpty(collection);
	}

	/**
	 * 判断指定的数组是否为空。
	 * 
	 * @param array
	 *            待判断的数组
	 * @return 返回指定的数组是否为空。
	 */
	public static Boolean isEmpty(Object[] array) {
		return (array == null || array.length == 0);
	}

	/**
	 * 判断指定的数组是否不为空。
	 * 
	 * @param array
	 *            待判断的数组
	 * @return 返回指定的数组是否不为空。
	 */
	public static Boolean isNotEmpty(Object[] array) {
		return !isEmpty(array);
	}

	/**
	 * 判断指定的Map是否为空。
	 * 
	 * @param map
	 *            待判断的Map
	 * @return 返回指定的Map是否为空。
	 */
	public static Boolean isEmpty(Map<?, ?> map) {
		return (map == null || map.isEmpty());
	}

	/**
	 * 判断指定的Map是否不为空。
	 * 
	 * @param map
	 *            待判断的Map
	 * @return 返回指定的Map是否不为空。
	 */
	public static Boolean isNotEmpty(Map<?, ?> map) {
		return !isEmpty(map);
	}

	/**
	 * 移除List中重复的元素。
	 * 
	 * @param <T>
	 *            元素类型
	 * 
	 * @param list
	 *            列表
	 */
	public static <T> void removeDuplicate(List<T> list) {
		HashSet<T> set = new HashSet<T>(list);
		list.clear();
		list.addAll(set);
	}

	/**
	 * 判断数组中是否包含指定元素。
	 * 
	 * @param <T>
	 *            数组类型
	 * @param elements
	 *            数组
	 * @param elementToFind
	 *            待查找的元素
	 * @return 如果数组中包含指定元素返回true，否则返回false。
	 */
	public static <T> Boolean contains(T[] elements, T elementToFind) {
		List<T> elementsList = Arrays.asList(elements);
		return elementsList.contains(elementToFind);
	}

	/**
	 * 复制集合。
	 * 
	 * @param <T>
	 *            集合元素类型
	 * @param source
	 *            源集合
	 * @param target
	 *            目标集合
	 */
	public static <T> void copy(Collection<T> source, Collection<T> target) {
		Assert.isTrue(source != null, "源集合不能为空。");
		Assert.isTrue(source != null, "目标集合不能为空。");
		target.clear();
		if (!source.isEmpty()) {
			for (T o : source) {
				target.add(o);
			}
		}
	}

	/**
	 * 根据键对Map进行排序。
	 * 
	 * @param <K>
	 *            键类型
	 * @param <V>
	 *            值类型
	 * @param map
	 *            Map
	 * @param asc
	 *            是否升序
	 * @return 返回排序后的Map。
	 */
	public static <K, V> Map<K, V> sortMapByKey(Map<K, V> map, final Boolean asc) {
		List<Entry<K, V>> entries = new LinkedList<Entry<K, V>>(map.entrySet());
		Collections.sort(entries, new Comparator<Entry<K, V>>() {
			@SuppressWarnings("unchecked")
			public int compare(Entry<K, V> o1, Entry<K, V> o2) {
				if (asc) {
					return ((Comparable<K>) o1.getKey()).compareTo(o2.getKey());
				} else {
					return -((Comparable<K>) o1.getKey()).compareTo(o2.getKey());
				}
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Entry<K, V> entry : entries) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	/**
	 * 根据值对Map进行排序。
	 * 
	 * @param <K>
	 *            键类型
	 * @param <V>
	 *            值类型
	 * @param map
	 *            Map
	 * @param asc
	 *            是否升序
	 * @return 返回排序后的Map。
	 */
	public static <K, V> Map<K, V> sortMapByValue(Map<K, V> map,
			final Boolean asc) {
		List<Entry<K, V>> entries = new LinkedList<Entry<K, V>>(map.entrySet());
		Collections.sort(entries, new Comparator<Entry<K, V>>() {
			@SuppressWarnings("unchecked")
			public int compare(Entry<K, V> o1, Entry<K, V> o2) {
				if (asc) {
					return ((Comparable<V>) o1.getValue()).compareTo(o2
							.getValue());
				} else {
					return -((Comparable<V>) o1.getValue()).compareTo(o2
							.getValue());
				}
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Entry<K, V> entry : entries) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
	

    //-----------------------


    	/**
    	 * 清空集合中空元素
    	 *
    	 * @param list    
    	 * @throws
    	 */
    	public static void removeEmpty(List list){
    		if(null != list){
    			for (Iterator it = list.iterator();it.hasNext();){
    				Object obj = it.next();   
    				if (null == obj){   
    					it.remove();
    				}   
    			}   
    		}
    	}
    	
    	/**
    	 * 去除重复元素 
    	 *
    	 * @param args
    	 * @return    
    	 * @throws
    	 */
    	public static List removeRepeat(List args){
    		List<String> result = new ArrayList<String>();
    		Set set = new HashSet();
    		for (Object obj : args) {
    			set.add(obj);
    		}
    		result.addAll(set);
    		return result;
    	}
    	
    	/**
    	 *
    	 * 去除字符串数组中重复数据
    	 *
    	 * @param args
    	 * @return    
    	 * @throws
    	 */
    	public static String [] removeRepeat(String [] args){
    		Set<String> set = new HashSet<String>();
    		for (String string : args) {
    			set.add(string);
    		}
    		String [] result = new String [set.size()];
    		set.toArray(result);
    		return result;
    	}
    	
    	/**
    	 * 
    	 * @param types
    	 *            值
    	 * @param appendLeft
    	 *            在每个值的左边加上字符,例如单引号' 例如双引号" 例如百分号%
    	 * @param appendRight
    	 *            在每个值的右边加上字符,例如单引号' 例如双引号" 例如百分号%
    	 */
    	public static String splitRiskCode(List types, String appendLeft,
    			String appendRight) {
    		StringBuffer sb = new StringBuffer();
    		// String[] types = riskCode.split(",");
    		for (int i = 0; i < types.size(); i++) {
    			if (i > 0 && i < types.size()) {
    				sb.append(",");
    			}
    			sb.append(appendLeft + types.get(i).toString() + appendRight);
    		}
    		return sb.toString();
    	}

    	/**
    	 * 
    	 * 分页,将一个List按分页指定的分页大小拆分
    	 *
    	 *
    	 * <br/>作者： 谭勇德
    	 * 编写日期： Dec 15, 2011
    	 * 版本 V1.0
    	 * @param datas
    	 * @param pageSize
    	 * @return    
    	 * @throws
    	 */
    	public static List<List> splitList(List datas,int pageSize){
    		List result = new ArrayList();
    		if(!(null == datas || 0 == datas.size())){
    			if(0 != pageSize){
    				int pageNo = (datas.size() % pageSize == 0) ? datas.size() / pageSize : (datas.size() / pageSize) + 1;
    				for (int i = 1; i <= pageNo; i++) {
    					result.add(pagination(datas,i,pageSize));
    				}
    			}else{
    				result.add(new ArrayList().addAll(datas));
    			}
    		}
    		return result;
    	}
    	
    	/**
    	 * 
    	 *  分页,按页码和分页大小分页
    	 *
    	 * @param datas
    	 * @param pageNo
    	 * @param pageSize
    	 * @return    
    	 * @throws
    	 */
    	public static List pagination(List datas, int pageNo, int pageSize) {
    		List result = new ArrayList();
    		if (null != datas) {
    			int index = (pageNo * pageSize <= datas.size() ? pageNo * pageSize
    					: datas.size());

    			if (0 != datas.size()) {
    				// 在 内存中 进行分页
    				for (int j = (pageNo - 1) * pageSize; j < index; j++) {

    					result.add(datas.get(j));

    				}
    			}
    		}
    		return result;
    	}

}
