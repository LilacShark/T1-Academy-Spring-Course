package mts.actual.services.help.broker.v1;

import mts.actual.services.help.model.CheeringPhrase;
import mts.actual.services.help.view.SupportRequest;
import mts.cheeringbroker.broker.IntMessageBroker;
import mts.cheeringbroker.broker.IntPublisher;

public class LocalIntPublisher implements IntPublisher<SupportRequest> {

    IntMessageBroker<CheeringPhrase> broker;

    public LocalIntPublisher(IntMessageBroker<CheeringPhrase> broker) {
        this.broker = broker;
    }

    public String offer(SupportRequest request) {

        if (broker.offer(request.getCheeringPhrase())) {
            return "Фраза " + request.getCheeringPhrase().getPhrase() + " предложена к добавлению..";
        }
        return "Ошибка";
    }
}
