package com.younger.base.persistence.util;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.younger.base.persistence.Page;

/**
 * 数据存取工具类
 * 
 * @author wangyao
 * 
 */
@SuppressWarnings("unchecked")
public class DbUtil {

    private static Log log = LogFactory.getLog(DbUtil.class);

    private static Object query(DataSource ds, String sql, Object[] params, ResultSetHandler rsh) {
        Object result = null;
        QueryRunner run = new QueryRunner(ds);

        try {
            log.debug("sql:" + sql);
            result = run.query(sql, rsh, params);
        } catch (SQLException e) {
            log.error("查询出错！");
            log.error(e.getMessage());
        }

        return result;
    }

    private static List query(DataSource ds, String sql, Object[] params, ResultSetHandler rsh, Page page) {
        List result = null;
        QueryRunner run = new QueryRunner(ds);

        try {
            log.debug("sql:" + sql);
            result = (List) run.query(sql, rsh, params);
        } catch (SQLException e) {
            log.error("查询出错！");
            log.error(e.getMessage());
        }

        // 截取结果集
        if (null != result) {
            page.setTotalRows(result.size());
            int offset = (page.getPageNo() - 1) * page.getPageSize();
            result = subList(result, offset, page.getPageSize());
        }

        return result;
    }

    /**
     * 增删改数据
     * 
     * @param ds
     * @param sql
     * @param params
     * @return
     */
    public static int update(DataSource ds, String sql, Object[] params) {
        int rows = -1;

        QueryRunner runner = new QueryRunner(ds);
        try {
            log.debug("sql:" + sql);

            rows = runner.update(sql, params);
        } catch (SQLException e) {
            log.error("保存出错！");
            log.error(e.getMessage());
        }

        return rows;
    }

    /**
     * 查询单个，返回数据为clazz的对象
     * 
     * @param ds
     * @param sql
     * @param params
     * @param clazz
     * @return
     */
    public static Object get(DataSource ds, String sql, Object[] params, Class clazz) {
        ResultSetHandler rsh = new BeanHandler(clazz);
        return query(ds, sql, params, rsh);
    }

    /**
     * 查询单个，返回数据为Map类型
     * 
     * @param ds
     * @param sql
     * @param params
     * @return
     */
    public static Map get(DataSource ds, String sql, Object[] params) {
        ResultSetHandler rsh = new MapHandler();
        return (Map) query(ds, sql, params, rsh);
    }

    /**
     * 查询多个，返回数据为clazz的对象列表
     * 
     * @param ds
     * @param sql
     * @param params
     * @param clazz
     * @return
     */
    public static List find(DataSource ds, String sql, Object[] params, Class clazz) {
        ResultSetHandler rsh = new BeanListHandler(clazz);
        return (List) query(ds, sql, params, rsh);
    }

    /**
     * 查询多个，返回数据为Map对象列表
     * 
     * @param ds
     * @param sql
     * @param params
     * @return
     */
    public static List find(DataSource ds, String sql, Object[] params) {
        ResultSetHandler rsh = new MapListHandler();
        return (List) query(ds, sql, params, rsh);
    }

    /**
     * 分页查询，返回数据为clazz的对象列表
     * 
     * @param clazz
     * @param queryString
     * @param params
     * @param offset
     * @param pageSize
     * @return
     */
    public static List find(DataSource ds, String sql, Object[] params, Class clazz, Page page) {
        ResultSetHandler rsh = new BeanListHandler(clazz);
        return query(ds, sql, params, rsh, page);

    }

    /**
     * 分页查询，返回数据为Map对象列表
     * 
     * @param ds
     * @param sql
     * @param params
     * @param page
     * @return
     */
    public static List find(DataSource ds, String sql, Object[] params, Page page) {
        ResultSetHandler rsh = new MapListHandler();
        return query(ds, sql, params, rsh, page);
    }

    /**
     * 根据分页条件截取List结果集
     * 
     * @param list
     * @param offset
     * @param pageSize
     * @return
     */
    public static List subList(List list, int offset, int pageSize) {
        int size = list.size();
        int fromIndex = offset;
        int toIndex = offset + pageSize;

        if (fromIndex >= size)
            return list.subList(0, 0);

        if (toIndex >= size)
            return list.subList(fromIndex, size);

        return list.subList(fromIndex, toIndex);
    }
}
