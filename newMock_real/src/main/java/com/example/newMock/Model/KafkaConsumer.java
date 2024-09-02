package com.example.newMock.Model;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "group1", groupId = "my-group")
    public void listen(String message) {
        System.out.println("Received message: ---" + message);
    }
}
