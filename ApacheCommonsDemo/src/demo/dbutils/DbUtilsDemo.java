package demo.dbutils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import demo.dbcp.BasicDataSourceDemo;

@SuppressWarnings("unchecked")
public class DbUtilsDemo {
    private static Log log = LogFactory.getLog(DbUtilsDemo.class);

    public static void insert() {
        String sql = "INSERT INTO USER(NAME, PASSWORD, sex, create_time, title, COUNT) VALUES (?, ?, 1, NOW(), ?, 0)";
        QueryRunner run = new QueryRunner(BasicDataSourceDemo.getDataSource());
        User user = new User();
        user.setAname("b");
        user.setPassword("bbb");
        user.setTitle("b title");

        try {
            int result = run.update(sql, new Object[] { user.getAname(), user.getPassword(), user.getTitle() });
            log.info("has inserted " + result + " rows data.");
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 获取第一行某列数据
     * 
     * @throws SQLException
     */
    public static void getOneRowOneColumn() {
        ResultSetHandler h = new ScalarHandler(); // 默认获取第一行第一列数据
        // ResultSetHandler h = new ScalarHandler(1);//获取第一行第一列数据
        // ResultSetHandler h = new ScalarHandler("name");//获取第一行列名为name的数据
        QueryRunner run = new QueryRunner(BasicDataSourceDemo.getDataSource());
        try {
            Object result = run.query("SELECT * FROM user", h);
            log.info(result);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 以数组方式返回第一行数据
     * 
     * @throws SQLException
     */
    public static void getOneRowAsArray() {
        ResultSetHandler h = new ArrayHandler(); // 自带的ArrayHandler
        QueryRunner run = new QueryRunner(BasicDataSourceDemo.getDataSource());
        try {
            Object[] result = (Object[]) run.query("SELECT * FROM user", h);
            log.info(Arrays.toString(result));
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 以Map方式返回第一行数据
     * 
     * @throws SQLException
     */
    public static void getOneRowAsMap() {
        ResultSetHandler rsh = new MapHandler();
        QueryRunner run = new QueryRunner();
        Connection conn = BasicDataSourceDemo.getConnection();
        Object result = null;
        try {
            result = run.query(conn, "SELECT * FROM user", rsh);
        } catch (SQLException e) {
            log.error(e.getMessage());
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        log.info(result);
    }

    /**
     * 以Bean方式返回第一行数据
     * 
     * @throws SQLException
     */
    public static void getOneRowAsBean() {
        ResultSetHandler h = new BeanHandler(User.class);
        QueryRunner run = new QueryRunner(BasicDataSourceDemo.getDataSource());
        try {
            Object result = run.query("SELECT * FROM user", h);
            log.info(result);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 获取某列数据集
     * 
     * @throws SQLException
     */
    public static void getRowsAsColumnList() {
        ResultSetHandler h = new ColumnListHandler(); // 默认获取第一列数据
        // ResultSetHandler h = new ColumnListHandler(1); // 获取第一列数据
        // ResultSetHandler h = new ColumnListHandler("name"); // 获取列名为name的数据
        QueryRunner run = new QueryRunner(BasicDataSourceDemo.getDataSource());
        try {
            List result = (List) run.query("SELECT * FROM user", h);
            log.info(result);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 以Array列表方式返回数据集合
     * 
     * @throws SQLException
     */
    public static void getRowsAsArrayList() {
        ResultSetHandler h = new ArrayListHandler();
        QueryRunner run = new QueryRunner(BasicDataSourceDemo.getDataSource());
        try {
            List result = (List) run.query("SELECT * FROM user", h);
            log.info(Arrays.deepToString(result.toArray()));
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 以MAP列表方式返回数据集合
     * 
     * @throws SQLException
     */
    public static void getRowsAsMapList() {
        ResultSetHandler h = new MapListHandler();
        QueryRunner run = new QueryRunner(BasicDataSourceDemo.getDataSource());
        try {
            List result = (List) run.query("SELECT * FROM user", h);
            log.info(result);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 以Bean列表方式返回数据集合
     * 
     * @throws SQLException
     */
    public static void getRowsAsBeanList() {
        ResultSetHandler h = new BeanListHandler(User.class);
        QueryRunner run = new QueryRunner(BasicDataSourceDemo.getDataSource());
        try {
            List result = (List) run.query("SELECT name as aname, password FROM user", h);
            log.info(result);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 以Map方式返回数据集
     * 
     * @throws SQLException
     */
    public static void getRowsAsMap() {
        // ResultSetHandler h = new KeyedHandler(); //默认key为第一列数据
        // ResultSetHandler h = new KeyedHandler(1); // 指定key为第一列数据
        ResultSetHandler h = new KeyedHandler("name"); // 指定key为列名为name的值
        QueryRunner run = new QueryRunner(BasicDataSourceDemo.getDataSource());
        try {
            Map result = (Map) run.query("SELECT * FROM user", h);
            log.info(result);
            log.info(result.get("a"));
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        BasicDataSourceDemo.printDataSourceStats();
        // 新增，更新数据
        // insertUser();

        // 获取第一行某列数据
        // getOneRowOneColumn();

        // 获取第一行数据
        // getOneRowAsArray();
        // getOneRowAsMap();
        // getOneRowAsBean();

        // 获取某列数据
        // getRowsAsColumnList();

        // 获取所有数据
        // getRowsAsArrayList();
        // getRowsAsMapList();
        getRowsAsBeanList();
        // getRowsAsMap();
        BasicDataSourceDemo.printDataSourceStats();
    }

}
