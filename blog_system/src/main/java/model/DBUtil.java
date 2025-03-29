package model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 通过这个类来封装数据库建立连接的操作
// 由于接下来代码中有多个servlet都需要使用数据库,就需要有一个单独的地方来来把datasource 这里的操作来啊进行封装
// 而不是只是放到某个 servlet 的init之中了
// 此处可以使用 单例模式 来表示datasource这样的数据源
public class DBUtil {
    private volatile static DataSource datasource = null;

    private static DataSource getDatasource() {
        if(datasource == null) {
            synchronized (DBUtil.class) {
                if (datasource == null) {
                    datasource = new MysqlDataSource();
                    ((MysqlDataSource)datasource).setUrl("jdbc:mysql://127.0.0.1:3306/java_blog_system?characterEncoding=utf8&useSSL=false");
                    ((MysqlDataSource)datasource).setUser("root");
                    ((MysqlDataSource)datasource).setPassword("2222");
                }
            }
        }
        return datasource;
    }

    public static Connection getConnection() throws SQLException {
        return getDatasource().getConnection();
    }
    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
