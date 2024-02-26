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

    @KafkaListener(topics = "${phrase.topic.name}", groupId = "${kafka.group.id}",containerFactory = "cheeringKafkaListenerContainerFactory")
    public void cheeringListener(CheeringPhrase message) {
        System.out.println("Получено сообщение из брокера: " + message);
        repository.addCheeringPhrase(message);
        System.out.println("Записали в БД в консьюмере: " + message);
    }

}
