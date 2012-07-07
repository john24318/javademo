package sn.base.persistence.dao;

import java.util.List;

import sn.base.persistence.Page;

@SuppressWarnings("unchecked")
public interface Dao {

    /**
     * 增删改数据
     * 
     * @param sql
     * @param params
     * @return
     */
    public int update(String sql, Object[] params);

    /**
     * 查询单个，返回数据为clazz的对象
     * 
     * @param sql
     * @param params
     * @param clazz
     * @return
     */
    public Object get(String sql, Object[] params, Class clazz);

    /**
     * 查询单个，返回数据为Map类型
     * 
     * @param sql
     * @param params
     * @return
     */
    public Object get(String sql, Object[] params);

    /**
     * 查询多个，返回数据为clazz的对象列表
     * 
     * @param sql
     * @param params
     * @param clazz
     * @return
     */
    public List find(String sql, Object[] params, Class clazz);

    /**
     * 查询多个，返回数据为Map对象列表
     * 
     * @param sql
     * @param params
     * @return
     */
    public List find(String sql, Object[] params);

    /**
     * 分页查询，返回数据为clazz的对象列表
     * 
     * @param sql
     * @param params
     * @param clazz
     * @param page
     * @return
     */
    public List find(String sql, Object[] params, Class clazz, Page page);

    /**
     * 分页查询，返回数据为Map对象列表
     * 
     * @param sql
     * @param params
     * @param page
     * @return
     */
    public List find(String sql, Object[] params, Page page);
}
