package sn.base.persistence.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sn.base.persistence.Page;
import sn.base.persistence.util.DataSourceUtil;
import sn.base.persistence.util.DbUtil;

@SuppressWarnings("unchecked")
public class BaseDao implements Dao {

    private static Log log = LogFactory.getLog(BaseDao.class);

    /**
     * 获取连接池
     * 
     * @return
     */
    public DataSource getDataSource() {
        return DataSourceUtil.getDataSource();
    }

    /**
     * 获取连接
     * 
     * @return
     */
    public Connection getConnection() {
        return DataSourceUtil.getConnection();
    }

    /**
     * 关闭连接
     * 
     * @param conn
     */
    public void closeConnection(Connection conn) {
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 增删改数据
     * 
     * @param sql
     * @param params
     * @return
     */
    public int update(String sql, Object[] params) {
        DataSource ds = getDataSource();
        return DbUtil.update(ds, sql, params);
    }

    /**
     * 查询单个，返回数据为clazz的对象
     * 
     * @param sql
     * @param params
     * @param clazz
     * @return
     */
    public Object get(String sql, Object[] params, Class clazz) {
        DataSource ds = getDataSource();
        return DbUtil.get(ds, sql, params, clazz);
    }

    /**
     * 查询单个，返回数据为Map类型
     * 
     * @param sql
     * @param params
     * @return
     */
    public Object get(String sql, Object[] params) {
        DataSource ds = getDataSource();
        return DbUtil.get(ds, sql, params);
    }

    /**
     * 查询某列数据
     * 
     * @param sql
     * @param params
     * @return
     */
    public List getOneColumn(String sql, Object[] params) {
        DataSource ds = getDataSource();
        return DbUtil.getOneColumn(ds, sql, params);
    }

    /**
     * 查询多个，返回数据为clazz的对象列表
     * 
     * @param sql
     * @param params
     * @param clazz
     * @return
     */
    public List find(String sql, Object[] params, Class clazz) {
        DataSource ds = getDataSource();
        return DbUtil.find(ds, sql, params, clazz);
    }

    /**
     * 查询多个，返回数据为Map对象列表
     * 
     * @param sql
     * @param params
     * @return
     */
    public List find(String sql, Object[] params) {
        DataSource ds = getDataSource();
        return DbUtil.find(ds, sql, params);
    }

    /**
     * 分页查询，返回数据为clazz的对象列表
     * 
     * @param sql
     * @param params
     * @param clazz
     * @param page
     * @return
     */
    public List find(String sql, Object[] params, Class clazz, Page page) {
        DataSource ds = getDataSource();
        return DbUtil.find(ds, sql, params, clazz, page);
    }

    /**
     * 分页查询，返回数据为Map对象列表
     * 
     * @param sql
     * @param params
     * @param page
     * @return
     */
    public List find(String sql, Object[] params, Page page) {
        DataSource ds = getDataSource();
        return DbUtil.find(ds, sql, params, page);
    }
}
