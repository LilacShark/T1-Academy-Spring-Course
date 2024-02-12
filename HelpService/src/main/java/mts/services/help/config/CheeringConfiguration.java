package mts.services.help.config;

import mts.services.help.CheeringController;
import mts.services.help.CheeringManager;
import mts.services.help.repository.CheeringInMemRepository;
import mts.services.help.interfaces.CheeringService;
import mts.services.help.CheeringServiceImp;
import mts.services.help.web.MappingHandler;


@Configuration
public class CheeringConfiguration {

    // Столкнулся с проблемой при прогоне тестов:
    // если поменять CheeringService и CheeringManager местами в конфиге,
    // то в тесте CheeringManagerTest возможен случай, когда
    // cheeringService не инициализирован.
    // Если запускать не конкретный тест, а весь тестовый класс, то ошибка 100%


//    TODO: переделть на интерфейсы
    @Instance
    public CheeringService cheeringService(CheeringInMemRepository repository) {
        return new CheeringServiceImp(repository);
    }

//    TODO: переделть на интерфейсы
    @Instance
    public CheeringManager cheeringManager(CheeringService cheeringService) {
        return new CheeringManager(cheeringService);
    }

//    TODO: переделть на интерфейсы
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
            return new MappingHandler();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    };
}
