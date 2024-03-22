package mts.actual.services.help.interfaces;

import mts.actual.services.help.model.CheeringPhrase;

public interface CheeringService {

    CheeringPhrase getCheeringPhrase();
    String addCheeringPhrase(CheeringPhrase phrase);

}
