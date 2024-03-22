package mts.supportbroker.broker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Publisher<T> {

    private final InMemoryBroker broker;
    private final ObjectMapper mapper; //jackson

    public Publisher(InMemoryBroker broker, ObjectMapper mapper) {
        this.broker = broker;
        this.mapper = mapper;
    }

    public void publish(T object) {
        try {
            System.out.println("Publisher - publish.." + mapper.writeValueAsString(object));
            broker.publish(mapper.writeValueAsString(object));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
