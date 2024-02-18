package mts.actual.services.help.broker;

import mts.actual.services.help.view.SupportRequest;

public class LocalIntPublisher implements IntPublisher {

    IntMessageBroker broker;

    public LocalIntPublisher(IntMessageBroker broker) {
        this.broker = broker;
    }

    @Override
    public String offer(SupportRequest request) {

        if (broker.offer(request.getCheeringPhrase())) {
            return "Фраза " + request.getCheeringPhrase().getPhrase() + " предложена к добавлению..";
        }
        return "Ошибка";
    }
}
