package mts.services.help;

public class CheeringServiceImp implements CheeringService {


    private CheeringInMemRepository repository;

    public CheeringServiceImp(CheeringInMemRepository repository) {
        this.repository = repository;
    }

    public String getCheeringPhrase() {
        return repository.getCheeringPhrase();
    }

    public String addCheeringPhrase(String phrase) {
        repository.addCheeringPhrase(phrase);
        return "Добавлена фраза: " + phrase;
    }

    @Override
    public String getPhrase() {
        return "Тестовое подбадривание";
    }
}
