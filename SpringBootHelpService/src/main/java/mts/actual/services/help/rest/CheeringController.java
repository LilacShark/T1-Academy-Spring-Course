package mts.actual.services.help.rest;

import mts.actual.services.help.CheeringManager;
import mts.actual.services.help.CheeringPhrase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CheeringController {

    @Autowired
    private CheeringManager cheeringManager;
//    @Qualifier("manager")

    @GetMapping(value = "/getPhrase")
    public ResponseEntity<CheeringPhrase> getCheeringPhrase() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(cheeringManager.getCheeringPhrase());
    }

/*
    @RequestMapping(value = "/prices", method = RequestMethod.POST,
            consumes="application/json", produces = "application/json")
    public MarketResponse showMarketPrice(@RequestBody MarketRequest marketRequest) {

        System.out.println("showMarketPrice..");
        return marketManager.showPrice(marketRequest.getGoodName());

    }
    */

}
