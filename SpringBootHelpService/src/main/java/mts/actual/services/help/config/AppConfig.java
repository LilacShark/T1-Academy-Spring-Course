package mts.actual.services.help.config;

import mts.actual.services.help.CheeringServiceImp;
import mts.actual.services.help.broker.*;
import mts.actual.services.help.interfaces.CheeringService;
import mts.actual.services.help.repository.CheeringInMemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

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
    public IntSubscriber subscriber(CheeringService service, IntMessageBroker broker) {
        return new LocalIntSubscriber(service, broker);
    }

    @Bean
    @Scope("singleton")
    public IntMessageBroker broker() {
        return new LocalIntMessageBroker();
    }

    @Bean
    @Scope("singleton")
    public IntPublisher publisher(IntMessageBroker broker) {
        return new LocalIntPublisher(broker);
    }
}
