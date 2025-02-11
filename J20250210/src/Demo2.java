import com.mysql.jdbc.JDBC4PreparedStatement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo2 {
    public static void main(String[] args) throws SQLException {
        //1. 创建datasource
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java2025?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("1234");

        //2. 建立连接
        Connection connection = dataSource.getConnection();

        //3. 构造sql
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);

        //4. 执行sql
        // ResultSet 就表示查询结果（临时表）
        ResultSet resultSet = statement.executeQuery();

        //5, 遍历临时表
        // 通过next方法 就可以获取到临时表中每一行数据，如果获取到最后一行之后，在执行next 返回false，循环结束
        while (resultSet.next()) {
            //针对这一行进行处理
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println(id+" "+name);
        }

        //6. 释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
