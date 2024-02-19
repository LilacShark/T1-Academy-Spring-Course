package mts.actual.services.help.broker;

import mts.actual.services.help.model.CheeringPhrase;
import mts.broker.broker.IntMessageBroker;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LocalIntMessageBroker implements IntMessageBroker<CheeringPhrase> {

    // 1:00:00
    private final BlockingQueue<CheeringPhrase> brokerQueue;
    private final int capacity = 10;

    public LocalIntMessageBroker() {
        brokerQueue = new LinkedBlockingQueue<CheeringPhrase>(capacity);
    }

    public boolean offer(CheeringPhrase phrase) {
        return brokerQueue.offer(phrase);
    }

    public CheeringPhrase poll() {
        return brokerQueue.poll();
    }

}
