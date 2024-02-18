package mts.actual.services.help;

import mts.actual.services.help.model.CheeringPhrase;

public class LoggableSupportServiceModern extends CheeringServiceModernImp {

    private final CheeringServiceModernImp cheeringServiceModernImp;

    public LoggableSupportServiceModern(CheeringServiceModernImp cheeringServiceModernImp) {
        this.cheeringServiceModernImp = cheeringServiceModernImp;
    }

    @Override
    public CheeringPhrase getPhrase() {
        System.out.println("=== LoggableSupportServiceModern getPhrase().. ");
        return cheeringServiceModernImp.getPhrase();
    }

    @Override
    public CheeringPhrase getCheeringPhrase() {
        return null;
    }

    public String addCheeringPhrase(CheeringPhrase phrase) {
        return null;
    }

}
