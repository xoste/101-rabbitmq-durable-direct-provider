package com.xoste.rabbitmqdurabledirectprovider.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 * @author Leon
 */
@Component
public class Publisher {
    @Autowired
    private AmqpTemplate rabbitmqAmqTemplate;
    @Value("${rabbitmq.config.exchange}")
    private String exchange;
    @Value("${rabbitmq.config.queue.info.routing.key}")
    private String routingkey;

    public void publish(String msg) throws InterruptedException {
        int flag = 0;
        while (true) {
            flag++;
            Thread.sleep(1000);
            this.rabbitmqAmqTemplate.convertAndSend(exchange, routingkey, msg + " " + flag);
        }
    }
}
