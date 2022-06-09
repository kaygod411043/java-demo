package cn.kay.demo.mq.rabbitmq.constant;

public abstract class RabbitExchangeConstant {

    /**
     * RabbitMQ 默认 fanout
     */
    public static final String EXCHANGE_AMQ_FANOUT = "amq.fanout";

    /**
     * RabbitMQ 默认 topic
     */
    public static final String EXCHANGE_AMQ_TOPIC = "amq.topic";

    /**
     * RabbitMQ 延迟队列交换机
     */
    public static final String EXCHANGE_AMQ_DIRECT_DELAY = "test.direct.delay";


}
