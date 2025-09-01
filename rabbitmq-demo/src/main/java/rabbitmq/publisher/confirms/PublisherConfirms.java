package rabbitmq.publisher.confirms;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import rabbitmq.constant.Constants;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class PublisherConfirms {
    private static final Integer MESSAGE_COUNT = 200;
    static Connection createConnection() throws Exception {
        //1. 建立连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(Constants.HOST);
        connectionFactory.setPort(Constants.PORT);
        connectionFactory.setUsername(Constants.USERNAME);
        connectionFactory.setPassword(Constants.PASSWORD);
        connectionFactory.setVirtualHost(Constants.VIRTUAL_HOST);
        return connectionFactory.newConnection();
    }

    public static void main(String[] args) throws Exception {
        // 一 单独确认
        publishingMessagesIndividually();
        // 二 批量确认
        publishingMessagesInBatches();
        // 三 异步确认
        handlingPublisherConfirmsAsynchronously();
    }

    private static void handlingPublisherConfirmsAsynchronously() {
    }

    private static void publishingMessagesInBatches() {

    }

    /**
     * 单独确认
     */
    private static void publishingMessagesIndividually() throws Exception {
        try(Connection connection = createConnection()) {
            // 1. 开启信道
            Channel channel = connection.createChannel();
            // 2. 设置信道为confirm模式
            channel.confirmSelect();
            // 3.声明队列(交换机用默认的
            channel.queueDeclare(Constants.PUBLISHER_CONFIRMS_QUEUE1,true, false, false, null);
            // 4. 发送消息并等待确认
            long start = System.currentTimeMillis();
            for (int i = 0; i < MESSAGE_COUNT; i++) {
                String msg = "hello publisher confirms" + i;
                channel.basicPublish("", Constants.PUBLISHER_CONFIRMS_QUEUE1, null, msg.getBytes());
                // 等待确认
                channel.waitForConfirmsOrDie(5000);
            }
            long end = System.currentTimeMillis();
            System.out.printf("单独确认策略, 消息条数: %d, 耗时: %d ms \n", MESSAGE_COUNT, end-start);
        }
    }
}
