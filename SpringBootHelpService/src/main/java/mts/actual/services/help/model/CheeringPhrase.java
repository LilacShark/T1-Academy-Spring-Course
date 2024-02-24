package mts.actual.services.help.model;

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

    @Override
    public String toString() {
        return "CheeringPhrase{" +
                "phrase='" + phrase + '\'' +
                '}';
    }
}
