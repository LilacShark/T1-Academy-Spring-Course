package mts.actual.services.help.broker;

import mts.broker.config.Subscriber;
import mts.actual.services.help.interfaces.CheeringService;
import mts.actual.services.help.model.CheeringPhrase;
import mts.broker.broker.IntMessageBroker;
import mts.broker.broker.IntSubscriber;
import org.springframework.scheduling.annotation.Scheduled;

public class LocalIntSubscriber implements IntSubscriber<CheeringPhrase> {

    private final CheeringService service;
    private final IntMessageBroker<CheeringPhrase> broker;

    public LocalIntSubscriber(CheeringService service, IntMessageBroker<CheeringPhrase> broker) {
        this.service = service;
        this.broker = broker;
    }

    @Scheduled(fixedRate = 5000)
    @Subscriber
    public void getMessagesFromBroker() {
        System.out.println("=== САБСКРАЙБЕР ПРОВЕРЯЕТ БРОКЕР === ..");
        CheeringPhrase polled = (CheeringPhrase) broker.poll();
        if (polled != null) {
            System.out.println("=== Сабскарйбером из брокера получена фраза: " + polled);
            savePhrase(polled);
        }
    }

    public void savePhrase(CheeringPhrase phrase) {
        service.addCheeringPhrase(phrase);
    }

}