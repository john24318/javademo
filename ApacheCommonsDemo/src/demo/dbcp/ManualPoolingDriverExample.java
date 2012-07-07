package demo.dbcp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDriver;
import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool;

public class ManualPoolingDriverExample {

    private static final String configFile = "config/dbcp/database.properties";

    static {
        setupDriver();
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

    public static void setupDriver() {
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

        // 创建PoolingDriver
        try {
            Class.forName("org.apache.commons.dbcp.PoolingDriver");
            PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");

            // 注册连接池
            driver.registerPool("example", connectionPool);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
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
            connection = DriverManager.getConnection("jdbc:apache:commons:dbcp:example");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 打印连接池状态
     * 
     * @throws SQLException
     * 
     * @throws Exception
     */
    public static void printDriverStats() {
        try {
            PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
            ObjectPool connectionPool = driver.getConnectionPool("example");
            System.out.println("NumActive: " + connectionPool.getNumActive() + ", NumIdle: " + connectionPool.getNumIdle());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接池
     * 
     * @throws SQLException
     * 
     * @throws Exception
     */
    public static void shutdownDriver() {
        try {
            PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
            driver.closePool("example");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;
        String sql = "SELECT * FROM user";

        printDriverStats();

        try {
            System.out.println("Creating connection.");
            conn = getConnection();
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

            printDriverStats();
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

        printDriverStats();

        shutdownDriver();
    }

}
