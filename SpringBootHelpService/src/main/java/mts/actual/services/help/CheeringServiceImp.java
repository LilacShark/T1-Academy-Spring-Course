package mts.actual.services.help;

import mts.actual.services.help.config.SupaLogged;
import mts.actual.services.help.interfaces.CheeringService;
import mts.actual.services.help.model.CheeringPhrase;
import mts.actual.services.help.repository.CheeringInMemRepository;

@SupaLogged
public class CheeringServiceImp implements CheeringService {

    private CheeringInMemRepository repository;

    public CheeringServiceImp(CheeringInMemRepository repository) {
        this.repository = repository;
    }

    public CheeringServiceImp() {
    }

    public CheeringPhrase getCheeringPhrase() {
        return repository.getCheeringPhrase();
    }

    public String addCheeringPhrase(CheeringPhrase phrase) {
        repository.addCheeringPhrase(phrase);
        return "Добавлена фраза: " + phrase.getPhrase();
    }

}
