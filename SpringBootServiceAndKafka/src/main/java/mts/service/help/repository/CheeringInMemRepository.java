package mts.service.help.repository;

import mts.service.help.model.CheeringPhrase;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CheeringInMemRepository {

    private final List<CheeringPhrase> phrasesRepository =  new CopyOnWriteArrayList<>();

    public CheeringInMemRepository() {
        phrasesRepository.add(new CheeringPhrase("Всё будет хорошо!"));
    }

    public CheeringPhrase getCheeringPhrase() {
        CheeringPhrase phrase = phrasesRepository.get((int) (Math.random() * phrasesRepository.size() + 1));
        System.out.println("=== Достали фразу из репозитория " + phrase.getPhrase());
        return phrase;
    }

    public boolean addCheeringPhrase(CheeringPhrase phrase) {
        phrasesRepository.add(phrase);
        return true;
    }

    public boolean alreadyContains(CheeringPhrase phrase) {
        return  phrasesHashMap.containsValue(phrase);
    }
}