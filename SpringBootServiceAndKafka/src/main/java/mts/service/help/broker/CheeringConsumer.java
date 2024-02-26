package mts.service.help.broker;

import mts.service.help.model.CheeringPhrase;
import mts.service.help.repository.CheeringInMemRepository;
import org.springframework.kafka.annotation.KafkaListener;

//@ConditionalOnProperty(value = "kafka.sync.enabled", havingValue = "true", matchIfMissing = true)
public class CheeringConsumer {

    CheeringInMemRepository repository;

    public CheeringConsumer(CheeringInMemRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "cheering", groupId = "server.broadcast",containerFactory = "cheeringKafkaListenerContainerFactory")
    public void cheeringListener(CheeringPhrase message) {
        System.out.println("Received Message in group foo: " + message);
        repository.addCheeringPhrase(message);
    }

}
