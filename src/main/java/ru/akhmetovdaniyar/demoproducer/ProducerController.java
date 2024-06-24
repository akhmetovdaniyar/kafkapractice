package ru.akhmetovdaniyar.demoproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "topic";

    @PostMapping("/publish")
    public String publishMessage(@RequestBody String message) {
        kafkaTemplate.send(TOPIC, message);
        return "Message published successfully!";
    }

}