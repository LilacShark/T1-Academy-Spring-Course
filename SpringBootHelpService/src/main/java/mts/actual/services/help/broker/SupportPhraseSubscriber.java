package mts.actual.services.help.broker;

import mts.actual.services.help.model.CheeringPhrase;
import mts.actual.services.help.view.SupportRequest;
import mts.supportbroker.config.SupportSubscriber;
import org.springframework.stereotype.Component;

@Component
public class SupportPhraseSubscriber {

    @SupportSubscriber
    public void subscriber(CheeringPhrase cheeringPhrase) {
        System.out.println("input message : " + cheeringPhrase.getPhrase());
    }

}
