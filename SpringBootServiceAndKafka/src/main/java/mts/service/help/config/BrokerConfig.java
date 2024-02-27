package mts.service.help.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import mts.service.help.broker.CheeringConsumer;
import mts.service.help.broker.CheeringProducer;
import mts.service.help.broker.interfaces.Consumer;
import mts.service.help.broker.interfaces.Producer;
import mts.service.help.interfaces.CheeringService;
import mts.service.help.model.CheeringPhrase;
import mts.service.help.repository.CheeringInMemRepository;
import mts.service.help.services.CheeringServiceKafkaImp;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@ConditionalOnProperty(prefix = "kafka-toggle", name = "enabled", havingValue = "true")
@Configuration
public class BrokerConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public Producer<CheeringPhrase> cheeringProducer() {
        return new CheeringProducer();
    }

    @Bean
    public Consumer cheeringConsumer(CheeringInMemRepository repository) {
        return new CheeringConsumer(repository);
    }

    @Bean
    @Primary
    public CheeringService serviceImp(CheeringInMemRepository repository,
                                      Producer producer,
                                      Consumer consumer) {
        return new CheeringServiceKafkaImp(repository, producer, consumer);
    }

}
