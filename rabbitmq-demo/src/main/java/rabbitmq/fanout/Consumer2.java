package rabbitmq.fanout;

import com.rabbitmq.client.*;
import rabbitmq.constant.Constants;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer2 {
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
        //3. 声明队列
        channel.queueDeclare(Constants.FANOUT_QUEUE2, true, false,false,null);
        // 5. 消费
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("接收到消息"+new String(body));
            }
        };
        channel.basicConsume(Constants.FANOUT_QUEUE2,true, consumer);
    }
}
