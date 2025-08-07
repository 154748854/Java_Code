package rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ProducerDemo {
    public static void main(String[] args) throws IOException, TimeoutException {
        //1. 建立连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("101.37.182.41");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("study");
        connectionFactory.setPassword("study");
        connectionFactory.setVirtualHost("study");
        Connection connection = connectionFactory.newConnection();
        // 2. 开启信道
        Channel channel = connection.createChannel();
        // 3. 声明交换机 使用内置交换机
        // 4. 声明队列
        /**
         * 队列名称
         * 可持久化
         * 是否独占
         * 是否自动删除
         * argument
         */
        channel.queueDeclare("hello", true, false, false, null);
        // 5. 发送消息
        /**
         * 参数说明:
         * 交换机名称
         * routingKey: 内置交换机, routingKey和队列名称保持一致
         * props
         * body:消息
         */
        String msg = "hello, rabbitmq";
        channel.basicPublish("","hello", null, msg.getBytes());
        // 6, 进行资源释放
        channel.close();
        connection.close();

    }
}
