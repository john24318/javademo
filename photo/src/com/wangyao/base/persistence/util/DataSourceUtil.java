package com.wangyao.base.persistence.util;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库连接池工具类
 * 
 * @author wangyao
 * 
 */
public class DataSourceUtil {

    private static DataSource dataSource = null;

    private static final String CONFIG_FILE = "database.properties";

    private static Log log = LogFactory.getLog(DataSourceUtil.class);

    static {
        init();
    }

    /**
     * 初始化数据库连接池
     */
    private static void init() {
        InputStream configFileStream = DataSourceUtil.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
        Properties jdbcProperties = new Properties();

        // 加载配置文件
        try {
            jdbcProperties.load(configFileStream);
            log.info("读取数据库配置文件 " + CONFIG_FILE + " 成功！");
        } catch (IOException e) {
            log.error("读取数据库配置文件 " + CONFIG_FILE + " 失败！");
            log.error(e.getMessage());
            return;
        }

        // 加载数据库驱动
        try {
            Class.forName(jdbcProperties.getProperty("jdbc.drivers"));
            log.info("加载数据库驱动 " + jdbcProperties.getProperty("jdbc.drivers") + " 成功！");
        } catch (ClassNotFoundException e) {
            log.error("加载数据库驱动 " + jdbcProperties.getProperty("jdbc.drivers") + " 失败！");
            log.error(e.getMessage());
            return;
        }

        // 创建连接池
        // BasicDataSource ds = new BasicDataSource();
        // ds.setDriverClassName(jdbcProperties.getProperty("jdbc.drivers"));
        // ds.setUsername(jdbcProperties.getProperty("jdbc.username"));
        // ds.setPassword(jdbcProperties.getProperty("jdbc.password"));
        // ds.setUrl(jdbcProperties.getProperty("jdbc.url"));
        // ds.setInitialSize(Integer.parseInt(jdbcProperties.getProperty("pool.initialsize")));
        // ds.setMaxActive(Integer.parseInt(jdbcProperties.getProperty("pool.maxactive")));
        // ds.setMaxIdle(Integer.parseInt(jdbcProperties.getProperty("pool.maxidle")));
        // ds.setMaxWait(Integer.parseInt(jdbcProperties.getProperty("pool.maxwait")));
        // ds.setTestOnBorrow(true);
        // ds.setValidationQuery("SELECT 1");

        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass(jdbcProperties.getProperty("jdbc.drivers"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } // loads the jdbc driver
        ds.setUser(jdbcProperties.getProperty("jdbc.username"));
        ds.setPassword(jdbcProperties.getProperty("jdbc.password"));
        ds.setJdbcUrl(jdbcProperties.getProperty("jdbc.url"));
        ds.setInitialPoolSize(Integer.parseInt(jdbcProperties.getProperty("pool.InitialPoolSize")));
        ds.setMaxPoolSize(Integer.parseInt(jdbcProperties.getProperty("pool.MaxPoolSize")));
        ds.setMinPoolSize(Integer.parseInt(jdbcProperties.getProperty("pool.MinPoolSize")));
        ds.setMaxIdleTime(Integer.parseInt(jdbcProperties.getProperty("pool.MaxIdleTime")));
        ds.setTestConnectionOnCheckout(true);
        ds.setPreferredTestQuery("SELECT 1");

        dataSource = ds;
        log.info("创建数据库连接池成功！");
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
        Connection ret = null;

        try {
            printStatus();

            ret = dataSource.getConnection();

            printStatus();
        } catch (SQLException e) {
            log.error("不能获取数据库连接！");
            log.error(e.getMessage());
        }

        return ret;
    }

    /**
     * 打印连接池状态
     */
    public static void printStatus() {
        if (dataSource instanceof BasicDataSource) {
            BasicDataSource ds = (BasicDataSource) dataSource;
            System.out.println("当前连接数[" + ds.getNumActive() + "]空闲连接数[" + ds.getNumIdle() + "]");
            log.debug("当前连接数[" + ds.getNumActive() + "]空闲连接数[" + ds.getNumIdle() + "]");
        }

        if (dataSource instanceof ComboPooledDataSource) {
            ComboPooledDataSource ds = (ComboPooledDataSource) dataSource;
            try {
                System.out.println("连接数[" + ds.getNumConnectionsDefaultUser() + "]活动连接数[" + ds.getNumBusyConnectionsDefaultUser() + "]空闲连接数["
                        + ds.getNumIdleConnectionsDefaultUser() + "]");
                log.debug("连接数[" + ds.getNumConnectionsDefaultUser() + "]活动连接数[" + ds.getNumBusyConnectionsDefaultUser() + "]空闲连接数["
                        + ds.getNumIdleConnectionsDefaultUser() + "]");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
