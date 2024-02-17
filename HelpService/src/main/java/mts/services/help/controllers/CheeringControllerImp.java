package mts.services.help.controllers;

import mts.services.help.config.SemiAutoWired;
import mts.services.help.config.UrlMapping;
import mts.services.help.config.WebController;
import mts.services.help.interfaces.CheeringController;
import mts.services.help.interfaces.CheeringManager;
import mts.services.help.view.SupportRequest;
import mts.services.help.view.SupportResponse;

@WebController
public class CheeringControllerImp implements CheeringController {

    @SemiAutoWired
    private CheeringManager cheeringManager;

    public CheeringControllerImp() {
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
