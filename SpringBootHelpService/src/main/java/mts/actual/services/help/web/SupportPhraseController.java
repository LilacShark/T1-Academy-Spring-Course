package mts.actual.services.help.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mts.actual.services.help.interfaces.CheeringService;
import mts.actual.services.help.view.SupportRequest;
import mts.supportbroker.broker.InMemoryBroker;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class SupportPhraseController {

    private final CheeringService service;
    private final InMemoryBroker broker;
    private final ObjectMapper mapper;

    public SupportPhraseController(CheeringService service, InMemoryBroker broker, ObjectMapper mapper) {
        this.service = service;
        this.broker = broker;
        this.mapper = mapper;
    }

    @PostMapping("/support")
    public void addPhrase(@RequestBody SupportRequest request) {
        broker.publish(broker.publish(request);
    }
}
