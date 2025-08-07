package rabbitmq.work;

import com.rabbitmq.client.*;
import rabbitmq.constant.Constants;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer1 {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(Constants.HOST);
        connectionFactory.setPort(Constants.PORT);
        connectionFactory.setUsername(Constants.USERNAME);
        connectionFactory.setPassword(Constants.PASSWORD);
        connectionFactory.setVirtualHost(Constants.VIRTUAL_HOST);
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
        channel.queueDeclare(Constants.WORK_QUEUE, true, false, false, null);
        // 5. 消费
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("接收到消息"+new String(body));
            }
        };
        channel.basicConsume(Constants.WORK_QUEUE,true, consumer);
        // 6, 进行资源释放
        channel.close();
        connection.close();
    }
}
