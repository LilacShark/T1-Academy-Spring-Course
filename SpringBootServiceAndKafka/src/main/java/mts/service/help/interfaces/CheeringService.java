package mts.service.help.interfaces;

import mts.service.help.model.CheeringPhrase;
import mts.service.help.view.CheeringRequest;
import mts.service.help.view.CheeringResponse;

public interface CheeringService {

    CheeringPhrase getCheeringPhrase();
    CheeringResponse addCheeringPhrase(CheeringRequest request);

}
