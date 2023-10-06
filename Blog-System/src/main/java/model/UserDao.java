package model;

import java.sql.*;

//此处是为user数据库的增加与查询操作
public class UserDao {
    //根据userId对用户的查询操作
    public User selectById(int userId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = new User();
        try {
            //1,与数据库建立连接
            connection = DBUtil.getDataSource();
            //2.构造sql语句
            String sql = "select * from user where userId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            //3,执行sql语句
            resultSet = statement.executeQuery();
            //4.遍历结果集合
            if (resultSet.next()) {
                user.setUserId(resultSet.getInt("userId"));
                user.setPassword(resultSet.getString("password"));
                user.setUsername(resultSet.getString("username"));
                int count = 0;
                String sql1 = "select * from blog where userId = ?";
                statement = connection.prepareStatement(sql1);
                statement.setInt(1,user.getUserId());
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    count++;
                }
                user.setBlog_count(count);
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
    //根据username来查询用户信息
    public User selectByUsername(String username) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = new User();
        try {
            //1,与数据库建立连接
            connection = DBUtil.getDataSource();
            //2.构造sql语句
            String sql ="select * from user where username = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            //3.执行sql语句
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user.setUserId(resultSet.getInt("userId"));
                user.setPassword(resultSet.getString("password"));
                user.setUsername(resultSet.getString("username"));
                int count = 0;
                String sql1 = "select * from blog where userId = ?";
                statement = connection.prepareStatement(sql1);
                statement.setInt(1,user.getUserId());
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    count++;
                }
                user.setBlog_count(count);
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    //用户的注册操作
    public static void userAdd(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //1,建立连接
            connection = DBUtil.getDataSource();
            //2,构造sql语句
            String sql = "insert into user values (null,?,?,null,null)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }



}
