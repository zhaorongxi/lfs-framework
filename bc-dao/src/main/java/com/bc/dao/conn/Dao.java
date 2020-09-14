package com.bc.dao.conn;

import com.bc.base.util.DataUtil;
import com.bc.base.util.DateUtils;
import com.bc.base.util.SpringUtil;
import com.bc.base.util.StringUtils;
import com.bc.dao.beans.Pram;
import com.bc.dao.beans.WherePrams;
import com.bc.dao.entity.DaoEntity;
import com.bc.dao.enums.IsDelEnums;
import com.bc.dao.service.SystemService;
import com.bc.dao.sql.C;
import com.bc.dao.sql.SqlUtil;
import com.bc.dto.entity.UserInfoEntity;
import net.sf.cglib.beans.BeanMap;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.*;

/**
 * <p><b>Title:</b><i>TODO</i></p>
 * <p>Desc: TODO</p>
 * <p>Copyright:Copyright(c)2018</p >
 * <p>Create Date:2019/9/1 下午5:14</p >
 * <p>Modified By:linxi</p >
 * <p>Modified Date:2019/9/1 下午5:14</p >
 * @author linxi
 * @version Version 0.1
 */
//@Repository
public class Dao<T> implements IDao<T>,Serializable {

	private Class<T> entityClass;
	private SqlUtil<T> sqlUtil;
	private String tableName;

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	private SqlSessionTemplate sqlSessionTemplateASS;

	private SystemService systemService;

	private UserInfoEntity userDto;

	public Dao(){
		super();
        this.sqlSessionTemplateASS = (SqlSessionTemplate) SpringUtil.getApplicationContext().getBean("sqlSessionTemplate");
        this.systemService = (SystemService) SpringUtil.getApplicationContext().getBean("systemService");
        this.userDto = systemService.getCurrentUser();
        if (null == userDto){
            this.userDto = new UserInfoEntity();
            userDto.setId(0);
        }
	}

	/**
	 * 方法用途: 初始化Dao<br/>
	 * 操作步骤: TODO<br/>
	 * ${tags}
	 */
	public void initDao(Class<T> entity){
			this.sqlUtil = new SqlUtil<T>();
			this.entityClass = entity;
			this.tableName = this.sqlUtil.getTableName(this.entityClass);

    }

    /**
     * 方法用途: 保存有值的字段<br/>
     * 操作步骤: TODO<br/>
     * ${tags}
     */
	@Override
	public int saveBySelect(T ob)  throws Exception{
        List<T> list = new ArrayList<>();
        list.add(ob);
        return save(list,false);
	}

    /**
     * 方法用途: 保存所有字段<br/>
     * 操作步骤: TODO<br/>
     * ${tags}
     */
    @Override
    public int saveAll(T ob)  throws Exception{
        List<T> list = new ArrayList<>();
        list.add(ob);
        return save(list,true);
    }


	/**
     * 保存
	 * 方法用途: TODO<br/>
	 * 操作步骤: TODO<br/>
	 * ${tags}
	 */
	private int save(List<T> list, boolean isAllField) throws Exception{
            //获取用户信息
            String sql = "insert into " + tableName + " (";
            String prams = "";
            String values = "(";
            List<Pram> pramList;
            pramList = SqlUtil.getPramListofStatic(list.get(0));
            //封装params
            int index = 0;
            for (int i = 0; i < pramList.size(); i++) {
                boolean flag = true;
                if (!isAllField){
                    if (pramList.get(i).getValue() == null ) {
                        flag = false;
                    } else {
                        flag = true;
                    }
                }
                if (flag){
                    if(index > 0){
                        values += ",";
                        prams += ",";
                    }
                    prams += pramList.get(i).getFile();
                    values +="#{reddemCode."+pramList.get(i).getFile()+"}";
                    index ++;
                }
            }
            prams +=",creater_time,creater_id,update_time,update_id,is_del";
            values +=",'"+ DateUtils.dataTimeFormat.format(new Date())+"',"+userDto.getId()+",'"+DateUtils.dataTimeFormat.format(new Date())+"',"+userDto.getId()+","+ IsDelEnums.NORMAL.getCode() +")";
            //封装value
            List<Map> requestParamsList = new ArrayList<>();
            if (null !=list ){
                for (T t : list){
                    pramList = SqlUtil.getPramListofStatic(t);
                    //封装params
                    Map<String,Object> map = new HashMap<>();
                    for (int i = 0; i < pramList.size(); i++) {
                        boolean flag = true;
                        if (!isAllField){
                            if (pramList.get(i).getValue() == null) {
                                flag = false;
                            } else {
                                flag = true;
                            }
                        }
                        if (flag){
                            map.put(pramList.get(i).getFile(),pramList.get(i).getValue());
                        }
                    }
                    requestParamsList.add(map);
                }
            }
            //完善基础信息字段
            sql += prams + ") values ";
            logger.debug(sql);
            logger.debug(values);
            DaoEntity entity = new DaoEntity();
            entity.setParamsSql(sql);
            entity.setValueSql(values);
            entity.setRequestParams((Serializable) requestParamsList);
            sqlSessionTemplateASS.insert("save", entity);
            return entity.getId();
	}

