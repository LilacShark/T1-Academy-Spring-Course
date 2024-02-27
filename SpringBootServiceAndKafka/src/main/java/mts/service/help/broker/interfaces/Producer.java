package mts.service.help.broker.interfaces;

import mts.service.help.model.CheeringPhrase;

public interface Producer<T> {

    void sendMessage(T t);
}
