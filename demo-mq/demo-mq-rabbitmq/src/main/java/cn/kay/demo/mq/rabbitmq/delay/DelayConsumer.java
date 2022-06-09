package cn.kay.demo.mq.rabbitmq.delay;

import cn.kay.demo.mq.rabbitmq.IConsumer;
import cn.kay.demo.mq.rabbitmq.constant.RabbitExchangeConstant;
import cn.kay.demo.mq.rabbitmq.constant.RabbitQueueConstant;
import cn.kay.demo.mq.rabbitmq.constant.RabbitRoutingKeyConstant;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class DelayConsumer implements IConsumer {

    @RabbitListener(
            bindings = {@QueueBinding(
                    value = @Queue(value = RabbitQueueConstant.QUEUE_DELAY, durable = "true"),
                    exchange = @Exchange(value = RabbitExchangeConstant.EXCHANGE_AMQ_DIRECT_DELAY, delayed = Exchange.TRUE)
            )},
            ackMode = "MANUAL")
    @Override
    public void receiveMessage(Message message, Channel channel) {
        log.info("DelayConsumer receiveMessage: {}", message);
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
