package mts.actual.services.help;

import mts.actual.services.help.interfaces.CheeringService;
import mts.actual.services.help.model.CheeringPhrase;
import mts.actual.services.help.repository.CheeringInMemRepository;

public class CheeringServiceImp implements CheeringService {

    private final CheeringInMemRepository repository;

    public CheeringServiceImp(CheeringInMemRepository repository) {
        this.repository = repository;
    }

    public CheeringPhrase getCheeringPhrase() {
        return repository.getCheeringPhrase();
    }

    public String addCheeringPhrase(CheeringPhrase phrase) {
        repository.addCheeringPhrase(phrase);
        return "Добавлена фраза: " + phrase.getPhrase();
    }

    @Override
    public CheeringPhrase getPhrase() {
        return null;
    }
}
