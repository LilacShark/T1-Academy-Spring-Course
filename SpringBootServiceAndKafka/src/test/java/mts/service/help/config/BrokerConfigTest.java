package mts.service.help.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import mts.service.help.broker.CheeringConsumer;
import mts.service.help.broker.CheeringProducer;
import mts.service.help.interfaces.CheeringService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ConditionalOnProperty(prefix = "kafka-toggle", name = "enabled", havingValue = "true")
@SpringBootTest
@AutoConfigureMockMvc
class BrokerConfigTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired

    ObjectMapper objectMapper;
    @Autowired

    CheeringProducer producer;
    @Autowired

    CheeringConsumer consumer;

    @Autowired
    CheeringService service;

    @Test
    @DisplayName("Набор бинов кафки создаётся")
    void kafkaBeansCreated() {
        assertThat(objectMapper).isNotNull();
        assertThat(producer).isNotNull();
        assertThat(consumer).isNotNull();
        assertThat(service).isNotNull();
    }

}