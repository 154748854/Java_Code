package com.example.rabbitextensiondemo.config;

import com.example.rabbitextensiondemo.constant.Constants;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DLConfig {
    // 正常交换机和队列
    @Bean("normalQueue")
    public Queue normalQueue() {
        return QueueBuilder.durable(Constants.NORMAL_QUEUE)
                .deadLetterRoutingKey(Constants.DL_EXCHANGE)
                .deadLetterRoutingKey("dlx")
                .ttl(10000)
                .maxLength(10)
                .build();
    }

    @Bean("normalExchange")
    public DirectExchange normalExchange() {
        return ExchangeBuilder.directExchange(Constants.NORMAL_EXCHANGE).build();
    }

    @Bean("normalBinding")
    public Binding normalBinding(@Qualifier("normalExchange") Exchange exchange, @Qualifier("normalQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("normal").noargs();
    }

    // 死信
    @Bean("dlQueue")
    public Queue DlQueue() {
        return QueueBuilder.durable(Constants.DL_QUEUE).build();
    }

    @Bean("dlExchange")
    public DirectExchange dlExchange() {
        return ExchangeBuilder.directExchange(Constants.DL_EXCHANGE).build();
    }

    @Bean("dlBinding")
    public Binding dlBinding(@Qualifier("dlExchange") Exchange exchange, @Qualifier("dlQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("dlx").noargs();
    }
}
