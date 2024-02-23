package mts.actual.services.help.web;

import mts.actual.services.help.interfaces.CheeringService;
import mts.actual.services.help.view.SupportRequest;
import mts.supportbroker.broker.Publisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupportPhraseController {

    private final CheeringService service;
    private final Publisher<SupportRequest> publisher;


    public SupportPhraseController(CheeringService service, Publisher<SupportRequest> publisher) {
        this.service = service;
        this.publisher = publisher;
    }

    @PostMapping("/support")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPhrase(@RequestBody SupportRequest request) {
        System.out.println("SupportPhraseController - addPhrase.." + request);
        publisher.publish(request);
    }
}
