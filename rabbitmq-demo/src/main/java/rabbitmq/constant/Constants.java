package rabbitmq.constant;

public class Constants {
    public static final String HOST = "101.37.182.41";
    public static final int PORT = 5672;
    public static final String USERNAME = "study";
    public static final String PASSWORD = "study";
    public static final String VIRTUAL_HOST = "study";

    // 工作队列模式
    public static final String WORK_QUEUE = "work.queue";
    // 发布订阅模式
    public static final String FANOUT_EXCHANGE = "fanout.exchange";
    public static final String FANOUT_QUEUE1 = "fanout.queue1";
    public static final String FANOUT_QUEUE2 = "fanout.queue2";

    // 路由模式
    public static final String DIRECT_EXCHANGE = "direct.exchange";
    public static final String DIRECT_QUEUE1 = "direct.queue1";
    public static final String DIRECT_QUEUE2 = "direct.queue2";

    // 通配符模式
    public static final String TOPIC_EXCHANGE = "topic_exchange";
    public static final String TOPIC_QUEUE1 = "topic_queue1";
    public static final String TOPIC_QUEUE2 = "topic_queue2";
}
