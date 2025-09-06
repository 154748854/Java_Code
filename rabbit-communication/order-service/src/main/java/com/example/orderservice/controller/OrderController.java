package com.example.orderservice.controller;

import com.example.orderservice.config.RabbitMqConfig;
import com.example.orderservice.model.OrderInfo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/create")
    public String create() {
        // 发送消息
        String orderId = UUID.randomUUID().toString();
        rabbitTemplate.convertAndSend("", "order.create", "订单信息: 订单ID: "+ orderId);
        return "下单成功";
    }

    @RequestMapping("/create2")
    public String create2() {
        // 发送消息
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(UUID.randomUUID().toString());;
        orderInfo.setName("商品"+new Random().nextInt(100));

        rabbitTemplate.convertAndSend("", "order.create", orderInfo);
        return "下单成功";
    }
}
