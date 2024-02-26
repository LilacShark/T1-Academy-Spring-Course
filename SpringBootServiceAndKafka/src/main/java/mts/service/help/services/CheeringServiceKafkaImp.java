package mts.service.help.services;

import mts.service.help.broker.CheeringConsumer;
import mts.service.help.broker.CheeringProducer;
import mts.service.help.interfaces.CheeringService;
import mts.service.help.model.CheeringPhrase;
import mts.service.help.repository.CheeringInMemRepository;
import mts.service.help.view.CheeringRequest;
import mts.service.help.view.CheeringResponse;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

public class CheeringServiceKafkaImp implements CheeringService {

    private CheeringInMemRepository repository;
    private CheeringProducer producer;
    private CheeringConsumer consumer;

    public CheeringServiceKafkaImp(CheeringInMemRepository repository, CheeringProducer producer, CheeringConsumer consumer) {
        this.repository = repository;
        this.producer = producer;
        this.consumer = consumer;
    }

    public CheeringServiceKafkaImp() {
    }

    public CheeringPhrase getCheeringPhrase() {
        return repository.getCheeringPhrase();
    }

    @Transactional
    public CheeringResponse addCheeringPhrase(CheeringRequest request) {
        CheeringPhrase cheeringPhrase = request.getCheeringPhrase();
        repository.addCheeringPhrase(cheeringPhrase);
        System.out.println("Записали в БД: " + cheeringPhrase);
        producer.sendMessage(cheeringPhrase);

        return new CheeringResponse("Фраза " + cheeringPhrase.getPhrase() + " добавлена", HttpStatus.CREATED);
    }

}
