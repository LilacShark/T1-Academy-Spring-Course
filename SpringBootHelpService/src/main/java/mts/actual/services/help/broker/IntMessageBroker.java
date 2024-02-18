package mts.actual.services.help.broker;

import mts.actual.services.help.model.CheeringPhrase;

public interface IntMessageBroker {
    boolean offer(CheeringPhrase cheeringPhrase);

    CheeringPhrase poll();

}
