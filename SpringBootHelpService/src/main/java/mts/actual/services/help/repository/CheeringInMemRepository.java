package mts.actual.services.help.repository;

import mts.actual.services.help.model.CheeringPhrase;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CheeringInMemRepository {

    private final List<CheeringPhrase> phrasesRepository =  new CopyOnWriteArrayList<>();

    public CheeringInMemRepository() {

        phrasesRepository.add(new CheeringPhrase("Всё будет хорошо!"));
//        phrasesHashMap.put(2, new CheeringPhrase("Ты молодец!"));
//        phrasesHashMap.put(3, new CheeringPhrase("Прикладываю эмоциональный подорожник.."));
//        phrasesHashMap.put(4, new CheeringPhrase("Ты справишься!"));
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
}