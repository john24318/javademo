package demo.java.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;

public class ConnectionDemo {

    /**
     * 打印Driver信息
     * 
     * @param connect
     */
    public static void printDriverInfo(Driver driver) {
        if (null == driver) {
            return;
        }

        System.out.println("Driver:" + driver);
        System.out.println("Class:" + driver.getClass());
        System.out.println("Version:" + driver.getMajorVersion() + "." + driver.getMinorVersion());
        System.out.println("JDBC Compliant:" + driver.jdbcCompliant());
    }

    /**
     * 打印Connection信息
     * 
     * @param connect
     */
    public static void printConnectInfo(Connection connect) {
        if (null == connect) {
            return;
        }

        try {
            System.out.println("Connection:" + connect);
            System.out.println("ReadOnly:" + connect.isReadOnly());
            System.out.println("Closed:" + connect.isClosed());
            System.out.println("Catalog:" + connect.getCatalog());
            System.out.println("AutoCommit:" + connect.getAutoCommit());
            System.out.println("Holdability:" + connect.getHoldability());
            System.out.println("TransactionIsolation:" + connect.getTransactionIsolation());
            // System.out.println("ClientInfo:" + connect.getClientInfo());
            // System.out.println("TypeMap:" + connect.getTypeMap());
            System.out.println("Warnings:" + connect.getWarnings());
            DatabaseMetaData meta = connect.getMetaData();
            System.out.println("MetaData:" + meta);
            System.out.println(meta.getDriverVersion());
            System.out.println(meta.supportsTransactions());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // derby
        String url = "jdbc:derby://localhost:1527/myeclipse";
        String driverClass = "org.apache.derby.jdbc.ClientDriver";

        // sybase
        // String url = "jdbc:sybase:Tds:192.168.1.31:5000/YQDB";
        // String driverClass = "com.sybase.jdbc3.jdbc.SybDataSource";

        // mysql
        // String url = "jdbc:mysql://192.168.1.100:3306/SWITCH";
        // String driverClass = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driverClass);// old JDBC needed
            Driver driver = DriverManager.getDriver(url);
            printDriverInfo(driver);

            Connection connect = DriverManager.getConnection(url, "sa", "yq902902");
            printConnectInfo(connect);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
