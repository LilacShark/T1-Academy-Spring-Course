package mts.service.help.broker.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import mts.service.help.broker.CheeringConsumer;
import mts.service.help.broker.CheeringProducer;
import mts.service.help.broker.interfaces.Consumer;
import mts.service.help.broker.interfaces.Producer;
import mts.service.help.interfaces.CheeringService;
import mts.service.help.model.CheeringPhrase;
import mts.service.help.repository.CheeringInMemRepository;
import mts.service.help.services.CheeringServiceKafkaImp;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import java.util.HashMap;
import java.util.Map;

@EnableKafka
@ConditionalOnProperty(prefix = "kafka-toggle", name = "enabled", havingValue = "true")
@Configuration
public class BrokerConfig {

    @Value("${kafka.server}")
    private String kafkaServer;
    @Value("${kafka.group.id}")
    private String kafkaGroupId;
    @Value("producerServer")
    private String kafkaProducerId;


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
                                      Producer<CheeringPhrase> producer,
                                      Consumer consumer) {
        return new CheeringServiceKafkaImp(repository, producer, consumer);
    }

    @Bean
    public ProducerFactory<String, CheeringPhrase> cheeringProducerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        configProps.put(ProducerConfig.CLIENT_ID_CONFIG, kafkaProducerId);
        configProps.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, CheeringPhrase> cheeringTemplate() {
        return new KafkaTemplate<>(cheeringProducerFactory());
    }

    @Bean
    public ConsumerFactory<String, CheeringPhrase> cheeringConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaGroupId);
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        props.put(ConsumerConfig.ISOLATION_LEVEL_CONFIG, IsolationLevel.READ_COMMITTED);

        return new DefaultKafkaConsumerFactory<>(props,
                new StringDeserializer(),
                new JsonDeserializer<>(CheeringPhrase.class)
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, CheeringPhrase> cheeringKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, CheeringPhrase> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(cheeringConsumerFactory());

        return factory;
    }
}