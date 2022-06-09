package cn.kay.demo.mq.rabbitmq.confirm;

import cn.kay.demo.mq.rabbitmq.IProducer;
import cn.kay.demo.mq.rabbitmq.constant.RabbitRoutingKeyConstant;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConfirmProducerTest {

    @Resource
    private IProducer confirmProducer;
    @Test
    void send() {
        this.confirmProducer.send(RabbitRoutingKeyConstant.ROUTING_KEY_PREFIX_GOOD + 1, "order no 1");
    }
}