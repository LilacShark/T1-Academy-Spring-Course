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
    public CheeringService cheeringService(CheeringInMemRepository repository) {
        return new CheeringServiceImp(repository);
    }

    @Instance
    public CheeringManager cheeringManager(CheeringService cheeringService) {
        return new CheeringManagerImp(cheeringService);
    }

//    TODO: нужен ли интерфейс, если интерфейс сейчас пустой и контроллер один и ищу контроллер по аннотации
    @Instance
    public CheeringController cheeringController(CheeringManager cheeringManager) {
        return new CheeringController(cheeringManager);
    }

    @Instance
    public CheeringInMemRepository repository() {
        return new CheeringInMemRepository();
    }

    @Instance

    public MappingHandler handler() {
        try {
            return new MappingHandlerImp();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    };
}
