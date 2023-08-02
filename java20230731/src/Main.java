import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        //System.out.println("Hello world!");
        //1.创建并初始化一个数据源
        //MysqlDataSource mysqlDataSource = new MysqlDataSource();
        Scanner scanner = new Scanner(System.in);
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("123456");
        //2.和数据库服务器进行连接
        Connection connection = dataSource.getConnection();
        //3.构造sql语句
        System.out.println("请输入名字->");
        String name = scanner.nextLine();
        System.out.println("请输入学号->");
        int id = scanner.nextInt();
        //String sql = "insert into student value("+id+",'"+name+"')";
        String sql = "insert into student value(?,?)";//使用占位符

        PreparedStatement statement = connection.prepareStatement(sql);//进行预编译
        statement.setInt(1,id);//把占位符替换成指定的值
        statement.setString(2,name);
        //4.执行sql语句
        int ret = statement.executeUpdate();//把预编译过的发送给数据库服务器由服务器作出响应,返回的是影响到的行数,insert,updata,delet都是使用这个
        System.out.println(ret);
        //5.释放必要资源
        statement.close();
        connection.close();
    }
}