package mts.actual.services.help.broker.v2;

import mts.actual.services.help.interfaces.CheeringService;
import mts.actual.services.help.model.CheeringPhrase;
import mts.supportbroker.config.SupportSubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SupportPhraseSubscriber {

    private static final Logger logger = LoggerFactory.getLogger(SupportPhraseSubscriber.class);

    private final CheeringService service;

    @SupportSubscriber
    public void subscriber(CheeringPhrase cheeringPhrase) {
        logger.info("SupportPhraseSubscriber subscriber : " + cheeringPhrase.getPhrase());
        System.out.println("SupportPhraseSubscriber subscriber : " + cheeringPhrase.getPhrase());
        service.addCheeringPhrase(cheeringPhrase);
    }

    public SupportPhraseSubscriber(CheeringService service) {
        this.service = service;
    }
}
