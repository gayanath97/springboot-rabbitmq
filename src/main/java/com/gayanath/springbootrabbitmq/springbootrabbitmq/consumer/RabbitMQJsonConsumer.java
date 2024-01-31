package com.gayanath.springbootrabbitmq.springbootrabbitmq.consumer;

import com.gayanath.springbootrabbitmq.springbootrabbitmq.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.json.name}")
    public void consumeMessage(User jsonMessage) {
        LOGGER.info("Message received {}", jsonMessage);
    }

}
