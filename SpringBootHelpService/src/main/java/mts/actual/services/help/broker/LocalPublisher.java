package mts.actual.services.help.broker;

import org.springframework.stereotype.Component;

@Component
public class LocalPublisher extends Publisher {

    MessageBroker broker;


    public LocalPublisher(MessageBroker broker) {
        this.broker = broker;
    }
}
