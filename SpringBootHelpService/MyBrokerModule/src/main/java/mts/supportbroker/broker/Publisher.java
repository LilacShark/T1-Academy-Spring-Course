package mts.supportbroker.broker;

public class Publisher<T> {

    private final InMemoryBroker broker;
    private final ObjectMapper mapper; //jackson

    public Publisher(InMemoryBroker broker, ObjectMapper mapper) {
        this.broker = broker;
        this.mapper = mapper;
    }

    public void publish(T object) {
        broker.publish(mapper.writeValueAsString(object));
    }
}
