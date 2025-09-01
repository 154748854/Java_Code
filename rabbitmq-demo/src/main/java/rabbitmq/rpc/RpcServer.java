package rabbitmq.rpc;

import com.rabbitmq.client.*;
import rabbitmq.constant.Constants;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * RPC 客户端
 * 接受请求
 * 发送响应
 */
public class RpcServer {
    public static void main(String[] args) throws IOException, TimeoutException {
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
        // 3. 接收请求
        channel.basicQos(1);
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String request = new String(body,"UTF-8");
                System.out.println("接受到请求: "+ request);
                String response = "针对request: "+ request + ", 响应成功";
                AMQP.BasicProperties basicProperties = new AMQP.BasicProperties().builder()
                        .correlationId(properties.getCorrelationId())
                        .build();
                channel.basicPublish("",Constants.RPC_RESPONSE_QUEUE, basicProperties, response.getBytes());
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(Constants.RPC_REQUEST_QUEUE, false, consumer);
    }
}
