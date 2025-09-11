package com.example.rabbitextensiondemo.listener;

import com.example.rabbitextensiondemo.constant.Constants;
import org.springframework.amqp.core.Message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

@Component
public class RetryListener {
    @RabbitListener(queues = Constants.RETRY_QUEUE)
    public void handlerMessage(Message message) throws UnsupportedEncodingException {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        // 业务逻辑处理
        System.out.printf("["+Constants.RETRY_QUEUE+"] 接受到的消息: %s, deliveryTag: %s \n", new String(message.getBody(),"UTF8"), deliveryTag);
    }
}
