package mts.cheeringbroker.broker;

public interface IntPublisher<T> {
    String offer(T t);
}
