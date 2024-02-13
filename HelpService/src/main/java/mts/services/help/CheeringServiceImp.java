package mts.services.help;

import mts.services.help.config.SemiAutoWired;
import mts.services.help.interfaces.CheeringService;
import mts.services.help.repository.CheeringInMemRepository;

public class CheeringServiceImp implements CheeringService {

    @SemiAutoWired
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

    public CheeringInMemRepository getRepository() {
        return repository;
    }

    public void setRepository(CheeringInMemRepository repository) {
        this.repository = repository;
    }

}
