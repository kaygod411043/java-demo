package cn.kay.demo.mq.rabbitmq.topic;

import cn.kay.demo.mq.rabbitmq.IProducer;
import cn.kay.demo.mq.rabbitmq.constant.RabbitRoutingKeyConstant;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TopicProducerTest {

    @Resource
    private IProducer topicProducer;

    @Test
    void send() {
        this.topicProducer.send(RabbitRoutingKeyConstant.ROUTING_KEY_PREFIX_ORDER + 1, "order no 1");
    }

    @Test
    void send2() {
        this.topicProducer.send(RabbitRoutingKeyConstant.ROUTING_KEY_PREFIX_ORDER + "11.22", "order no 11.22");
    }
}