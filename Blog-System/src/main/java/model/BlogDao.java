package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//这个类封装了对博客数据的增加和查询功能
//删除和修改待完善
public class BlogDao {
    //博客的增加方法
    public void add(Blog blog) {
        //1,和数据库建立连接
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBUtil.getDataSource();
            //2,构造数据库语句
            String sql = "insert into blog values(null,?,?,?,?,null)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, blog.getTitle());
            statement.setString(2, blog.getPostTime());
            statement.setString(3, blog.getContent());
            statement.setInt(4, blog.getUserId());

            //3.执行sql语句
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    //博客的查询方法,查询全部博客
    public List<Blog> selectAll() {
        List<Blog> blogList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //1,与数据库建立连接
            connection = DBUtil.getDataSource();
            //2,构造sql语句
            String sql = "select * from blog order by blogId desc ";
            preparedStatement = connection.prepareStatement(sql);
            //3,执行sql语句,将得到的数据拿到resultSet存放
            resultSet = preparedStatement.executeQuery();
            //4,将数据存放到list集合中等待使用
            while (resultSet.next()) {
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                String content = resultSet.getString("content");
                if (content == null) {
                    content = "";
                }
                if (content.length() >= 100) {
                    content = content.substring(0,100) + "...";
                }
                blog.setContent(content);
                blog.setUserId(resultSet.getInt("userId"));
                blogList.add(blog);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(connection, preparedStatement, resultSet);
        }
        return blogList;
    }

    //此处是拿来以博客id查询博客的方法
    public Blog selectById(int blogId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Blog blog = new Blog();

        try {
            //与数据库建立连接
            connection = DBUtil.getDataSource();
            //2,构造sql语句
            String sql = "select * from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,blogId);
            //3,执行sql语句
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blog.setContent(resultSet.getString("content"));
                blog.setUserId(resultSet.getInt("userId"));
                return blog;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    //删除博客
    public void delete(int blogId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getDataSource();
            //2,构造数据库语句
            String sql = "delete from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,blogId);
            //3.执行sql语句
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    //修改博客内容
    public void modifyBlog(Blog blog) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //1,建立连接
            connection = DBUtil.getDataSource();
            //2,构造数据库语句
            //UPDATE users SET name='John' WHERE id=1;
            String sql = "update blog set title=?,content=? where blogId=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,blog.getTitle());
            statement.setString(2,blog.getContent());
            statement.setInt(3,blog.getBlogId());
            statement.executeUpdate();
            //3.执行sql语句
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }
}


