package mts.supportbroker.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import mts.supportbroker.broker.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnProperty(prefix = "inmemory-broker",
        name = "enabled",
        havingValue = "true")
@Configuration
@EnableConfigurationProperties(InMemConfigProperties.class)
public class InMemBrokerConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public InMemoryBroker inMemoryBroker() {
        return new InMemoryBroker();
    }

//   перенесли паблишер в аппконфиг
    @Bean
    public Publisher supportRequestPublisher(InMemoryBroker broker, ObjectMapper mapper) {
        return new Publisher<>(broker, mapper);
    }

    @Bean
    public SubscriberContainer subscriberContainer(InMemoryBroker broker, ObjectMapper mapper) {
        return new SubscriberContainer(mapper, broker);
    }

    @Bean
    public SubscriberBeanPostProcessor beanPostProcessor() {
        return new SubscriberBeanPostProcessor();
    }
}
