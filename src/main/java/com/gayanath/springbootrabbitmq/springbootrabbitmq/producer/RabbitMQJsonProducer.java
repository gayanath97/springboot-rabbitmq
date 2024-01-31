package com.gayanath.springbootrabbitmq.springbootrabbitmq.producer;

import com.gayanath.springbootrabbitmq.springbootrabbitmq.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String routing_json_key;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(User jsonMessage) {
        LOGGER.info("Sending message to the qsonQueue using exchange {} routingKey {}. Message= {}", exchange,routing_json_key, jsonMessage.toString());
        rabbitTemplate.convertAndSend(exchange, routing_json_key, jsonMessage);
    }

}
