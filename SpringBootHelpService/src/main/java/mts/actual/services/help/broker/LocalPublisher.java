package mts.actual.services.help.broker;

import mts.actual.services.help.view.SupportRequest;
import org.springframework.stereotype.Component;

@Component
public class LocalPublisher implements Publisher {

    MessageBroker broker;

    public LocalPublisher(MessageBroker broker) {
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
