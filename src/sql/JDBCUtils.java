package sql;

import java.sql.*;

public class JDBCUtils {
        public static String CLASSDRIVERNAME="com.mysql.cj.jdbc.Driver";
        public static String URL="jdbc:mysql://localhost:3306/yj?serverTimezone=UTC&characterEncoding=utf8&useUnicode=truet&useSSL=false";
        public static String USERNAME="root";
        public static String PASSWORD="251147";

        public static void loadDriver(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        public static Connection getConnection(){
            Connection conn=null;
            loadDriver();
            try {
                conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
             public static void release(Statement stmt, Connection conn){
                if (stmt!=null){
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (conn!=null){
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
        }
    public static void release(ResultSet rs, Statement stmt, Connection conn){
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

