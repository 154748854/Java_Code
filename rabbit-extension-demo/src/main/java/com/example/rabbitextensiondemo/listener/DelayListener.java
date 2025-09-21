package com.example.rabbitextensiondemo.listener;

import com.example.rabbitextensiondemo.constant.Constants;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
public class DelayListener {
    @RabbitListener(queues = Constants.DELAY_QUEUE)
    public void dlHandMessage(Message message, Channel channel) throws IOException {
        // 消费者逻辑
        System.out.printf("时间: %tc 接受到消息: %s \n", new Date(),new String(message.getBody(),"UTF-8"));

    }
}
