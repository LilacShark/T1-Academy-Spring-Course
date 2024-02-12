package mts.services.help;

import mts.services.help.interfaces.CheeringService;
import mts.services.help.interfaces.Manager;
import mts.services.help.view.SupportRequest;
import mts.services.help.view.SupportResponse;

public class CheeringManager implements Manager {

    private CheeringService cheeringService;

    public CheeringManager(CheeringService cheeringService) {
        this.cheeringService = cheeringService;
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

    public String depricated_getCheeringPhrase() {
        return cheeringService.getCheeringPhrase();
    }

    public String depricated_addCheeringPhrase(String phrase) {
        return cheeringService.addCheeringPhrase(phrase);
    }
}
