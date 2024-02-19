package mts.actual.services.help.broker;

import mts.actual.services.help.model.CheeringPhrase;
import mts.actual.services.help.view.SupportRequest;
import mts.broker.broker.IntMessageBroker;
import mts.broker.broker.IntPublisher;

public class LocalIntPublisher implements IntPublisher<SupportRequest> {

    IntMessageBroker broker;

    public LocalIntPublisher(IntMessageBroker broker) {
        this.broker = broker;
    }

    public String offer(SupportRequest request) {

        if (broker.offer(request.getCheeringPhrase())) {
            return "Фраза " + request.getCheeringPhrase().getPhrase() + " предложена к добавлению..";
        }
        return "Ошибка";
    }
}
