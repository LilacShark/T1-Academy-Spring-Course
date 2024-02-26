package mts.service.help.view;

import mts.service.help.model.CheeringPhrase;

public class CheeringRequest {

    private CheeringPhrase cheeringPhrase;

    public CheeringRequest(CheeringPhrase cheeringPhrase) {
        this.cheeringPhrase = cheeringPhrase;
    }

    public CheeringRequest() {
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
