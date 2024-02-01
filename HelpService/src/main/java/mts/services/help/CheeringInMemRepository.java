package mts.services.help;

import java.util.HashMap;

/**
 * Хранилище фраз поддержки в памяти приложения
 */
public class CheeringInMemRepository {

    private final HashMap<Integer, String> phrasesHashMap = new HashMap<>();

    public CheeringInMemRepository() {

        phrasesHashMap.put(1, "Всё будет хорошо!");
        phrasesHashMap.put(2, "Ты молодец!");
        phrasesHashMap.put(3, "Прикладываю эмоциональный подорожник..");
        phrasesHashMap.put(4, "Ты справишься!");
        phrasesHashMap.put(5, "У тебя хорошо получается!");
        phrasesHashMap.put(6, "Ты не зря стараешься!");
        phrasesHashMap.put(7, "Твой кот тобой гордится!");
        phrasesHashMap.put(8, "Партия Вами гордится, товарищ!");
        phrasesHashMap.put(9, "Ууууу! Хорош!");
        phrasesHashMap.put(10, "МЕГАХОРОШ!");

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
