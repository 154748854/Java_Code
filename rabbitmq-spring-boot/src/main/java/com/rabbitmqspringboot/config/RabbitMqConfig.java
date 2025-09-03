package com.rabbitmqspringboot.config;

import com.rabbitmq.client.impl.nio.BlockingQueueNioQueue;
import com.rabbitmqspringboot.constant.Constants;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.constant.Constable;

@Configuration
public class RabbitMqConfig {
    @Bean("workQueue")
    public Queue workQueue() {
        return QueueBuilder.durable(Constants.WORK_QUEUE).build();
    }

    @Bean("fanoutQueue1")
    public Queue fanoutQueue1() {
        return QueueBuilder.durable(Constants.FANOUT_QUEUE1).build();
    }

    @Bean("fanoutQueue2")
    public Queue fanoutQueue2() {
        return QueueBuilder.durable(Constants.FANOUT_QUEUE2).build();
    }

    @Bean("fanoutExchange")
    public FanoutExchange fanoutExchange() {
        return ExchangeBuilder.fanoutExchange(Constants.FANOUT_EXCHANGE).durable(true).build();
    }

    @Bean("fanoutQueueBinding1")
    public Binding fanoutQueueBinding1(@Qualifier("fanoutExchange") FanoutExchange fanoutExchange, @Qualifier("fanoutQueue1") Queue queue) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean("fanoutQueueBinding2")
    public Binding fanoutQueueBinding2(@Qualifier("fanoutExchange") FanoutExchange fanoutExchange, @Qualifier("fanoutQueue2") Queue queue) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    // 路由模式
    @Bean("directQueue1")
    public Queue directQueue1() {
        return QueueBuilder.durable(Constants.DIRECT_QUEUE1).build();
    }
    @Bean("directQueue2")
    public Queue directQueue2() {
        return QueueBuilder.durable(Constants.DIRECT_QUEUE1).build();
    }
    @Bean("directExchange")
    public DirectExchange directExchange() {
        return ExchangeBuilder.directExchange(Constants.DIRECT_EXCHANGE).durable(true).build();
    }
    @Bean("directQueueBinding1")
    public Binding directQueueBinding1(@Qualifier("directExchange") DirectExchange directExchange,@Qualifier("directQueue1") Queue queue) {
        return BindingBuilder.bind(queue).to(directExchange).with("orange");
    }
    @Bean("directQueueBinding2")
    public Binding directQueueBinding2(@Qualifier("directExchange") DirectExchange directExchange,@Qualifier("directQueue2") Queue queue) {
        return BindingBuilder.bind(queue).to(directExchange).with("black");
    }
    @Bean("directQueueBinding3")
    public Binding directQueueBinding3(@Qualifier("directExchange") DirectExchange directExchange,@Qualifier("directQueue2") Queue queue) {
        return BindingBuilder.bind(queue).to(directExchange).with("orange");
    }
}
