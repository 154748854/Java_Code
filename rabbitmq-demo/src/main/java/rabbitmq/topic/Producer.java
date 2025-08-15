package rabbitmq.topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import rabbitmq.constant.Constants;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 通配符模式
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
        channel.exchangeDeclare(Constants.TOPIC_EXCHANGE, BuiltinExchangeType.TOPIC, true);
        // 4. 声明队列
        channel.queueDeclare(Constants.TOPIC_QUEUE1,true,false,false,null);
        channel.queueDeclare(Constants.TOPIC_QUEUE2,true,false,false,null);
        // 5. 绑定交换机和队列
        channel.queueBind(Constants.TOPIC_QUEUE1,Constants.TOPIC_EXCHANGE,"*.a.*");
        channel.queueBind(Constants.TOPIC_QUEUE2,Constants.TOPIC_EXCHANGE,"*.*.b");
        channel.queueBind(Constants.TOPIC_QUEUE2,Constants.TOPIC_EXCHANGE,"c.#");
        // 6.发送消息
        String msg = "hello, topic,my routing key is ae.a.f~";
        channel.basicPublish(Constants.TOPIC_EXCHANGE,"ae.a.f", null, msg.getBytes()); // 转发到Q1

        String msg_b = "hello, topic,my routing key is ef.a.b~";
        channel.basicPublish(Constants.TOPIC_EXCHANGE,"ef.a.b", null, msg_b.getBytes());// 转发到Q1,Q2

        String msg_c = "hello, topic,my routing key is c.ef.d~";
        channel.basicPublish(Constants.TOPIC_EXCHANGE,"c.ef.d", null, msg_c.getBytes());// 转发到Q2

        System.out.println("消息发送成功");
        // 7. 释放资源
        channel.close();
        connection.close();

    }
}
