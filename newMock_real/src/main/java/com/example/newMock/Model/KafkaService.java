package com.example.newMock.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.newMock.Model.KafkaProducer;

@Service
public class KafkaService {

    private static KafkaProducer kafkaProducer;

    @Autowired
    public KafkaService(KafkaProducer kafkaProducer) {
        KafkaService.kafkaProducer = kafkaProducer;
    }

    public static void processAndSend(String data) {
        // Дополнительная обработка данных
        String processedData = "Processed: " + data;

        // Отправка сообщения в Kafka
        kafkaProducer.sendMessage("group1", processedData);
    }
}