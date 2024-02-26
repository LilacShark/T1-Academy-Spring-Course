package web;

import com.fasterxml.jackson.databind.ObjectMapper;
import mts.service.help.interfaces.CheeringService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


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
    void gotPhraseIsOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/getPhrase"))
                .andExpect(jsonPath("$.phrase")
                        .value("Всё будет хорошо!"));
    }

}
