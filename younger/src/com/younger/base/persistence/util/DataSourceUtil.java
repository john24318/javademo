package com.younger.base.persistence.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 数据库连接池工具类
 * 
 * @author wangyao
 * 
 */
public class DataSourceUtil {

    private static Log log = LogFactory.getLog(DataSourceUtil.class);

    private static DataSource dataSource = null;

    private static final String DB_CONFIG_FILE = "database.properties";

    static {
        dataSource = setupDataSource();
    }

    /**
     * 创建并返回数据库连接池
     * 
     * @return
     */
    private static DataSource setupDataSource() {
        InputStream configFileStream = DataSourceUtil.class.getClassLoader().getResourceAsStream(DB_CONFIG_FILE);
        Properties jdbcProperties = new Properties();
        BasicDataSource ds = null;

        // 加载配置文件
        try {
            jdbcProperties.load(configFileStream);
        } catch (IOException e) {
            log.error("加载配置文件[" + DB_CONFIG_FILE + "]失败！");
            log.error(e.getMessage());
            return ds;
        } finally {
            try {
                configFileStream.close();
                configFileStream = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 创建连接池
        ds = new BasicDataSource();
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
        if (null == dataSource) {
            // 此处加锁，防止创建多个DataSource
            synchronized (DataSourceUtil.class) {
                if (null == dataSource) {
                    dataSource = setupDataSource();
                }
            }
        }

        return dataSource;
    }

    /**
     * 关闭连接池
     */
    public static synchronized void shutdownDataSource() {
        if (null != dataSource) {
            try {
                ((BasicDataSource) dataSource).close();
                dataSource = null;
            } catch (SQLException e) {
                log.error("关闭数据库连接池失败！");
                log.error(e.getMessage());
            }
        }
    }

    /**
     * 获取数据库连接
     * 
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = getDataSource().getConnection();
        } catch (SQLException e) {
            log.error("获取数据库连接失败！");
            log.error(e.getMessage());
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
