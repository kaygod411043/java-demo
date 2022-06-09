package cn.kay.demo.mq.rabbitmq.delay;

import cn.kay.demo.mq.rabbitmq.IProducer;
import cn.kay.demo.mq.rabbitmq.constant.RabbitQueueConstant;
import cn.kay.demo.mq.rabbitmq.constant.RabbitRoutingKeyConstant;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DelayProducerTest {

    @Resource
    private IProducer delayProducer;

    @Test
    void send() {
        this.delayProducer.send(RabbitQueueConstant.QUEUE_DELAY, "delay test", 1000 * 20);
    }
}