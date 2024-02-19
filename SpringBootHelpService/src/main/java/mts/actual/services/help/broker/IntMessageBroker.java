package mts.actual.services.help.broker;


import mts.actual.services.help.model.CheeringPhrase;

public interface IntMessageBroker<T> {
    boolean offer(T t);

    T poll();

}

/*
    boolean offer(CheeringPhrase cheeringPhrase);

    CheeringPhrase poll();
 */
