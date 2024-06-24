package ru.akhmetovdaniyar.democonsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private RedisTemplate <String, String> redisTemplate;

    @KafkaListener(topics = "topic", groupId = "group")
    public void listen (String message) {
        System.out.println("Received message: " + message);
        redisTemplate.opsForValue().set("processed_message", processMessage(message));
    }
    private String processMessage(String message) {
        return message.toUpperCase();      // Пример правила обработки
    }
}
