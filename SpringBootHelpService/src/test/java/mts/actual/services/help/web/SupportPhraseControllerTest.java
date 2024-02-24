package mts.actual.services.help.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import mts.actual.services.help.model.CheeringPhrase;
import mts.actual.services.help.view.SupportRequest;
import mts.supportbroker.broker.InMemoryBroker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SupportPhraseControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @SpyBean
    private InMemoryBroker broker;

    @Test
    @DisplayName("Лекционный сервлет возвращает корреткную фразу")
    void gotPhraseIsOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/support"))
                .andExpect(jsonPath("$.phrase").value("Всё будет хорошо!"));
    }

    @Test
    void consumeMessage() throws Exception {
        final CheeringPhrase cheeringPhrase = new CheeringPhrase("Тестовое подбадривание");
        final SupportRequest request = new SupportRequest(cheeringPhrase);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/support")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());

        Mockito.verify(broker, Mockito.times(1))
                .publish(eq(objectMapper.writeValueAsString(request)));
        Mockito.verify(broker, Mockito.times(1))
                .take();
    }

}