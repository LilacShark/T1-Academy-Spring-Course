package mts.services.help;

import java.util.HashMap;

public class CheeringInMemRepository {

    private final HashMap<Integer, String> phrasesHashMap = new HashMap<>();

    public CheeringInMemRepository() {

        phrasesHashMap.put(1, "Всё будет хорошо!");
        phrasesHashMap.put(2, "Ты молодец!");
        phrasesHashMap.put(3, "Прикладываю эмоциональный подорожник..");
        phrasesHashMap.put(4, "Ты справишься!");
    }

    public String getCheeringPhrase() {
        String s = phrasesHashMap.get((int) (Math.random() * phrasesHashMap.size() + 1));
        System.out.println(s);
        return s;
    }

    public synchronized void addCheeringPhrase(String phrase) {
        phrasesHashMap.put(phrasesHashMap.size() + 1, phrase);
    }
}
