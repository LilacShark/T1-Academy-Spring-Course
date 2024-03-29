package mts.actual.services.help.web;

import mts.actual.services.help.interfaces.CheeringService;
import mts.actual.services.help.model.CheeringPhrase;
import mts.actual.services.help.view.SupportRequest;
import mts.actual.services.help.view.SupportResponse;
import mts.cheeringbroker.broker.IntPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class CheeringController {

    private final CheeringService cheeringService;
    private final IntPublisher<SupportRequest> intPublisher;


    public CheeringController(CheeringService cheeringService,
                              IntPublisher<SupportRequest> intPublisher) {
        this.cheeringService = cheeringService;
        this.intPublisher = intPublisher;

    }

    @GetMapping(value = "/getPhrase",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CheeringPhrase getCheeringPhrase() {
        return cheeringService.getCheeringPhrase();
    }

    @RequestMapping(value = "/addPhrase", method = RequestMethod.POST,
            consumes="application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public SupportResponse addCheeringPhrase(@RequestBody SupportRequest request) {
        System.out.println("=== Пришёл запрос: " + request);
        String response = intPublisher.offer(request);
        return new SupportResponse(response, HttpStatus.CREATED);
    }

}