package org.ccdak.practice.basicKafka.controller;

import org.ccdak.practice.basicKafka.messaging.MainService;
import org.ccdak.practice.basicKafka.messaging.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class KafkaController {

    @Autowired
    MainService mainService;

    @PostMapping("send")
    public void sendMessage(@RequestBody Payload payload) {
        mainService.sendMessage(payload);
    }

}
