package cn.kay.demo.mq.rabbitmq.topic;

import cn.kay.demo.mq.rabbitmq.IProducer;
import cn.kay.demo.mq.rabbitmq.constant.RabbitExchangeConstant;
import cn.kay.demo.mq.rabbitmq.constant.RabbitRoutingKeyConstant;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TopicProducer implements IProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(String routingKey, String content){
        Message message = new Message(content.getBytes());
        rabbitTemplate.send(RabbitExchangeConstant.EXCHANGE_AMQ_TOPIC, routingKey, message);
    }
}
