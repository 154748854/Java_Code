package rabbitmq;

import com.rabbitmq.client.*;

import javax.net.ssl.HandshakeCompletedEvent;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConsumerDemo {
    public static void main(String[] args) throws IOException, TimeoutException {
        //1. 创建链接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("101.37.182.41");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("study");
        connectionFactory.setPassword("study");
        connectionFactory.setVirtualHost("study");
        Connection connection = connectionFactory.newConnection();
        //2. 创建channel
        Channel channel = connection.createChannel();
        //3. 声明队列(如果这个队列存在的话, 就不会创建新的了.
        channel.queueDeclare("hello",true,false,false,null);
        //4. 消费消息
        /**
         * 参数说明:
         * 队列名
         * 是够自动确认
         * 接收到消息后执行的逻辑
         */
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("接收到消息"+new String(body));
            }
        };
        channel.basicConsume("hello",true, consumer);

        // 5. 释放资源
        channel.close();
        connection.close();
    }
}
