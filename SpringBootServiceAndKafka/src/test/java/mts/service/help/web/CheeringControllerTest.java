package mts.service.help.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mts.service.help.interfaces.CheeringService;
import mts.service.help.model.CheeringPhrase;
import mts.service.help.view.CheeringRequest;
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
class CheeringControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @SpyBean
    CheeringService cheeringService;

    @Test
    @DisplayName("Сервлет возвращает корреткную фразу")
    void getCheeringPhrase() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/getPhrase"))
                .andExpect(jsonPath("$.phrase")
                        .value("Всё будет хорошо!"));
    }

    @Test
    void addCheeringPhrase() throws Exception {
        final CheeringPhrase cheeringPhrase = new CheeringPhrase("Тестовое подбадривание");
        final CheeringRequest request = new CheeringRequest(cheeringPhrase);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/addPhrase")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());

        Mockito.verify(cheeringService, Mockito.times(1))
                .addCheeringPhrase(request);

    }
}