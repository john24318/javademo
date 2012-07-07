package demo.dbcp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class PoolingDriverDemo {

    private static final String configFile = "config/dbcp/database.properties";

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
     * 获取数据库连接
     * 
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;
        Properties config = getConfigProperties(configFile);
        // 设置jdbc.drivers系统属性，多个值以冒号分隔
        // 要使用连接池，需注册org.apache.commons.dbcp.PoolingDriver驱动
        System.setProperty("jdbc.drivers", config.getProperty("jdbc.drivers") + ":" + "org.apache.commons.dbcp.PoolingDriver");

        try {
            connection = DriverManager.getConnection(config.getProperty("jdbc.url"), config.getProperty("jdbc.username"), config
                    .getProperty("jdbc.password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;
        String sql = "SELECT * FROM user";

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
