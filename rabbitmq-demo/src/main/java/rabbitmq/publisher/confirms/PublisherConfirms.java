package rabbitmq.publisher.confirms;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import jdk.swing.interop.SwingInterOpUtils;
import rabbitmq.constant.Constants;

import java.io.IOException;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
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

    /**
     * 异步确认模式
     */
    private static void handlingPublisherConfirmsAsynchronously() throws Exception{
        try (Connection connection = createConnection()){
            // 1. 开启信道
            Channel channel = connection.createChannel();
            // 2. 设置信道为confirm模式
            channel.confirmSelect();
            // 3. 声明队列
            channel.queueDeclare(Constants.PUBLISHER_CONFIRMS_QUEUE1,true, false, false, null);
            // 4. 监听confirm
            // 集合中存储的是未确认的消息Id
            long start = System.currentTimeMillis();
            SortedSet<Long> confirmSeqNo = Collections.synchronizedSortedSet(new TreeSet<>());
            channel.addConfirmListener(new ConfirmListener() {
                @Override
                public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                    if (multiple) {
                        confirmSeqNo.headSet(deliveryTag+1).clear();
                    }else {
                        confirmSeqNo.remove(deliveryTag);
                    }
                }

                @Override
                public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                    if (multiple) {
                        confirmSeqNo.headSet(deliveryTag+1).clear();
                    }else {
                        confirmSeqNo.remove(deliveryTag);
                    }
                    // 根据业务需求. 如重发消息, 此处代码省略
                }
            });
            // 5. 发送消息
            for (int i = 0; i < MESSAGE_COUNT; i++) {
                String msg = "hello publisher confirms..." + i;
                long seqNo = channel.getNextPublishSeqNo();
                channel.basicPublish("",Constants.PUBLISHER_CONFIRMS_QUEUE3,null, msg.getBytes());
                // 当我们发送一条消息之后, 将其放进集合中
                confirmSeqNo.add(seqNo);
            }
            while (!confirmSeqNo.isEmpty()) {
                Thread.sleep(10);
            }
            long end = System.currentTimeMillis();
            System.out.printf("异步确认策略, 消息条数: %d, 耗时: %d ms \n", MESSAGE_COUNT, end-start);
        }
    }

    private static void publishingMessagesInBatches() throws Exception {
        try (Connection connection = createConnection()) {
            // 1. 开启信道
            Channel channel = connection.createChannel();
            // 2. 设置信道为confirm模式
            channel.confirmSelect();
            // 3. 声明队列
            channel.queueDeclare(Constants.PUBLISHER_CONFIRMS_QUEUE1,true, false, false, null);
            // 4. 发送消息, 并进行确认
            int batchSize = 100;
            int outstandingMessageCount = 0;
            long start = System.currentTimeMillis();
            for (int i = 0; i < MESSAGE_COUNT; i++) {
                String msg = "hello publisher confirms..." + i;
                channel.basicPublish("",Constants.PUBLISHER_CONFIRMS_QUEUE2, null, msg.getBytes());
                outstandingMessageCount++;
                if (outstandingMessageCount==batchSize) {
                    channel.waitForConfirmsOrDie(5000);
                    outstandingMessageCount = 0;
                }
            }
            if (outstandingMessageCount>0) {
                channel.waitForConfirmsOrDie(5000);
            }
            long end = System.currentTimeMillis();
            System.out.printf("批量确认策略, 消息条数: %d, 耗时: %d ms \n", MESSAGE_COUNT, end-start);
        }

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
