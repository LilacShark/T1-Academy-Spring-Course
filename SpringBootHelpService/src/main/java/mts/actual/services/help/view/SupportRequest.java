package mts.actual.services.help.view;

import mts.actual.services.help.model.CheeringPhrase;

public class SupportRequest {

    private CheeringPhrase cheeringPhrase;

    public SupportRequest(CheeringPhrase cheeringPhrase) {
        this.cheeringPhrase = cheeringPhrase;
    }

    public SupportRequest() {
    }

    public CheeringPhrase getCheeringPhrase() {
        return cheeringPhrase;
    }

    public void setCheeringPhrase(CheeringPhrase cheeringPhrase) {
        this.cheeringPhrase = cheeringPhrase;
    }

    @Override
    public String toString() {
        return "SupportRequest{" +
                "phrase=" + cheeringPhrase +
                '}';
    }

}
