package demo.dbcp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool;

public class PoolingDataSourceDemo {

    private static final String configFile = "config/dbcp/database.properties";

    private static DataSource ds = null;

    static {
        System.out.println("Setting up data source.");
        ds = setupDataSource();
        System.out.println("Done.");
    }

    /**
     * 读取数据库配置文件
     * 
     * @param file
     * @return
     */
    private static Properties getConfigProperties(String file) {
        Properties configProperties = new Properties();
        try {
            configProperties.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configProperties;
    }

    /**
     * 创建数据库连接池
     * 
     * @return
     */
    private static DataSource setupDataSource() {
        Properties config = getConfigProperties(configFile);

        // 设置jdbc.drivers系统属性或加载数据库驱动
        // System.setProperty("jdbc.drivers", config.getProperty("jdbc.drivers"));
        try {
            Class.forName(config.getProperty("jdbc.drivers"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 创建ObjectPool，作为实际的连接池，也可选用其他的ObjectPool实现类
        ObjectPool connectionPool = new GenericObjectPool(null);

        // 创建连接工厂，用于连接池创建连接
        ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(config.getProperty("jdbc.url"), config
                .getProperty("jdbc.username"), config.getProperty("jdbc.password"));

        // 创建PoolableConnectionFactory
        @SuppressWarnings("unused")
        PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, connectionPool, null, null,
                false, true);

        // 通过ObjectPool创建PoolingDataSource
        PoolingDataSource dataSource = new PoolingDataSource(connectionPool);

        return dataSource;
    }

    /**
     * 获取数据库连接池
     * 
     * @return
     */
    public static DataSource getDataSource() {
        return ds;
    }

    /**
     * 获取数据库连接
     * 
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        DataSource dataSource = getDataSource();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;
        String sql = "SELECT * FROM user";

        try {
            System.out.println("Creating connection.");
            conn = dataSource.getConnection();
            System.out.println("Creating statement.");
            stmt = conn.createStatement();
            System.out.println("Executing statement.");
            rset = stmt.executeQuery(sql);
            System.out.println("Results:");
            int numcols = rset.getMetaData().getColumnCount();
            while (rset.next()) {
                for (int i = 1; i <= numcols; i++) {
                    System.out.print("\t" + rset.getString(i));
                }
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rset.close();
            } catch (Exception e) {
            }
            try {
                stmt.close();
            } catch (Exception e) {
            }
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }

}
