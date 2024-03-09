package mts.service.help.services;

import mts.service.help.broker.interfaces.Consumer;
import mts.service.help.broker.interfaces.Producer;
import mts.service.help.interfaces.CheeringService;
import mts.service.help.model.CheeringPhrase;
import mts.service.help.repository.CheeringInMemRepository;
import mts.service.help.view.CheeringRequest;
import mts.service.help.view.CheeringResponse;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

public class CheeringServiceKafkaImp implements CheeringService {

    private CheeringInMemRepository repository;
    private Producer<CheeringPhrase> producer;
    private Consumer consumer;

    public CheeringServiceKafkaImp(CheeringInMemRepository repository, Producer<CheeringPhrase> producer, Consumer consumer) {
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
        if (!repository.alreadyContains(cheeringPhrase)) {
            repository.addCheeringPhrase(cheeringPhrase);
            producer.sendMessage(cheeringPhrase);
        }
        return new CheeringResponse("Фраза " + cheeringPhrase.getPhrase() + " добавлена", HttpStatus.CREATED);
    }
}
