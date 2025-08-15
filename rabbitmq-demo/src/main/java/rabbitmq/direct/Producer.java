package rabbitmq.direct;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import rabbitmq.constant.Constants;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 路由模式生产者
 */
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //1. 建立连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(Constants.HOST);
        connectionFactory.setPort(Constants.PORT);
        connectionFactory.setUsername(Constants.USERNAME);
        connectionFactory.setPassword(Constants.PASSWORD);
        connectionFactory.setVirtualHost(Constants.VIRTUAL_HOST);
        Connection connection = connectionFactory.newConnection();
        // 2. 开启信道
        Channel channel = connection.createChannel();
        // 3. 声明交换机
        channel.exchangeDeclare(Constants.DIRECT_EXCHANGE, BuiltinExchangeType.DIRECT, true);
        // 4. 声明队列
        channel.queueDeclare(Constants.DIRECT_QUEUE1,true,false,false,null);
        channel.queueDeclare(Constants.DIRECT_QUEUE2,true,false,false,null);
        // 5. 绑定交换机和队列
        channel.queueBind(Constants.DIRECT_QUEUE1,Constants.DIRECT_EXCHANGE,"a");
        channel.queueBind(Constants.DIRECT_QUEUE2,Constants.DIRECT_EXCHANGE,"a");
        channel.queueBind(Constants.DIRECT_QUEUE2,Constants.DIRECT_EXCHANGE,"b");
        channel.queueBind(Constants.DIRECT_QUEUE2,Constants.DIRECT_EXCHANGE,"c");
        // 6.发送消息
        String msg = "hello, direct,my routing key is a~";
        channel.basicPublish(Constants.DIRECT_EXCHANGE,"a", null, msg.getBytes());

        String msg_b = "hello, direct,my routing key is b~";
        channel.basicPublish(Constants.DIRECT_EXCHANGE,"b", null, msg_b.getBytes());

        String msg_c = "hello, direct,my routing key is c~";
        channel.basicPublish(Constants.DIRECT_EXCHANGE,"c", null, msg_c.getBytes());

        System.out.println("消息发送成功");
        // 7. 释放资源
        channel.close();
        connection.close();

    }
}
