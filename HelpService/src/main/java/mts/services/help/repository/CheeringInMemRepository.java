package mts.services.help.repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CheeringInMemRepository {

    private final List<String> phrasesRepository =  new CopyOnWriteArrayList<>();

    public CheeringInMemRepository() {

        phrasesRepository.add("Всё будет хорошо!");
        phrasesRepository.add("Ты молодец!");
        phrasesRepository.add("Прикладываю эмоциональный подорожник..");
        phrasesRepository.add("Ты справишься!");
    }

    public String getCheeringPhrase() {
        String s = phrasesRepository.get((int) (Math.random() * phrasesRepository.size() + 1));
        System.out.println(s);
        return s;
    }

    public synchronized void addCheeringPhrase(String phrase) {
        phrasesRepository.add(phrase);
    }
}
