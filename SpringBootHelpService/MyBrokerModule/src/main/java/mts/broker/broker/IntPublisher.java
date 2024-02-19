package mts.broker.broker;

public interface IntPublisher<T> {
    String offer(T t);
}
