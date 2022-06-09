package cn.kay.demo.mq.rabbitmq;

import cn.kay.demo.mq.rabbitmq.constant.RabbitExchangeConstant;
import cn.kay.demo.mq.rabbitmq.constant.RabbitQueueConstant;
import cn.kay.demo.mq.rabbitmq.constant.RabbitRoutingKeyConstant;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;

public interface IConsumer {

    default void receiveMessage(Message message){}


    default void receiveMessage(Message message, Channel channel){}
}
