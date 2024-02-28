package mts.services.help;

import mts.services.help.config.SemiAutoWired;
import mts.services.help.interfaces.CheeringService;
import mts.services.help.interfaces.CheeringManager;
import mts.services.help.view.SupportRequest;
import mts.services.help.view.SupportResponse;

public class CheeringManagerImp implements CheeringManager {

    @SemiAutoWired
    private CheeringService cheeringService;

    public CheeringManagerImp(CheeringService cheeringService) {
        this.cheeringService = cheeringService;
    }

    public CheeringManagerImp() {

    }

    public String provideSupport() {
        return "Подбрадривание для Вас: %s".formatted(cheeringService.getPhrase());
    }

    public SupportResponse addCheeringPhrase(SupportRequest supportRequest) {
        String added = cheeringService.addCheeringPhrase(supportRequest.getSupportPhrase());
        return new SupportResponse(added, "OK");
    }

    public SupportResponse getCheeringPhrase() {
        String cheeringPhrase = cheeringService.getCheeringPhrase();
        return new SupportResponse(cheeringPhrase, "OK");
    }

    public CheeringService getCheeringService() {
        return cheeringService;
    }

    public void setCheeringService(CheeringService cheeringService) {
        this.cheeringService = cheeringService;
    }
}
