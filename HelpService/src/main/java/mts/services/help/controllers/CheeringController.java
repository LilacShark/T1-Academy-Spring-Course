package mts.services.help.controllers;

import mts.services.help.config.SemiAutoWired;
import mts.services.help.config.UrlMapping;
import mts.services.help.interfaces.CheeringManager;
import mts.services.help.interfaces.Controller;
import mts.services.help.view.SupportRequest;
import mts.services.help.view.SupportResponse;

public class CheeringController implements Controller {

    @SemiAutoWired
    private CheeringManager cheeringManager;

    public CheeringController(CheeringManager cheeringManager) {
        this.cheeringManager = cheeringManager;
    }

    @UrlMapping("/getPhrase")
    public SupportResponse getPhrase() {
        return cheeringManager.getCheeringPhrase();
    }

    @UrlMapping("/addPhrase")
    public SupportResponse addPhrase(SupportRequest request) {
        return cheeringManager.addCheeringPhrase(request);
    }


    public CheeringManager getCheeringManager() {
        return cheeringManager;
    }

    public void setCheeringManager(CheeringManager cheeringManager) {
        this.cheeringManager = cheeringManager;
    }
}
