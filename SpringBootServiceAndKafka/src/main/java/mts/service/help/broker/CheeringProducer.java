package mts.service.help.broker;

import mts.service.help.model.CheeringPhrase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class CheeringProducer {

    @Value(value = "${phrase.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, CheeringPhrase> kafkaTemplate;

    public void sendMessage(CheeringPhrase cheeringPhrase) {
        kafkaTemplate.send(topicName, cheeringPhrase);
    }

}
