package mts.cheeringbroker.broker;

public interface IntSubscriber<T> {

    void getMessagesFromBroker();

    void savePhrase(T t);
}