	/**
	 * 方法用途: 批量保存<br/>
	 * 操作步骤: TODO<br/>
	 * ${tags}
	 */
	@Override
	public void saveList(List<T> list)  throws Exception{
		// TODO Auto-generated method stub
		if (null != list && list.size()>0){
		    save(list,false);
        }
	}

	/**
	 * 方法用途: TODO<br/>
	 * 操作步骤: TODO<br/>
	 * ${tags}
	 */
	@Override
	public Integer saveOrUpdate(T t)  throws Exception{
	    Object obj = sqlUtil.getValue(t,"id");
        if (null != obj ){
            //update
            updateById(t);
            return Integer.parseInt(obj.toString());
        }else{
            //save
            return saveBySelect(t);
        }
	}

	@Override
	public boolean saveOrUpdate(T t, Boolean isAllField) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer remove(String name, Object value) {

		return null;
	}

	@Override
	public Integer remove(Integer id) {
		// TODO Auto-generated method stub
        String sql = "update  " + tableName + " set  is_del ="+IsDelEnums.DELETED.getCode()+",update_id="+userDto.getId()+",update_time=now() "+" where id = #{id}";
        DaoEntity daoEntity = new DaoEntity();
        daoEntity.setParamsSql(sql);
        daoEntity.setId(id);
		return sqlSessionTemplateASS.update("update",daoEntity);
	}

    @Override
    public Integer delete(Integer id) {
        // TODO Auto-generated method stub
        String sql = "delete  from " + tableName +" where id = #{id}";
        DaoEntity daoEntity = new DaoEntity();
        daoEntity.setParamsSql(sql);
        daoEntity.setId(id);
        return sqlSessionTemplateASS.delete("delete",daoEntity);
    }

    @Override
	public Integer remove(List<Integer> ids) {
		// TODO Auto-generated method stub
        String sql = "update  " + tableName + " set  is_del ="+IsDelEnums.DELETED.getCode()+",update_id="+userDto.getId()+",update_time=now() where 1=1 ";
        WherePrams wherePrams = new WherePrams(this.entityClass);
        wherePrams.and("id",C.IN,(Serializable) ids);
        DaoEntity daoEntity = new DaoEntity();
        daoEntity.setRequestParams((Serializable) wherePrams.getValues());
        daoEntity.setParamsSql(sql+wherePrams.getWherePrams());
		return sqlSessionTemplateASS.update("update",daoEntity);
	}

    @Override
    public Integer delete(List<Integer> ids) {
        String sql = "delete  from " + tableName +" where 1=1 ";
        WherePrams wherePrams = new WherePrams(this.entityClass);
        wherePrams.and("id",C.IN,(Serializable) ids);
        DaoEntity daoEntity = new DaoEntity();
        daoEntity.setRequestParams((Serializable) wherePrams.getValues());
        daoEntity.setParamsSql(sql+wherePrams.getWherePrams());
        return sqlSessionTemplateASS.delete("delete",daoEntity);
    }

    @Override
	public Integer remove(Integer[] ids) {
		// TODO Auto-generated method stub
		return remove(Arrays.asList(ids));
	}

    @Override
    public Integer delete(Integer[] ids) {
        return delete(Arrays.asList(ids));
    }

    @Override
    public Integer remove(WherePrams wherePrams) {
        String sql = "update  " + tableName + " set  is_del ="+IsDelEnums.DELETED.getCode()+",update_id="+userDto.getId()+",update_time=now() ";
        DaoEntity daoEntity = new DaoEntity();
        daoEntity.setRequestParams((Serializable) wherePrams.getValues());
        daoEntity.setParamsSql(sql+" where 1=1 "+wherePrams.getWherePrams());
        return sqlSessionTemplateASS.update("update",daoEntity);
    }

    @Override
    public Integer delete(WherePrams wherePrams) {
        String sql = "delete  from " + tableName;
        DaoEntity daoEntity = new DaoEntity();
        daoEntity.setRequestParams((Serializable) wherePrams.getValues());
        daoEntity.setParamsSql(sql+" where 1=1 "+wherePrams.getWherePrams());
        return sqlSessionTemplateASS.delete("delete",daoEntity);
    }

