package CC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test01 {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库驱动加载成功！");
            String url="jdbc:mysql://localhost:3306/yj?serverTimezone=UTC&characterEncoding=utf8&useUnicode=truet&useSSL=false";
            String username="root";
            String password="251147";
            connection= DriverManager.getConnection(url,username, password);
            System.out.println("数据库连接成功！");
            statement=connection.createStatement();
            String sql="create table score(sid int,name varchar(20),English int,math int,politics int,java int)";
            statement.executeUpdate(sql);
            System.out.println("数据表创建成功");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("数据库驱动加载失败");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
        finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
