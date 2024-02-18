package mts.actual.services.help.config;

import mts.actual.services.help.CheeringServiceImp;
import mts.actual.services.help.broker.*;
import mts.actual.services.help.interfaces.CheeringService;
import mts.actual.services.help.model.CheeringPhrase;
import mts.actual.services.help.CheeringServiceModernImp;
import mts.actual.services.help.repository.CheeringInMemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    private final ApplicationContext context;

    @Autowired
    public AppConfig(ApplicationContext context) {
        this.context = context;
    }

    @Bean
    @Scope("singleton")
    public CheeringInMemRepository repository() {
        return new CheeringInMemRepository();
    }

    @Bean
    @Scope("singleton")
    public CheeringServiceImp serviceImp(CheeringInMemRepository repository) {
        return new CheeringServiceImp(repository);
    }

    @Bean
    @Scope("singleton")
    public Subscriber subscriber(CheeringService service) {
        return new LocalSubscriber(service);
    }

    @Bean
    @Scope("singleton")
    public MessageBroker broker() {
        return new MessageBroker();
    }

    @Bean
    @Scope("singleton")
    public Publisher publisher(MessageBroker broker) {
        return new LocalPublisher(broker);
    }


/////////////////////////////////////////////////////////////////////////////////////////////////
/*
    @Bean
    public CheeringServiceModernImp cheeringService() {
        return new CheeringServiceModernImp() {
            @Override
            public CheeringPhrase getPhrase() {
                return context.getBean(CheeringPhrase.class);
            }

            @Override
            public String getCheeringPhrase() {
                return null;
            }

            @Override
            public String addCheeringPhrase(String phrase) {
                return null;
            }
        };
    }

    @Bean
    @Scope("prototype")
    public CheeringPhrase cheeringPhrase() {
//         переделать, чтобы новая фраза получалась из фабричного метода,
//         связанного с репозиторием или просто из репозитория
        return new CheeringPhrase();
    }
*/
}
