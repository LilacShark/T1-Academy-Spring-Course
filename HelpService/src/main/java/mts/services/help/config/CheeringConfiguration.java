package mts.services.help.config;

import mts.services.help.CheeringManager;
import mts.services.help.repository.CheeringInMemRepository;
import mts.services.help.CheeringService;
import mts.services.help.CheeringServiceImp;

//46:50
// домашка на 20 минуте
@Configuration
public class CheeringConfiguration {

    // Столкнулся с проблемой при прогоне тестов:
    // если поменять CheeringService и CheeringManager местами в конфиге,
    // то в тесте CheeringManagerTest возможен случай, когда
    // cheeringService не инициализирован.
    // Если запускать не конкретный тест, а весь тестовый класс, то ошибка 100%

    @Instance
    public CheeringService cheeringService(CheeringInMemRepository repository) {
        return new CheeringServiceImp(repository);
    }

    @Instance
    public CheeringManager cheeringManager(CheeringService cheeringService) {
        return new CheeringManager(cheeringService);
    }

    @Instance
    public CheeringInMemRepository repository() {
        return new CheeringInMemRepository();
    }
}
