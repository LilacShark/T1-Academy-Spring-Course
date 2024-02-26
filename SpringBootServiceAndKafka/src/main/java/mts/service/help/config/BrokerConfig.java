package mts.service.help.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import mts.service.help.broker.CheeringConsumer;
import mts.service.help.broker.CheeringProducer;
import mts.service.help.interfaces.CheeringService;
import mts.service.help.repository.CheeringInMemRepository;
import mts.service.help.services.CheeringServiceKafkaImp;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//@EnableConfigurationProperties(BrokerConfig.class)

@ConditionalOnProperty(prefix = "inmemory-broker", name = "enabled", havingValue = "true")
@Configuration
public class BrokerConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public CheeringProducer messageProducer() {
        return new CheeringProducer();
    }

    @Bean
    public CheeringConsumer messageListener(CheeringInMemRepository repository) {
        return new CheeringConsumer(repository);
    }

    @Bean
    @Primary
    public CheeringService serviceImp(CheeringInMemRepository repository,
                                      CheeringProducer producer,
                                      CheeringConsumer consumer) {
        return new CheeringServiceKafkaImp(repository, producer, consumer);
    }

}
