package mts.actual.services.help.broker;

import mts.actual.services.help.interfaces.CheeringService;
import org.springframework.stereotype.Component;

@Component
public class LocalSubscriber extends Subscriber {

    private CheeringService service;

    public LocalSubscriber(CheeringService service) {
        this.service = service;
    }

}
