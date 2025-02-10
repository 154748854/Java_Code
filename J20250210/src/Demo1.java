import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo1 {
    public static void main(String[] args) throws SQLException {
        //1. 创建datasource
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java2025?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1234");

        //2. 建立和数据库之间的连接
        Connection connection =  dataSource.getConnection();

        //3. 构造sql (代码中的sql不用写分号;
        String sql = "insert into student values(1, '张三')";
        PreparedStatement statement = connection.prepareStatement(sql);

        //4，把sql发送给服务器。执行sql
        //返回值是一个整数，表示影响到的行数
        int n = statement.executeUpdate();

        System.out.println(n);

        //5. 执行完毕之后，最后一个步骤，关闭连接，释放资源(释放顺序是后获取到的资源先释放
        // 程序通过代码和服务器进行通信，是需要消耗一定的硬件/软件资源，这程序结束的时候需要告知服务器释放资源
        statement.close();
        connection.close();
    }
}
