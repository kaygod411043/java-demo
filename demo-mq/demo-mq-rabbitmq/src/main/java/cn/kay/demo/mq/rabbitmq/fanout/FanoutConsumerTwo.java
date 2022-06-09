package cn.kay.demo.mq.rabbitmq.fanout;

import cn.kay.demo.mq.rabbitmq.IConsumer;
import cn.kay.demo.mq.rabbitmq.constant.RabbitExchangeConstant;
import cn.kay.demo.mq.rabbitmq.constant.RabbitQueueConstant;
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
public class FanoutConsumerTwo implements IConsumer {

    @RabbitListener(
            bindings = {@QueueBinding(
                    value = @Queue(value = RabbitQueueConstant.QUEUE_FANOUT_TWO, durable = "true"),
                    exchange = @Exchange(value = RabbitExchangeConstant.EXCHANGE_AMQ_FANOUT, type = ExchangeTypes.FANOUT)
            )})
    @Override
    public void receiveMessage(Message message){
        log.info("FanoutConsumerTwo receiveMessage: {}", new String(message.getBody(), StandardCharsets.UTF_8));
    }
}
