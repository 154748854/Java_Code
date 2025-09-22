package com.example.rabbitmqopsdemo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    @Bean("quorumQueue")
    public Queue quorumQueue() {
        return QueueBuilder.durable("quorum.queue").quorum().build();
    }

    @Bean("clusterQueue")
    public Queue clusterQueue() {
        return QueueBuilder.durable("cluster.queue").quorum().build();
    }
}
