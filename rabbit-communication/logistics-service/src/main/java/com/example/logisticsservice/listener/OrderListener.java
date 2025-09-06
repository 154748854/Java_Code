package com.example.logisticsservice.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "order.create")
public class OrderListener {
    @RabbitHandler // 根据消息内容, 去选择不同的方法进行捕捉
    public void HandlerMessage(String orderInfo) {
        System.out.println("接受到订单消息: "+ orderInfo);

    }
}
