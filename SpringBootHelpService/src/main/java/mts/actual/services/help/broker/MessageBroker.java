package mts.actual.services.help.broker;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class MessageBroker {

    private BlockingQueue brokerQueue; // 1:00:00
    private List<String> queue;

    public MessageBroker() {
        queue = new LinkedList<>();
    }



}
