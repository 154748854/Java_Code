package com.rabbitmqspringboot.listener;

import com.rabbitmqspringboot.constant.Constants;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicListener {

    @RabbitListener(queues = Constants.TOPIC_QUEUE1)
    public void queueListener(Message message) {
        System.out.println("listener1 ["+Constants.TOPIC_QUEUE1+"] 接受到的消息: "+message);
    }

    @RabbitListener(queues = Constants.TOPIC_QUEUE2)
    public void queueListener(String message) {
        System.out.println("listener2 ["+Constants.TOPIC_QUEUE2+"] 接受到的消息: "+message);
    }
}
