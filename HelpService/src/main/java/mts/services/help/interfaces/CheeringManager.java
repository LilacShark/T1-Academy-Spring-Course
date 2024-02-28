package mts.services.help.interfaces;

import mts.services.help.view.SupportRequest;
import mts.services.help.view.SupportResponse;

public interface CheeringManager {
    SupportResponse getCheeringPhrase();

    SupportResponse addCheeringPhrase(SupportRequest request);

    String provideSupport();
}
