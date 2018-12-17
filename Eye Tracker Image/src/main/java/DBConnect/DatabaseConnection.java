//package DBConnect;
//
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Connection;
//import java.sql.Statement;
//
//public class DatabaseConnection {
//    public static void main(String[] args) throws Exception {
//        Connection conn = null;
//        String sql;
//        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
//        // 避免中文乱码要指定useUnicode和characterEncoding
//        // 执行数据库操作之前要在数据库管理系统上创建一个数据库，名字自己定，
//        // 下面语句之前就要先创建eyetracker数据库
//        String url = "jdbc:mysql://localhost:3306/eyetracker?"
//                + "user=root&password=root&useUnicode=true" +
//                "&characterEncoding=UTF8" +
//                "&autoReconnect=true&useSSL=false";
//        try {
//            // 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
//            // 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
//            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
//            // or:
//            // com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
//            // or：
//            // new com.mysql.jdbc.Driver();
//            System.out.println("成功加载MySQL驱动程序");
//            // 一个Connection代表一个数据库连接
//            conn = DriverManager.getConnection(url);
//            // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
//            Statement stmt = conn.createStatement();
//            sql = "create table student(NO char(20),name varchar(20),primary key(NO))";
//            int result = stmt.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
//            if (result != -1) {
//                System.out.println("创建数据表成功");
//                sql = "insert into student(NO,name) values('2012001','陶伟基')";
//                result = stmt.executeUpdate(sql);
//                sql = "insert into student(NO,name) values('2012002','周小俊')";
//                result = stmt.executeUpdate(sql);
//                sql = "select * from student";
//                ResultSet rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
//                System.out.println("学号\t姓名");
//                while (rs.next()) {
//                    System.out
//                            .println(rs.getString(1) + "\t" + rs.getString(2));// 入如果返回的是int类型可以用getInt()
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println("MySQL操作错误");
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            conn.close();
//        }
//
//    }
//
//}

package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    public static void main(String[] args) {
        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://localhost:3306/eyetracker"; //加上数据库名字
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "root";
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2. Create Statement instance, to execute SQL queries
            Statement statement = con.createStatement();
            //SQL query to execute
            String sql = "select * from student";
            //3.ResultSet Class, used to store the results set
            ResultSet rs = statement.executeQuery(sql); // result set is a Map
            System.out.println("-----------------");
            System.out.println("The executed results are as follows:");
            System.out.println("-----------------");
            System.out.println("ID" + "\t" + "Name");
            System.out.println("-----------------");
            String name = null;
            String number = null;
            while(rs.next()){
                //Get the column of "NO"
                number = rs.getString("NO"); //map key: "NO"
                //Get the column of "name"
                name = rs.getString("name"); //map key: "name"
                //Output the result
                System.out.println(number + "\t" + name);
            }
            rs.close(); // close the result
            con.close(); // close the connection
        } catch(ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("Database connected successfully!");
        }
    }

}
