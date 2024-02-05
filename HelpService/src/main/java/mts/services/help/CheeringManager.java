package mts.services.help;

public class CheeringManager {

    private final CheeringInMemRepository repository;

    public CheeringManager() {
        this.repository = new CheeringInMemRepository();
    }

    public String getCheeringPhrase() {

        return repository.getCheeringPhrase();
    }

    public String addCheeringPhrase(String phrase) {
        repository.addCheeringPhrase(phrase);
        return "Добавлена фраза: " + phrase;
    }
}
