package rabbitmq.rpc;

import com.rabbitmq.client.*;
import rabbitmq.constant.Constants;

import javax.net.ssl.HandshakeCompletedEvent;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

/**
 * rpc 客户端
 * 1. 发送请求
 * 2. 接受响应
 */
public class RpcClient {
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        // 1. 建立连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(Constants.HOST);
        connectionFactory.setPort(Constants.PORT);
        connectionFactory.setUsername(Constants.USERNAME);
        connectionFactory.setPassword(Constants.PASSWORD);
        connectionFactory.setVirtualHost(Constants.VIRTUAL_HOST);
        Connection connection = connectionFactory.newConnection();
        // 2. 开启信道
        Channel channel = connection.createChannel();
        channel.queueDeclare(Constants.RPC_REQUEST_QUEUE, true, false, false, null);
        channel.queueDeclare(Constants.RPC_RESPONSE_QUEUE, true, false, false, null);
        // 3. 发送请求
        String msg = "hello rpc~...";
        // 设置请求唯一标识
        String correlationId = UUID.randomUUID().toString();
        // 设置请求的相关属性
        AMQP.BasicProperties props = new AMQP.BasicProperties().builder()
                .correlationId(correlationId)
                .replyTo(Constants.RPC_RESPONSE_QUEUE)
                .build();
        channel.basicPublish("",Constants.RPC_REQUEST_QUEUE,props,msg.getBytes());

        // 4. 接受响应
        // 使用阻塞队列, 来存储响应信息
        final BlockingQueue<String> response = new ArrayBlockingQueue<>(1);
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String respMsg = new String(body);
                System.out.println("接收到回调消息: "+ respMsg);
                if (correlationId.equals(properties.getCorrelationId())) {
                    // 校验一致,则响应使我们想要的
                    response.offer(respMsg);
                }
            }
        };
        channel.basicConsume(Constants.RPC_RESPONSE_QUEUE, true,consumer);
        String result = response.take();
        System.out.println("[RPC Client 响应结果]: " + result);
    }
}
