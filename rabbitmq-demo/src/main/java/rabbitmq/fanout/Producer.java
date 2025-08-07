package rabbitmq.fanout;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import rabbitmq.constant.Constants;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

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
        channel.exchangeDeclare(Constants.FANOUT_EXCHANGE, BuiltinExchangeType.FANOUT, true);
        //4. 声明队列
        channel.queueDeclare(Constants.FANOUT_QUEUE1, true, false,false,null);
        channel.queueDeclare(Constants.FANOUT_QUEUE2, true, false,false,null);
        //5. 交换机和队列绑定
        channel.queueBind(Constants.FANOUT_QUEUE1, Constants.FANOUT_EXCHANGE,"");
        channel.queueBind(Constants.FANOUT_QUEUE2, Constants.FANOUT_EXCHANGE,"");
        // 6. 发布消息
        String msg = "hello, fanout~";
        channel.basicPublish(Constants.FANOUT_EXCHANGE,"", null, msg.getBytes());
        // 7, 进行资源释放
        channel.close();
        connection.close();
    }
}
