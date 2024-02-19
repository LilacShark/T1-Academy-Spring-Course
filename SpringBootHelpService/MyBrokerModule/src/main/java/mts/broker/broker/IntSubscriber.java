package mts.broker.broker;

public interface IntSubscriber<T> {

    void getMessagesFromBroker();

    void savePhrase(T t);
}
