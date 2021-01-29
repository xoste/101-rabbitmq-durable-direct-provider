package com.xoste.rabbitmqdurabledirectprovider;

import com.xoste.rabbitmqdurabledirectprovider.publisher.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private Publisher publisher;

    @Test
    void contextLoads() throws InterruptedException {
        this.publisher.publish("消息发送者");
    }

}
