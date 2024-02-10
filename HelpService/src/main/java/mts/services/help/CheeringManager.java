package mts.services.help;

public class CheeringManager {

    private CheeringService cheeringService;

    public CheeringManager(CheeringService cheeringService) {
        this.cheeringService = cheeringService;
    }

    public String provideSupport() {
        return "Подбрадривание для Вас: %s".formatted(cheeringService.getPhrase());
    }

    public String getCheeringPhrase() {
        return cheeringService.getCheeringPhrase();
    }

    public String addCheeringPhrase(String phrase) {
        return cheeringService.addCheeringPhrase(phrase);
    }
}
