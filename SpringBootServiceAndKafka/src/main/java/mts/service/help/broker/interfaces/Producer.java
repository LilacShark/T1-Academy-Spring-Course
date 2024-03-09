package mts.service.help.broker.interfaces;

public interface Producer<T> {

    void sendMessage(T t);
}