    /**
     * 方法用途: 根据ID更新数据<br/>
     * 操作步骤: TODO<br/>
     * ${tags}
     */
	@Override
	public Integer updateById(T ob) {
        String sql = "update  " + tableName + " set ";
        String prams = "";
        Map<String,Object> requestPrams = new HashMap<>();
        List<Pram> pramList = SqlUtil.getPramListofStatic(ob);
        if (null != pramList && pramList.size()!=0) {
            int index = 0;
            for (int i = 0; i < pramList.size(); i++) {
                if (pramList.get(i).getValue() == null) {
                    continue;
                } else {
                    if (index > 0) {
                        prams += ",";
                    }
                    requestPrams.put(pramList.get(i).getFile(),pramList.get(i).getValue());
                    prams += pramList.get(i).getFile() + "= #{requestParams." + pramList.get(i).getFile()+"}";
                    index++;
                }
            }
            if (StringUtils.isNotEmpty(prams)) {
                prams += ",update_id = #{requestParams.userId},update_time=now() ";
            }
            requestPrams.put("userId",userDto.getId());
            sql += prams + " where id = #{id}";
            DaoEntity daoEntity = new DaoEntity();
            daoEntity.setParamsSql(sql);
            daoEntity.setId((Integer) sqlUtil.getValue(ob, "id"));
            daoEntity.setRequestParams((Serializable) requestPrams);
            logger.debug(sql);
            return sqlSessionTemplateASS.insert("update", daoEntity);
        }else {
            return null;
        }
	}

	@Override
	public void update(List<T> list) {
		// TODO Auto-generated method stub
		
	}



	/**
	 * 方法用途: 根据自增Id查询实体<br/>
	 * 操作步骤: TODO<br/>
	 * ${tags}
	 */
	@Override
	public T findById(Integer id)  throws Exception{
		// TODO Auto-generated method stub
		String sql = querySelect()+" and id = #{id}";
        this.logger.info(sql);
        DaoEntity daoEntity = new DaoEntity();
        daoEntity.setId(id);
        daoEntity.setParamsSql(sql);
        HashMap select = sqlSessionTemplateASS.selectOne("select", daoEntity);

        return (T) mapToBean(select,this.entityClass.newInstance());
	}

	/**
	 * 方法用途: 根据主键ID查找实体<br/>
	 * 操作步骤: TODO<br/>
	 * ${tags}
	 */
	@Override
	public List<T> findByIds(Integer[] idArr) throws Exception{
        String sql = querySelect();
        List<Integer> list = new ArrayList<>();
        for (int i =0 ;i<idArr.length;i++){
            list.add(idArr[i]);
        }
        WherePrams wherePrams = new WherePrams(this.entityClass);
        wherePrams.and("id", C.IN,(Serializable) list);
        sql+=wherePrams.getWherePrams();
        DaoEntity daoEntity = new DaoEntity();
        daoEntity.setParamsSql(sql);
        daoEntity.setRequestParams((Serializable) wherePrams.getValues());
        List<Map> returnList =  sqlSessionTemplateASS.selectList("select",daoEntity);
		return mapsToObjects(returnList,this.entityClass);
	}

	/**
	 * 方法用途: 根据主键ID查询实体支持拼接方式 - | , <br/>
	 * 操作步骤: TODO<br/>
	 * ${tags}
	 */
	@Override
	public List<T> findByIds(String ids) throws Exception {
		// TODO Auto-generated method stub
        if (StringUtils.isNotBlank(ids)){
            String[] list = new String[]{};
            if (ids.indexOf("|")>0){
                 list = ids.split("|");
            }else if(ids.indexOf("-")>0){
                list = ids.split("-");
            }else if (ids.indexOf(",")>0){
                list = ids.split(",");
            }
            if (null !=list && list.length!=0){
                //字符串数组转Integer数组
                Integer[] idAttr = new Integer[list.length];
                for (int i = 0 ;i<list.length;i++) {
                    try {
                        idAttr[i] = Integer.parseInt(list[i]);
                    }catch (Exception e){
                        e.printStackTrace();
                        return null;
                    }
                }
                return findByIds(idAttr);
            }else {
                try {
                    Integer id = DataUtil.getInteger(ids);
                    Integer[] idAttr = new Integer[1];
                    idAttr[0] = id;
                    return findByIds(idAttr);
                }catch (Exception e){
                    e.printStackTrace();
                    return null;
                }
            }
        }else {
            return null;
        }
	}

