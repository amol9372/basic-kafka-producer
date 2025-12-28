package org.ccdak.practice.basicKafka.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    @Autowired
    Producer producer;

    public void sendMessage(String message) {
        producer.sendMessage(message);
    }

    public void sendMessage(Payload payload) {
        producer.sendMessage(payload);
    }
}
