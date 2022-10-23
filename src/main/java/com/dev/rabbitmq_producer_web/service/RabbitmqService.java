package com.dev.rabbitmq_producer_web.service;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private TopicExchange topicExchange;

    public void sendMessageAll(String msg) {
        rabbitTemplate.convertAndSend("", msg);
    }

    public void sendToAIProfiler(String routingKey, String msg) {
        System.out.println(topicExchange.getName());
        System.out.println(routingKey);
        System.out.println(msg);

        for(int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend(topicExchange.getName(), routingKey, i);
        }

    }

    public void sendToSystemProfiler(String msg) {
        rabbitTemplate.convertAndSend("", msg);
    }
}