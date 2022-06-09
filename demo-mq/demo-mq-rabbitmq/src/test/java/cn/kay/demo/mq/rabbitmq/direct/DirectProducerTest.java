package cn.kay.demo.mq.rabbitmq.direct;

import cn.kay.demo.mq.rabbitmq.IProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DirectProducerTest {

    @Resource
    private IProducer directProducer;

    @Test
    void send() {
        directProducer.send("AMQP default test");
    }
}