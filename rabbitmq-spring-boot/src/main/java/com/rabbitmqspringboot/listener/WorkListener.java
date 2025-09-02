package com.rabbitmqspringboot.listener;

import com.rabbitmqspringboot.constant.Constants;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkListener {

    @RabbitListener(queues = Constants.WORK_QUEUE)
    public void queueListener(Message message) {
        System.out.println("["+Constants.WORK_QUEUE+"] 接受到的消息: "+message);
    }
}
