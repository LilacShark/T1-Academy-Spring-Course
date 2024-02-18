package mts.actual.services.help.model;

import java.util.Random;

public class CheeringPhrase {

    private String phrase;

    public CheeringPhrase() {
    }

    public CheeringPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    @Override
    public String toString() {
        return "CheeringPhrase{" +
                "phrase='" + phrase + '\'' +
                '}';
    }
}
