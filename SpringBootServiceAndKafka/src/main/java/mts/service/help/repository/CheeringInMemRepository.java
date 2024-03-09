package mts.service.help.repository;

import mts.service.help.model.CheeringPhrase;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CheeringInMemRepository {

    private final Map<Integer, CheeringPhrase> phrasesHashMap = new ConcurrentHashMap<>();

    public CheeringInMemRepository() {
        phrasesHashMap.put(1, new CheeringPhrase("Всё будет хорошо!"));
    }

    public CheeringPhrase getCheeringPhrase() {
        CheeringPhrase phrase = phrasesHashMap.get((int) (Math.random() * phrasesHashMap.size() + 1));
        System.out.println("=== Достали фразу из репозитория " + phrase.getPhrase());
        return phrase;
    }

    public synchronized boolean addCheeringPhrase(CheeringPhrase phrase) {
        phrasesHashMap.put(phrasesHashMap.size() + 1, phrase);
        return true;
    }

    public boolean alreadyContains(CheeringPhrase phrase) {
        return  phrasesHashMap.containsValue(phrase);
    }
}