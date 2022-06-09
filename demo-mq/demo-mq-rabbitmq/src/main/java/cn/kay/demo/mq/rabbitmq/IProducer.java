package cn.kay.demo.mq.rabbitmq;

import com.rabbitmq.client.MessageProperties;

public interface IProducer {

    default void send(String message){}

    default void send(String routingKey, String message){}

    default void send(String routingKey, String message, int delayTime){}
}
