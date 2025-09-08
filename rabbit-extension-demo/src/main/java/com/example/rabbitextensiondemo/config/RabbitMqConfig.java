package com.example.rabbitextensiondemo.config;

import com.example.rabbitextensiondemo.constant.Constants;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.PrivilegedExceptionAction;

@Configuration
public class RabbitMqConfig {
    // 消息确认
    @Bean("ackQueue")
    public Queue ackQueue() {
        return QueueBuilder.durable(Constants.ACK_QUEUE).build();
    }

    @Bean("directExchange")
    public DirectExchange directExchange() {
        return ExchangeBuilder.directExchange(Constants.ACK_EXCHANGE).build();
    }

    @Bean("ackBinding")
    public Binding ackBinding(@Qualifier("directExchange") DirectExchange directExchange, @Qualifier("ackQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(directExchange).with("ack");
    }

}
