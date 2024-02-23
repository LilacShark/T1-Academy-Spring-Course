package mts.supportbroker.broker;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class InMemoryBroker {

    private final BlockingDeque<String> messageQueue = new LinkedBlockingDeque<>();

    public void publish(String message) {
        System.out.println("InMemoryBroker - publish.." + message);
        messageQueue.offer(message);
    }

    public String take() {
        try {
            String take = messageQueue.take();
            System.out.println("InMemoryBroker - take.." + take);
            return take;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
