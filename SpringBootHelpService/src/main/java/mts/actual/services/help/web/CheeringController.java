package mts.actual.services.help.web;

import mts.actual.services.help.broker.Publisher;
import mts.actual.services.help.interfaces.CheeringService;
import mts.actual.services.help.model.CheeringPhrase;
import mts.actual.services.help.view.SupportRequest;
import mts.actual.services.help.view.SupportResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class CheeringController {

    private final CheeringService cheeringService;
    private final Publisher publisher;

    public CheeringController(CheeringService cheeringService, Publisher publisher) {
        this.cheeringService = cheeringService;
        this.publisher = publisher;
    }

    @GetMapping(value = "/getPhrase",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CheeringPhrase getCheeringPhrase() {
        return cheeringService.getCheeringPhrase();
    }

    @RequestMapping(value = "/addPhrase", method = RequestMethod.POST,
            consumes="application/json", produces = "application/json")
    public SupportResponse addCheeringPhrase(@RequestBody SupportRequest request) {
        System.out.println(request);
        String response = publisher.offer(request);
        if (response == "Ошибка"){
            return new SupportResponse(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new SupportResponse(response, HttpStatus.OK);
        }
    }

}


//    @RequestBody SupportRequest request
//,
//            consumes = MediaType.APPLICATION_JSON_VALUE

//    @GetMapping(value = "/getPhrase")
//    public ResponseEntity<CheeringPhrase> getCheeringPhrase() {
//        return ResponseEntity.ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(cheeringManager.getCheeringPhrase());
//    }

/*
    @RequestMapping(value = "/prices", method = RequestMethod.POST,
            consumes="application/json", produces = "application/json")
    public MarketResponse showMarketPrice(@RequestBody MarketRequest marketRequest) {

        System.out.println("showMarketPrice..");
        return marketManager.showPrice(marketRequest.getGoodName());

    }




    @PostMapping(value = "/addPhrase",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public SupportResponse addCheeringPhrase(SupportRequest request) {
        System.out.println(request);
        return publisher.offer(request);
    }


    */