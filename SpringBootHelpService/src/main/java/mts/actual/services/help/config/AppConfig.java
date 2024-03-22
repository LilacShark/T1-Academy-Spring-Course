package mts.actual.services.help.config;

import mts.actual.services.help.CheeringServiceImp;
import mts.actual.services.help.broker.v1.LocalIntMessageBroker;
import mts.actual.services.help.broker.v1.LocalIntPublisher;
import mts.actual.services.help.broker.v1.LocalIntSubscriber;
import mts.actual.services.help.interfaces.CheeringService;
import mts.actual.services.help.model.CheeringPhrase;
import mts.actual.services.help.repository.CheeringInMemRepository;
import mts.actual.services.help.view.SupportRequest;
import mts.cheeringbroker.broker.IntMessageBroker;
import mts.cheeringbroker.broker.IntPublisher;
import mts.cheeringbroker.broker.IntSubscriber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public CheeringInMemRepository repository() {
        return new CheeringInMemRepository();
    }

    @Bean
    public CheeringServiceImp serviceImp(CheeringInMemRepository repository) {
        return new CheeringServiceImp(repository);
    }

    @Bean
    public IntSubscriber<CheeringPhrase> subscriber(CheeringService service, IntMessageBroker broker) {
        return new LocalIntSubscriber(service, broker);
    }

    @Bean
    public IntMessageBroker<CheeringPhrase> broker() {
        return new LocalIntMessageBroker();
    }

    @Bean
    public IntPublisher<SupportRequest> publisher(IntMessageBroker<CheeringPhrase> broker) {
        return new LocalIntPublisher(broker);
    }


    //   перенесли паблишер в аппконфиг
}
