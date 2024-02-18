package mts.actual.services.help.broker;

import mts.actual.services.help.config.Subscriber;
import mts.actual.services.help.interfaces.CheeringService;
import mts.actual.services.help.model.CheeringPhrase;

public class LocalIntSubscriber implements IntSubscriber {

    private final CheeringService service;
    private final IntMessageBroker broker;

    public LocalIntSubscriber(CheeringService service, IntMessageBroker broker) {
        this.service = service;
        this.broker = broker;
    }

    @Subscriber(fixedRate = 1000)
    public void getMessagesFromBroker() {
        System.out.println("=== САБСКРАЙБЕР ПРОВЕРЯЕТ БРОКЕР === ..");
        CheeringPhrase polled = broker.poll();
        if (polled != null) {
            System.out.println("=== Сабскарйбером из брокера получена фраза: " + polled);
            savePhrase(polled);
        }
    }

    public void pollMessage() {
        CheeringPhrase poll = broker.poll();
    }

    public void savePhrase(CheeringPhrase phrase) {
        service.addCheeringPhrase(phrase);
    }

}