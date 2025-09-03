package com.rabbitmqspringboot.listener;

import ch.qos.logback.core.ConsoleAppender;
import com.rabbitmqspringboot.constant.Constants;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutListener {

    @RabbitListener(queues = Constants.FANOUT_QUEUE1)
    public void queueListener(Message message) {
        System.out.println("listener1 ["+Constants.FANOUT_QUEUE1+"] 接受到的消息: "+message);
    }

    @RabbitListener(queues = Constants.FANOUT_QUEUE2)
    public void queueListener(String message) {
        System.out.println("listener2 ["+Constants.FANOUT_QUEUE1+"] 接受到的消息: "+message);
    }
}
