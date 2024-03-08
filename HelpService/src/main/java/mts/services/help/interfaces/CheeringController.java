package mts.services.help.interfaces;

import mts.services.help.config.UrlMapping;
import mts.services.help.model.HttpMethod;
import mts.services.help.view.SupportResponse;

public interface CheeringController {

    public SupportResponse getPhrase();
}
