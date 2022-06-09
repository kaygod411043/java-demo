package cn.kay.demo.mq.rabbitmq.direct;

import cn.kay.demo.mq.rabbitmq.IProducer;
import cn.kay.demo.mq.rabbitmq.constant.RabbitQueueConstant;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DirectProducer implements IProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(String content){
        Message message = new Message(content.getBytes());
        rabbitTemplate.send(RabbitQueueConstant.QUEUE_TEST, message);
    }
}
