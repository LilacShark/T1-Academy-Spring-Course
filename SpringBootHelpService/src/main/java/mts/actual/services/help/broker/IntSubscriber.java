package mts.actual.services.help.broker;

import mts.actual.services.help.model.CheeringPhrase;

public interface IntSubscriber<T> {

    void getMessagesFromBroker();

    void savePhrase(T t);
}
