package com.example.rabbitextensiondemo.listener;

import com.example.rabbitextensiondemo.constant.Constants;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Component
public class QosListener {
    @RabbitListener(queues = Constants.QOS_QUEUE)
    public void handMessage(Message message, Channel channel) throws IOException {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            // 消费者逻辑
            System.out.printf("接受到消息: %s, deliveryTag: %d \n", new String(message.getBody(),"UTF-8"), message.getMessageProperties().getDeliveryTag());
            //进行业务逻辑处理
            System.out.println("业务逻辑处理");
            // 肯定确认
            channel.basicAck(deliveryTag, false);

        } catch(Exception e) {
            channel.basicNack(deliveryTag, false, false);
        }
    }

    @RabbitListener(queues = Constants.QOS_QUEUE)
    public void handMessage2(Message message, Channel channel) throws IOException {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            // 消费者逻辑
            System.out.printf("222接受到消息: %s, deliveryTag: %d \n", new String(message.getBody(),"UTF-8"), message.getMessageProperties().getDeliveryTag());
            //进行业务逻辑处理
            System.out.println("业务逻辑处理");
            // 肯定确认
            channel.basicAck(deliveryTag, false);

        } catch(Exception e) {
            channel.basicNack(deliveryTag, false, false);
        }
    }
}
