package sn.base.persistence.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sn.base.util.Constants;
import sn.base.util.FileUtils;

/**
 * 数据库连接池工具类
 * 
 * @author wangyao
 * 
 */
public class DataSourceUtil {

    private static Log log = LogFactory.getLog(DataSourceUtil.class);

    private static DataSource dataSource = null;

    static {
        dataSource = setupDataSource();
    }

    /**
     * 创建并返回数据库连接池
     * 
     * @return
     */
    private static DataSource setupDataSource() {
        Properties jdbcProperties = FileUtils.loadPropertyFile(Constants.CONFIG_FILE);
        if (null == jdbcProperties) {
            return null;
        }

        // 创建连接池
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(jdbcProperties.getProperty("jdbc.drivers"));
        ds.setUsername(jdbcProperties.getProperty("jdbc.username"));
        ds.setPassword(jdbcProperties.getProperty("jdbc.password"));
        ds.setUrl(jdbcProperties.getProperty("jdbc.url"));
        ds.setInitialSize(Integer.parseInt(jdbcProperties.getProperty("pool.initialsize")));
        ds.setMaxActive(Integer.parseInt(jdbcProperties.getProperty("pool.maxactive")));
        ds.setMaxIdle(Integer.parseInt(jdbcProperties.getProperty("pool.maxidle")));
        ds.setMaxWait(Integer.parseInt(jdbcProperties.getProperty("pool.maxwait")));
        ds.setTestOnBorrow(true);
        ds.setValidationQuery("SELECT 1");

        return ds;
    }

    /**
     * 获取数据源
     * 
     * @return
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 获取数据库连接
     * 
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;

        if (null != dataSource) {
            try {
                connection = dataSource.getConnection();
            } catch (SQLException e) {
                log.error("获取数据库连接失败：" + e.getMessage());
            }
        }

        return connection;
    }

    /**
     * 打印连接池状态
     */
    public static void status() {
        BasicDataSource ds = (BasicDataSource) getDataSource();
        log.info("数据库连接池当前连接数 " + ds.getNumActive() + ", 空闲连接数 " + ds.getNumIdle());
    }
}
