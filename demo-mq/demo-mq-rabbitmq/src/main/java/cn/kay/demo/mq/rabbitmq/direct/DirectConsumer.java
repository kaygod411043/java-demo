package cn.kay.demo.mq.rabbitmq.direct;

import cn.kay.demo.mq.rabbitmq.constant.RabbitQueueConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class DirectConsumer{

    @RabbitListener(queuesToDeclare = @Queue(RabbitQueueConstant.QUEUE_TEST))
    public void receiveMessage(Message message){
        log.info("receiveMessage: {}", new String(message.getBody(), StandardCharsets.UTF_8));
    }
}
