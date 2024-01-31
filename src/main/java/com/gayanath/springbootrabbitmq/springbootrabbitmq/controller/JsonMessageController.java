package com.gayanath.springbootrabbitmq.springbootrabbitmq.controller;

import com.gayanath.springbootrabbitmq.springbootrabbitmq.dto.User;
import com.gayanath.springbootrabbitmq.springbootrabbitmq.producer.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class JsonMessageController {

    private RabbitMQJsonProducer rabbitMQJsonProducer;

    public JsonMessageController(RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody User jsonMessage) {
        rabbitMQJsonProducer.sendMessage(jsonMessage);
        return ResponseEntity.ok("Message sent to the RabbitMQ Successfully");
    }
}
