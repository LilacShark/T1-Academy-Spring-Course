package mts.services.help.repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CheeringInMemRepository {

    private final List<String> phrasesRepository =  new CopyOnWriteArrayList<>();

    public CheeringInMemRepository() {

        phrasesRepository.add(1, "Всё будет хорошо!");
        phrasesRepository.add(2, "Ты молодец!");
        phrasesRepository.add(3, "Прикладываю эмоциональный подорожник..");
        phrasesRepository.add(4, "Ты справишься!");
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
