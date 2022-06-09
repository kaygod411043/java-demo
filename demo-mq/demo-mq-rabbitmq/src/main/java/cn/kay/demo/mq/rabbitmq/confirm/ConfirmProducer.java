package cn.kay.demo.mq.rabbitmq.confirm;

import cn.kay.demo.mq.rabbitmq.IProducer;
import cn.kay.demo.mq.rabbitmq.constant.RabbitExchangeConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Slf4j
@Component
public class ConfirmProducer implements IProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(String routingKey, String content){
        Message message = new Message(content.getBytes());
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            log.info("correlationData: {}, ack: {}, cause: {}", Objects.nonNull(correlationData) ? correlationData.toString() : "", ack, cause);
        });
        rabbitTemplate.convertAndSend(RabbitExchangeConstant.EXCHANGE_AMQ_TOPIC, routingKey, message, new CorrelationData());
        log.info("isConfirmListener: {}", rabbitTemplate.isConfirmListener());
    }
}
