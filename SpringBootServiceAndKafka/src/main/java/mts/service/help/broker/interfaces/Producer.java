package mts.service.help.broker.interfaces;

import mts.service.help.model.CheeringPhrase;

public interface Producer {

    void sendMessage(CheeringPhrase cheeringPhrase);
}