	@Override
	public List<T> findByMutil(String name, String values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findUnique(String name, boolean isMutilLineExcpetion, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findUnique(String name, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 方法用途: 查询所有<br/>
	 * 操作步骤: TODO<br/>
	 * ${tags}
	 */
	@Override
	public List<T> findAll() throws Exception{
		// TODO Auto-generated method stub
		return findWithParamEquals(null);
	}

    /**
     * 分页查询
     *
     * @param wherePrams

    @Override
    public PageBean<T> findPageByPrem(PageInfo<T> pageInfo,WherePrams wherePrams) throws Exception {
        //统计总条数
        Integer count = countUnlimit(wherePrams);
        //查询当前页数据
        List<T> byParm = findByParm(wherePrams);
        //计算总页数

        return null;
    }
     */

    /**
	 * 方法用途: TODO<br/>
     * @param  param
	 * 操作步骤: TODO<br/>
	 * ${tags}
	 */
	@Override
	public List<T> findWithParamEquals(T param) throws Exception{
        String sql = querySelect();
        String wherePrams = "";
        //查询条件
        Map<String,Serializable> map = new HashMap<>();
        List<Pram> wherePramList = SqlUtil.getPramListofStatic(param);
        if (null != wherePramList && wherePramList.size()!=0) {
            for (int i = 0; i < wherePramList.size(); i++) {
                if(wherePramList.get(i).getValue() != null &&!(wherePramList.get(i).getValue() + "").equals("null")) {
                   map.put(wherePramList.get(i).getFile(),(Serializable) wherePramList.get(i).getValue());
                    wherePrams = wherePrams+" and "+wherePramList.get(i).getFile()+"= #{requestParams."+ wherePramList.get(i).getFile()+"}";
                }
            }
        }
        sql +=wherePrams;
        DaoEntity daoEntity = new DaoEntity();
        daoEntity.setParamsSql(sql);
        daoEntity.setRequestParams((Serializable) map);
        List<Map> returnList =  sqlSessionTemplateASS.selectList("select",daoEntity);
        return mapsToObjects(returnList,this.entityClass);
	}

	@Override
	public List<T> findBy(String name, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByParm( WherePrams wherePrams) throws Exception{
        String sql = querySelect()+wherePrams.getWherePrams();
        DaoEntity daoEntity = new DaoEntity();
        daoEntity.setRequestParams((Serializable) wherePrams.getValues());
        daoEntity.setParamsSql(sql);
        List<Map> returnList =  sqlSessionTemplateASS.selectList("select",daoEntity);
        return mapsToObjects(returnList,this.entityClass);
	}

	@Override
	public Integer count(WherePrams param) {
		// TODO Auto-generated method stub
        String sql = "select count(*) as count from "+this.tableName+" where is_del=0 "+param.getWherePrams();
        DaoEntity daoEntity = new DaoEntity();
        daoEntity.setParamsSql(sql);
        daoEntity.setRequestParams((Serializable)param.getValues());
        Object select = sqlSessionTemplateASS.selectOne("select", daoEntity);
        if (null !=select && select instanceof Map){
            return Integer.parseInt (((Map) select).get("count").toString());
        }else {
            return null;
        }

	}


    public Integer countUnlimit(WherePrams param) {
        // TODO Auto-generated method stub
        String sql = "select count(*) as count from "+this.tableName+" where is_del=0 "+param.getWherePramsUnLimit();
        DaoEntity daoEntity = new DaoEntity();
        daoEntity.setParamsSql(sql);
        daoEntity.setRequestParams((Serializable)param.getValues());
        Object select = sqlSessionTemplateASS.selectOne("select", daoEntity);
        if (null !=select && select instanceof Map){
            return Integer.parseInt (((Map) select).get("count").toString());
        }else {
            return null;
        }

    }

	@Override
	public void flushStatements() {
		// TODO Auto-generated method stub

    }

    private  <T> List<T> mapsToObjects(List<Map> maps,Class<T> clazz) throws Exception  {
            List<T> list = new ArrayList();
            if (maps != null && maps.size() > 0) {
                Map<String, Object> map = null;
                T bean = null;
                for (int i = 0,size = maps.size(); i < size; i++) {
                    map = maps.get(i);
                    bean = clazz.newInstance();
                    mapToBean(map, bean);
                    list.add(bean);
                }
            }
            return list;

    }

    private  <T> T mapToBean(Map<String, Object> map,T bean) {
	    if (null == map){
	        return null;
        }
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }


    private String querySelect(){
	    try {
            // TODO Auto-generated method stub
            String prams = "";
            int index = 0;
            //获取列名
            List<Pram> pramList = this.sqlUtil.getPramListByBeanOfSelect(this.entityClass);
            if (null != pramList && pramList.size()!=0) {
                //搜索列
                for (int i = 0; i < pramList.size(); i++) {
                    if (index > 0) {
                        prams += ",";
                    }
                    prams += pramList.get(i).getFile();
                    index++;
                }
                return "select " + prams + " from " + this.tableName+" where is_del=0";
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

	

}
