package mts.actual.services.help.web;

import mts.actual.services.help.interfaces.CheeringService;
import mts.actual.services.help.model.CheeringPhrase;
import mts.actual.services.help.CheeringServiceModernImp;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheeringController {

    private final CheeringService cheeringService;

    public CheeringController(CheeringService cheeringService) {
        this.cheeringService = cheeringService;
    }


    @GetMapping(value = "/getPhrase", produces = MediaType.APPLICATION_JSON_VALUE)
    public CheeringPhrase getCheeringPhrase() {
        return cheeringService.getCheeringPhrase();
    }
}



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
    */