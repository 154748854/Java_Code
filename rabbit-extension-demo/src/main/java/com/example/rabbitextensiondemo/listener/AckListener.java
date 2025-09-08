package com.example.rabbitextensiondemo.listener;

import com.example.rabbitextensiondemo.constant.Constants;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class AckListener {
    @RabbitListener(queues = Constants.ACK_QUEUE)
    public void handMessage(Message message, Channel channel) throws UnsupportedEncodingException {
        // 消费者逻辑
        System.out.printf("接受到消息: %s, deliveryTag: %d \n", new String(message.getBody(),"UTF-8"), message.getMessageProperties().getDeliveryTag());

        //进行业务逻辑处理
        System.out.println("业务逻辑处理");



    }
}
