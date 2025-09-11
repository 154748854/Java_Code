package com.example.rabbitextensiondemo.controller;

import com.example.rabbitextensiondemo.config.RabbitTemplateConfig;
import com.example.rabbitextensiondemo.constant.Constants;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.concurrent.Callable;

@RequestMapping("/producer")
@RestController
public class ProducerController {
    @Resource(name = "rabbitTemplate")
    private RabbitTemplate rabbitTemplate;
    @Resource(name = "confirmRabbitTemplate")
    private RabbitTemplate confirmRabbitTemplate;

    @RequestMapping("/ack")
    public String ack() {
        rabbitTemplate.convertAndSend(Constants.ACK_EXCHANGE, "ack", "ack ack mode test...");
        return "消息发送成功";
    }

    @RequestMapping("/pres")
    public String pres() {
        Message message = new Message("Persistent test...".getBytes(), new MessageProperties());
        message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT);
        rabbitTemplate.convertAndSend(Constants.PRES_EXCHANGE, "pres", message);
        return "发送成功";
    }

    @RequestMapping("/confirm")
    public String confirm() {
        // 这只回调方法
        // 单例模式, 不能在这里直接设置Tem
        CorrelationData correlationData = new CorrelationData("1");
        confirmRabbitTemplate.convertAndSend(Constants.CONFIRM_EXCHANGE, "confirm", "confirm test...", correlationData);
        return "发送成功";
    }

    @RequestMapping("/returns")
    public String returns() {
        CorrelationData correlationData = new CorrelationData("5");
        confirmRabbitTemplate.convertAndSend(Constants.CONFIRM_EXCHANGE, "confirm", "return test...", correlationData);
        return "发送成功";
    }

    @RequestMapping("/retry")
    public String retry() {
        rabbitTemplate.convertAndSend(Constants.CONFIRM_EXCHANGE, "retry", "retry test...");
        return "消息发送成功";
    }

    @RequestMapping("/ttl")
    public String ttl() {

        rabbitTemplate.convertAndSend(Constants.TTL_EXCHANGE, "ttl", "ttl test...",message -> {
            message.getMessageProperties().setExpiration("10000"); // 设置消息过期时间, 单位是ms
            return message;
        });
        return "消息发送成功";
    }

}
