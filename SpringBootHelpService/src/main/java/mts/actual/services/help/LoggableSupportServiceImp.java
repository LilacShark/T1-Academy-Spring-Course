package mts.actual.services.help;

import mts.actual.services.help.model.CheeringPhrase;

public class LoggableSupportServiceImp extends CheeringServiceImp {

    private final CheeringServiceImp cheeringServiceImp;

    public LoggableSupportServiceImp(CheeringServiceImp cheeringServiceImp) {
        this.cheeringServiceImp = cheeringServiceImp;
    }

    @Override
    public CheeringPhrase getCheeringPhrase() {
        System.out.println("=== LoggableSupportServiceImp getPhrase().. ");
        return cheeringServiceImp.getCheeringPhrase();
    }

    public String addCheeringPhrase(CheeringPhrase phrase) {
        System.out.println("=== LoggableSupportServiceImp addCheeringPhrase().. ");
        return cheeringServiceImp.addCheeringPhrase(phrase);
    }

}
