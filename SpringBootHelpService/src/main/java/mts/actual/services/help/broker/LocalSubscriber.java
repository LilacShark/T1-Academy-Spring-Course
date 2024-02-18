package mts.actual.services.help.broker;

import mts.actual.services.help.interfaces.CheeringService;
import mts.actual.services.help.model.CheeringPhrase;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LocalSubscriber implements Subscriber {

    private CheeringService service;
    private MessageBroker broker;


    public LocalSubscriber(CheeringService service, MessageBroker broker) {
        this.service = service;
        this.broker = broker;
    }



    public void pollMessage() {
        CheeringPhrase poll = broker.poll();
    }

    public void savePhrase(CheeringPhrase phrase) {
        service.addCheeringPhrase(phrase);
    }


    @Scheduled(fixedRate = 60000)
    public void getMessageFromBroker() {

    }

}
