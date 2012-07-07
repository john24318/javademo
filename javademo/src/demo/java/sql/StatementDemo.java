package demo.java.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String url = "jdbc:derby://localhost:1527/myeclipse";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        boolean isResultSet = false;
        int count = -1;

        try {
            Class.forName(driver); // 加载驱动
            conn = DriverManager.getConnection(url);// 获取连接
            stmt = conn.createStatement();

            // 删除表
            sql = "drop table USER_INFO";
            try {
                isResultSet = stmt.execute(sql);
                System.out.println("isResultSet:" + isResultSet);
            } catch (SQLException e) {
                System.out.println("Drop table exception:");
                e.printStackTrace();
            }

            // 建表
            sql = "create table USER_INFO(ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, NAME VARCHAR(10) NOT NULL)";
            try {
                isResultSet = stmt.execute(sql);
                System.out.println("isResultSet:" + isResultSet);
            } catch (SQLException e) {
                System.out.println("Create table exception:");
                e.printStackTrace();
            }

            // 插入数据
            System.out.println("AutoCommit:" + conn.getAutoCommit());
            conn.setAutoCommit(false);
            System.out.println("AutoCommit:" + conn.getAutoCommit());
            // sql = "insert into USER_INFO(NAME) values (?)";
            sql = "insert into USER_INFO(NAME) values (?), (?)";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "aaa");
            ps.setString(2, "bbb");
            count = ps.executeUpdate();
            System.out.println("count:" + count);

            rs = ps.getGeneratedKeys();
            while (rs != null && rs.next()) {
                System.out.println("id:" + rs.getInt(1));
            }
            conn.commit();
            conn.setAutoCommit(true);
            System.out.println("AutoCommit:" + conn.getAutoCommit());

            // 查询数据
            rs = stmt.executeQuery("select * from USER_INFO");
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                System.out.println(rsmd.getColumnName(1) + "=" + id + "," + rsmd.getColumnName(2) + "=" + name);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                    rs = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (null != stmt) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (null != ps) {
                try {
                    ps.close();
                    ps = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (null != conn) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
