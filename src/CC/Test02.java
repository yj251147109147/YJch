package CC;

import java.sql.*;

public class Test02 {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库驱动加载成功！");
            String url="jdbc:mysql://localhost:3306/yj?serverTimezone=UTC&characterEncoding=utf8&useUnicode=truet&useSSL=false";
            String username="root";
            String password="251147";
            connection= DriverManager.getConnection(url,username, password);
            System.out.println("数据库连接成功！");
            String sql="insert into score(sid,name,English,math,politics,java)values(?,?,?,?,?,?)";
            String sql1="insert into score(sid,name,English,math,politics,java)values(?,?,?,?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,01);
            preparedStatement.setString(2,"王林");
            preparedStatement.setInt(3,98);
            preparedStatement.setInt(4,97);
            preparedStatement.setInt(5,96);
            preparedStatement.setInt(6,95);
            preparedStatement.executeUpdate();
            preparedStatement=connection.prepareStatement(sql1);
            preparedStatement.setInt(1,02);
            preparedStatement.setString(2,"孟浩");
            preparedStatement.setInt(3,98);
            preparedStatement.setInt(4,97);
            preparedStatement.setInt(5,96);
            preparedStatement.setInt(6,95);
            preparedStatement.executeUpdate();
            System.out.println("数据添加成功");
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
           if (preparedStatement!=null){
               try {
                   preparedStatement.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }

        }
    }
}
