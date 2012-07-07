package demo.dbcp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class BasicDataSourceDemo {

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
        BasicDataSource ds = new BasicDataSource();

        ds.setDriverClassName(config.getProperty("jdbc.drivers"));
        ds.setUsername(config.getProperty("jdbc.username"));
        ds.setPassword(config.getProperty("jdbc.password"));
        ds.setUrl(config.getProperty("jdbc.url"));
        ds.setInitialSize(Integer.parseInt(config.getProperty("pool.initialsize")));
        ds.setMaxActive(Integer.parseInt(config.getProperty("pool.maxactive")));
        ds.setMaxIdle(Integer.parseInt(config.getProperty("pool.maxidle")));
        ds.setMaxWait(Integer.parseInt(config.getProperty("pool.maxwait")));

        return ds;
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

    /**
     * 打印连接池状态
     * 
     * @throws SQLException
     */
    public static void printDataSourceStats() {
        BasicDataSource bds = (BasicDataSource) ds;
        System.out.println("NumActive: " + bds.getNumActive() + ", NumIdle: " + bds.getNumIdle());
    }

    /**
     * 关闭连接池
     * 
     * @throws SQLException
     */
    public static void shutdownDataSource() {
        BasicDataSource bds = (BasicDataSource) ds;
        try {
            bds.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String sql = "SELECT * FROM user";
        DataSource dataSource = getDataSource();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        printDataSourceStats();

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

            printDataSourceStats();
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

        printDataSourceStats();
    }
}
