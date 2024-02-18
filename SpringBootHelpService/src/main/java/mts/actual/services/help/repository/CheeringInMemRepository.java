package mts.actual.services.help.repository;

import mts.actual.services.help.model.CheeringPhrase;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CheeringInMemRepository {

    private final Map<Integer, CheeringPhrase> phrasesHashMap = new ConcurrentHashMap<>();

    public CheeringInMemRepository() {

        phrasesHashMap.put(1, new CheeringPhrase("Всё будет хорошо!"));
        phrasesHashMap.put(2, new CheeringPhrase("Ты молодец!"));
        phrasesHashMap.put(3, new CheeringPhrase("Прикладываю эмоциональный подорожник.."));
        phrasesHashMap.put(4, new CheeringPhrase("Ты справишься!"));
    }

    public CheeringPhrase getCheeringPhrase() {
        CheeringPhrase phrase = phrasesHashMap.get((int) (Math.random() * phrasesHashMap.size() + 1));
        System.out.println(phrase.getPhrase());
        return phrase;
    }

    public synchronized void addCheeringPhrase(CheeringPhrase phrase) {
        phrasesHashMap.put(phrasesHashMap.size() + 1, phrase);
    }
}

/*
    public String getCheeringPhrase() {
        String s = phrasesHashMap.get((int) (Math.random() * phrasesHashMap.size() + 1));
        System.out.println(s);
        return s;
    }


            phrasesHashMap.put(1, "Всё будет хорошо!");
        phrasesHashMap.put(2, "Ты молодец!");
        phrasesHashMap.put(3, "Прикладываю эмоциональный подорожник..");
        phrasesHashMap.put(4, "Ты справишься!");
 */