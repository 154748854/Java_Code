package com.rabbitmqspringboot.config;

import com.rabbitmqspringboot.constant.Constants;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.constant.Constable;

@Configuration
public class RabbitMqConfig {
    @Bean("workQueue")
    public Queue workQueue() {
        return QueueBuilder.durable(Constants.WORK_QUEUE).build();
    }
}
