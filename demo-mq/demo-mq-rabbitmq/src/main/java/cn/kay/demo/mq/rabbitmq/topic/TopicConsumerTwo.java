package cn.kay.demo.mq.rabbitmq.topic;

import cn.kay.demo.mq.rabbitmq.IConsumer;
import cn.kay.demo.mq.rabbitmq.constant.RabbitExchangeConstant;
import cn.kay.demo.mq.rabbitmq.constant.RabbitQueueConstant;
import cn.kay.demo.mq.rabbitmq.constant.RabbitRoutingKeyConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class TopicConsumerTwo implements IConsumer {

    @RabbitListener(
            bindings = {@QueueBinding(
                    value = @Queue(value = RabbitQueueConstant.QUEUE_TOPIC, durable = "true"),
                    exchange = @Exchange(value = RabbitExchangeConstant.EXCHANGE_AMQ_TOPIC, type = ExchangeTypes.TOPIC),
                    key = RabbitRoutingKeyConstant.ROUTING_KEY_PREFIX_ORDER + "#"
            )})
    @Override
    public void receiveMessage(Message message){
        log.info("TopicConsumer # receiveMessage: {}", new String(message.getBody(), StandardCharsets.UTF_8));
    }
}
