package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 通过blogDao来完成针对blog表的操作
public class BlogDao {
    // 1. 新增操作(提价博客就会用到)
    public void inser(Blog blog) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 1. 建立连接
            connection = DBUtil.getConnection();
            // 2. 构造sql语句
            String sql = "insert into blog values (null, ?, ?, now(), ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, blog.getTitle());
            statement.setString(2, blog.getContent());
            statement.setInt(3, blog.getUserId());
            // 3. 执行sql
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    // 2. 查询博客列表(博客列表页)
    //    把数据库里所有的博客都拿到
    public List<Blog> getBlogs() {
        List<Blog> blogList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from blog";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                // 此处读到的正文是整个文章的正文,太多了,博客列表页,只希望显示一小部分
                // 此处需要对 content 做一个简单的截断
                String content = resultSet.getString("content");
                if (content.length() > 100) {
                    content =  content.substring(0,100) + "...";
                }
                blog.setContent(content);
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blog.setUserId(resultSet.getInt("userId"));
                blogList.add(blog);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return blogList;
    }

    // 3. 根据博客 id 查询指定的博客
    public Blog getBlog(int blogId) {
        // TODO
        return null;
    }

    // 4. 根据博客 id, 删除博客
    public void delete(int blogId) {
        // TODO
    }

}
