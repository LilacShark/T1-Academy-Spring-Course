package mts.actual.services.help.broker;

import mts.actual.services.help.interfaces.CheeringService;
import org.springframework.scheduling.annotation.Scheduled;


public class Subscriber {

    private CheeringService service;
    private MessageBroker broker;

    public Subscriber() {
    }

    @Scheduled(fixedRate = 60000)
    public void getMessageFromBroker() {

    }

}

//public class Subscriber implements Runnable {
// зачем ранебл был нужен?
//    @Override
//    public void run() {
//    }