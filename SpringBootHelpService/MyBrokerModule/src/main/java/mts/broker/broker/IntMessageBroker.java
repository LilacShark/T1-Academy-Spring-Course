package mts.broker.broker;

public interface IntMessageBroker<T> {
    boolean offer(T t);

    T poll();

}
