package cn.kay.demo.mq.rabbitmq.fanout;

import cn.kay.demo.mq.rabbitmq.IProducer;
import cn.kay.demo.mq.rabbitmq.constant.RabbitExchangeConstant;
import cn.kay.demo.mq.rabbitmq.constant.RabbitQueueConstant;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class FanoutProducer implements IProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(String content){
        Message message = new Message(content.getBytes());
        rabbitTemplate.send(RabbitExchangeConstant.EXCHANGE_AMQ_FANOUT, "", message);

    }
}
