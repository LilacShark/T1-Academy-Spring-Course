package mts.actual.services.help.broker;

import mts.actual.services.help.interfaces.CheeringService;
import mts.actual.services.help.model.CheeringPhrase;
import mts.cheeringbroker.broker.IntMessageBroker;
import mts.cheeringbroker.broker.IntSubscriber;
import mts.cheeringbroker.config.Subscriber;

public class LocalIntSubscriber implements IntSubscriber<CheeringPhrase> {

    private final CheeringService service;
    private final IntMessageBroker<CheeringPhrase> broker;

    public LocalIntSubscriber(CheeringService service, IntMessageBroker<CheeringPhrase> broker) {
        this.service = service;
        this.broker = broker;
    }

//    @Scheduled(fixedRate = 5000)
    @Subscriber(fixedRate = 5000)
    public void getMessagesFromBroker() {
        System.out.println("=== САБСКРАЙБЕР ПРОВЕРЯЕТ БРОКЕР === ..");
        CheeringPhrase polled = broker.poll();
        if (polled != null) {
            System.out.println("=== Сабскарйбером из брокера получена фраза: " + polled);
            savePhrase(polled);
        }
    }

    public void savePhrase(CheeringPhrase phrase) {
        service.addCheeringPhrase(phrase);
    }

}