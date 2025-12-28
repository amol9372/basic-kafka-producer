package org.ccdak.practice.basicKafka.messaging;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public Producer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    //  @Transactional("kafkaTransactionManager")
    public void sendMessage(String message) {
        String key = String.valueOf((int) (Math.random() * 10));

        //    for(int i = 1; i <= 5; i++ ){
        ////      if(i > 5)
        ////        throw new RuntimeException("aborted");
        //      kafkaTemplate.send("orders", String.valueOf(i),
        // message.concat("-").concat(String.valueOf(i)));
        //    }

        Payload payload = Payload.newBuilder().setMessage("random-json-attribute").build();
        kafkaTemplate.send("orders", key, payload);

//    kafkaTemplate.send("orders", key, message.concat("-2"));
//    kafkaTemplate.send("orders", key, message.concat("-3"));
//    kafkaTemplate.send("orders", key, message.concat("-4"));
//    kafkaTemplate.send("orders", key, message.concat("-5"));
//    kafkaTemplate.send("orders", key, message.concat("-6"));

        //    CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("orders", key,
        // message);
        //
        //    future.whenComplete(
        //        (result, ex) -> {
        //          if (ex == null) {
        //            System.out.println(
        //                "Sent message=["
        //                    + message
        //                    + "] with offset=["
        //                    + result.getRecordMetadata().offset()
        //                    + "]");
        //          } else {
        //            System.err.println(
        //                "Unable to send message=[" + message + "] due to : " + ex.getMessage());
        //          }
        //        });
    }

    public void sendMessage(Payload payload) {
        String key = String.valueOf((int) (Math.random() * 10));

        kafkaTemplate.send("orders", key, payload);
    }
}

