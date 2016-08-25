package com.liz.genCode.jdbc;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Frank on 2016/4/25
 */
public class DBUtils {

    public static final String DB_TYPE_ORACLE = "oracle";
    public static final String DB_TYPE_POSTGRESQL = "postgresql";
    public static final String DB_TYPE_MYSQL = "mysql";
    public static final String DB_TYPE_MSSQLSERVER = "mssqlserver";
    public static final String DB_TYPE_DB2 = "db2";

    public static Connection getConnection(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/money_note?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "123456";

        Connection connection = null;
        try {
            Class.forName(driver);
            connection = (Connection) DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static String convertDatabaseCharsetType(String in, String type) {
        String dbUser;
        if (in != null) {
            if (DB_TYPE_ORACLE.equals(type)) {
                dbUser = in.toUpperCase();
            } else if (DB_TYPE_POSTGRESQL.equals(type)) {
                dbUser = "public";
            } else if (DB_TYPE_MYSQL.equals(type)) {
                dbUser = null;
            } else if (DB_TYPE_MSSQLSERVER.equals(type)) {
                dbUser = null;
            } else if (DB_TYPE_DB2.equals(type)) {
                dbUser = in.toUpperCase();
            } else {
                dbUser = in;
            }
        } else {
            dbUser = "public";
        }
        return dbUser;
    }
    private static void getTables(Connection conn) throws SQLException {
        DatabaseMetaData dbMetData = (DatabaseMetaData) conn.getMetaData();
        // mysql convertDatabaseCharsetType null
        ResultSet rs = dbMetData.getTables(null, convertDatabaseCharsetType("root", DB_TYPE_MYSQL), null, new String[] { "TABLE", "VIEW" });

        while (rs.next()) {
            if (rs.getString(4) != null && (rs.getString(4).equalsIgnoreCase("TABLE") || rs.getString(4).equalsIgnoreCase("VIEW"))) {
                String tableName = rs.getString(3).toLowerCase();
                System.out.println();
                System.out.println("_________________  tableName :"+tableName + "  _________________");
                // 根据表名,提取表里面字段信息：
                ResultSet colRet = dbMetData.getColumns(null, "%", tableName,"%");
                while (colRet.next()) {
                    String columnName = colRet.getString("COLUMN_NAME");
                    String columnType = colRet.getString("TYPE_NAME");
                    int dataSize = colRet.getInt("COLUMN_SIZE");
                    int digits = colRet.getInt("DECIMAL_DIGITS");
                    int nullable = colRet.getInt("NULLABLE");

                    String remarks = colRet.getString("REMARKS");
                    String isNullable = colRet.getString("IS_NULLABLE");

                    System.out.println("columnName:" + columnName + ", columnType:" + columnType + ", dataSize:"+ dataSize
                            + ", digits:" + digits + " , nullable:" + nullable + ", remarks:" + remarks + " , isNullable:" + isNullable);
                }

            }
        }
        System.out.println();

//         resultSet数据下标从1开始
//        ResultSet tableRet = conn.getMetaData().getTables(null, null, "%", new String[] { "TABLE" });
//        while (tableRet.next()) {
//          System.out.print(tableRet.getString(3) + "\t");
//        }
        System.out.println();

    }

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        System.out.println(connection);
        getTables(connection);
    }
}
