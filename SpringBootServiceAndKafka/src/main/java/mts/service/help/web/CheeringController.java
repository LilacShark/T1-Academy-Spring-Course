package mts.service.help.web;

import mts.service.help.interfaces.CheeringService;
import mts.service.help.model.CheeringPhrase;
import mts.service.help.view.CheeringRequest;
import mts.service.help.view.CheeringResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class CheeringController {

    private final CheeringService cheeringService;

    public CheeringController(CheeringService cheeringService) {
        this.cheeringService = cheeringService;
    }

    @GetMapping(value = "/getPhrase",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CheeringPhrase getCheeringPhrase() {
        return cheeringService.getCheeringPhrase();
    }

    @RequestMapping(value = "/addPhrase", method = RequestMethod.POST,
            consumes="application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CheeringResponse addCheeringPhrase(@RequestBody CheeringRequest request) {
        System.out.println("=== Пришёл запрос: " + request);
        return cheeringService.addCheeringPhrase(request);
    }

}