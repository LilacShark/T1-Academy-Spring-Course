package mts.actual.services.help.model;

import java.util.Random;

public class CheeringPhrase {

    private final Random random;
    private int randomValue;
    private String phrase;

    public CheeringPhrase() {
        this.random = new Random();
        randomValue = random.nextInt();
    }

    public CheeringPhrase(String phrase) {
        this.random = new Random();
        randomValue = random.nextInt();
        this.phrase = phrase;
    }

    public int getRandomValue() {
        return randomValue;
    }

    public String getPhrase() {
        return phrase;
    }
}
