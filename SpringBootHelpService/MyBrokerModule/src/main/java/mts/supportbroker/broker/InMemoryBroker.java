package mts.supportbroker.broker;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class InMemoryBroker {

    private final BlockingDeque<String> messageQueue = new LinkedBlockingDeque<>();

    public void publish(String message) {
        messageQueue.offer(message);
    }

    public String take() {
        try {
            return messageQueue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
