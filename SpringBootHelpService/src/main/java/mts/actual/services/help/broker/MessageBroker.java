package mts.actual.services.help.broker;

import mts.actual.services.help.model.CheeringPhrase;

public interface MessageBroker {
    boolean offer(CheeringPhrase cheeringPhrase);
}
