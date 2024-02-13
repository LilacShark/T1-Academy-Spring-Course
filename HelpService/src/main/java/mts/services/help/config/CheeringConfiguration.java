package mts.services.help.config;

import mts.services.help.CheeringManagerImp;
import mts.services.help.controllers.CheeringController;
import mts.services.help.interfaces.CheeringManager;
import mts.services.help.interfaces.MappingHandler;
import mts.services.help.repository.CheeringInMemRepository;
import mts.services.help.interfaces.CheeringService;
import mts.services.help.CheeringServiceImp;
import mts.services.help.web.MappingHandlerImp;

@Configuration
public class CheeringConfiguration {

    @Instance
    public CheeringService cheeringService() {
        return new CheeringServiceImp();
    }

    @Instance
    public CheeringManager cheeringManager() {
        return new CheeringManagerImp();
    }

//    TODO: нужен ли интерфейс, если интерфейс сейчас пустой и контроллер один и ищу контроллер по аннотации
    @Instance
    public CheeringController cheeringController() {
        return new CheeringController();
    }

    @Instance
    public CheeringInMemRepository repository() {
        return new CheeringInMemRepository();
    }

    @Instance
    public MappingHandler handler() {
        return new MappingHandlerImp();
    };
}
