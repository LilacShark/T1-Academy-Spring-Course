package mts.services.help;

import mts.services.help.config.PostMapping;
import mts.services.help.interfaces.Controller;
import mts.services.help.config.GetMapping;
import mts.services.help.view.SupportRequest;
import mts.services.help.view.SupportResponse;

public class CheeringController implements Controller {

    private CheeringManager manager;

    public CheeringController(CheeringManager manager) {
        this.manager = manager;
    }

    @GetMapping("/getPhrase")
    public SupportResponse getPhrase() {
        System.out.println("Вызов CheeringController.getPhrase");
        return new SupportResponse("Успех", "OK");
//        return manager.getCheeringPhrase();
    }

    @PostMapping("/addPhrase")
    public SupportResponse addPhrase(SupportRequest request) {
        return manager.addCheeringPhrase(request);
    }



}
