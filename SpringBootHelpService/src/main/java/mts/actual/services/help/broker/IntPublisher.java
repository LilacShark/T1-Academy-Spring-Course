package mts.actual.services.help.broker;

import mts.actual.services.help.view.SupportRequest;

public interface IntPublisher<T> {
    String offer(T t);
}
/*
    String offer(SupportRequest request);
 */
