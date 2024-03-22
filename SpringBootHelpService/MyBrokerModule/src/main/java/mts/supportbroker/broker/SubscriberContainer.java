package mts.supportbroker.broker;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static mts.supportbroker.broker.SubscriberBeanPostProcessor.METHOD_2_BEAN;

public class SubscriberContainer {

    private final ObjectMapper objectMapper;
    private final InMemoryBroker broker;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @PostConstruct
    private void init() {
        METHOD_2_BEAN.forEach((key, value) -> executorService.submit(() -> {
            while (true) {
                final var message = broker.take();
                key.invoke(value,
                        objectMapper.readValue(message,
                                key.getParameterTypes()[0]));
            }
        }));
    }

    public SubscriberContainer(ObjectMapper objectMapper, InMemoryBroker broker) {
        this.objectMapper = objectMapper;
        this.broker = broker;
    }
}
