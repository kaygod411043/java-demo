package cn.kay.demo.mq.rabbitmq.fanout;

import cn.kay.demo.mq.rabbitmq.IProducer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FanoutProducerTest {

    @Resource
    private IProducer fanoutProducer;

    @Test
    void send() {
        fanoutProducer.send("amq.fanout msg test");    }
}