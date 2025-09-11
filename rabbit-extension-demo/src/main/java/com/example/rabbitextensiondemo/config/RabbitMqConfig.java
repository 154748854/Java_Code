package com.example.rabbitextensiondemo.config;

import com.example.rabbitextensiondemo.constant.Constants;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.stats.ExponentialAverageRetryStatistics;

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

    // 持久化
    @Bean("presQueue")
    public Queue presQueue() {
        return QueueBuilder.nonDurable(Constants.PRES_QUEUE).build();
    }

    @Bean("presExchange")
    public DirectExchange presExchange() {
        return ExchangeBuilder.directExchange(Constants.PRES_EXCHANGE).durable(false).build();
    }

    @Bean("presBinding")
    public Binding presBinding(@Qualifier("presQueue") Queue queue, @Qualifier("presExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("pres").noargs();
    }

    // 发送方确认
    @Bean("confirmQueue")
    public Queue confirmQueue() {
        return QueueBuilder.durable(Constants.CONFIRM_QUEUE).build();
    }

    @Bean("confirmExchange")
    public Exchange confirmExchange() {
        return ExchangeBuilder.directExchange(Constants.CONFIRM_EXCHANGE).build();
    }

    @Bean("confirmBinding")
    public Binding confirmBinding(@Qualifier("confirmExchange") Exchange exchange, @Qualifier("confirmQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("confirm").noargs();
    }

    // 重试机制
    @Bean("retryQueue")
    public Queue retryQueue() {
        return QueueBuilder.durable(Constants.RETRY_QUEUE).build();
    }

    @Bean("retryExchange")
    public Exchange retryExchange() {
        return ExchangeBuilder.directExchange(Constants.RETRY_EXCHANGE).build();
    }

    @Bean("retryBinding")
    public Binding retryBinding(@Qualifier("retryQueue") Queue queue, @Qualifier("retryExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("retry").noargs();
    }

    // ttl
    @Bean("ttlQueue")
    public Queue ttlQueue() {
        return QueueBuilder.durable(Constants.TTL_QUEUE).build();
    }

    @Bean("ttlExchange")
    public Exchange ttlExchange() {
        return ExchangeBuilder.directExchange(Constants.TTL_EXCHANGE).build();
    }

    @Bean("ttlBinding")
    public Binding ttlBinding(@Qualifier("ttlExchange") Exchange exchange, @Qualifier("ttlQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("ttl").noargs();
    }
}
