package mts.actual.services.help.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import mts.actual.services.help.view.SupportRequest;
import mts.supportbroker.broker.InMemoryBroker;
import mts.supportbroker.broker.Publisher;
import mts.supportbroker.broker.SubscriberBeanPostProcessor;
import mts.supportbroker.broker.SubscriberContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InMemBrokerConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public InMemoryBroker inMemoryBroker() {
        return new InMemoryBroker();
    }

    @Bean
    public Publisher<SupportRequest> supportRequestPublisher(InMemoryBroker broker, ObjectMapper mapper) {
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
