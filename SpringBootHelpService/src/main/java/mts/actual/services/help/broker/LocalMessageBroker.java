package mts.actual.services.help.broker;

import mts.actual.services.help.model.CheeringPhrase;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LocalMessageBroker implements MessageBroker {

    // 1:00:00
    private BlockingQueue<CheeringPhrase> brokerQueue;
    private int capacity = 10;

    public LocalMessageBroker() {
        brokerQueue = new LinkedBlockingQueue(capacity);
    }

    public boolean offer(CheeringPhrase phrase) {
        return brokerQueue.offer(phrase);
    }

    public CheeringPhrase poll() {
        return brokerQueue.poll();
    }

    //            brokerQueue.put(phrase);
    //            brokerQueue.take();

}
