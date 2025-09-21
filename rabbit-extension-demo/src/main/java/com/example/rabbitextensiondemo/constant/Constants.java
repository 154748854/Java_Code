package com.example.rabbitextensiondemo.constant;


public class Constants {
    public static final String ACK_QUEUE = "ack.queue";
    public static final String ACK_EXCHANGE = "ack.exchange";

    public static final String PRES_QUEUE = "pers.queue";
    public static final String PRES_EXCHANGE = "pers.exchange";

    // 发送方确认
    public static final String CONFIRM_QUEUE = "confirm.queue";
    public static final String CONFIRM_EXCHANGE = "confirm.exchange";


    // 重试机制
    public static final String RETRY_QUEUE = "retry.queue";
    public static final String RETRY_EXCHANGE = "retry.exchange";

    // ttl
    public static final String TTL_QUEUE = "ttl.queue";
    public static final String TTL_EXCHANGE = "ttl.exchange";
    public static final String TTL_QUEUE2 = "ttl.queue2";

    //DL ttl
    public static final String NORMAL_QUEUE = "normal.queue";
    public static final String NORMAL_EXCHANGE = "normal.exchange";
    public static final String DL_QUEUE = "dl.queue";
    public static final String DL_EXCHANGE = "dl.exchange";

    // 延迟队列
    public static final String DELAY_QUEUE = "delay.queue";
    public static final String DELAY_EXCHANGE = "delay.exchange";

    // 事务
    public static final String TRANS_QUEUE = "trans.queue";

    // 限流
    public static final String QOS_QUEUE = "qos.queue";
    public static final String QOS_EXCHANGE = "qos.exchange";
}
