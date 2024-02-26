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

/*

    @Test
    @DisplayName("Получение фразы успешно")
    void getCheeringPhrase() {

        //given
        CheeringPhrase cheeringPhrase = new CheeringPhrase("Тестовое подбадривание");
        when(cheeringController.getCheeringPhrase()).thenReturn(cheeringPhrase);

        //when
        CheeringPhrase controllerCheeringPhrase = this.cheeringController.getCheeringPhrase();

        //then
        verify(cheeringService, times(1)).getCheeringPhrase();
        assertEquals(cheeringPhrase.getPhrase(), controllerCheeringPhrase.getPhrase());

    }

    @Test
    @DisplayName("Добавление фразы успешно")
    void addCheeringPhrase_OK() {

        //given
        CheeringRequest supportRequest = new CheeringRequest(
                new CheeringPhrase("Тестовое подбадривание"));
        when(intPublisher.offer((any(CheeringRequest.class)))).thenReturn("Фраза " + supportRequest.getCheeringPhrase().getPhrase() + " предложена к добавлению..");

        //when
        CheeringRequest supportResponse = this.cheeringController.addCheeringPhrase(supportRequest);

        //then
        verify(intPublisher, times(1)).offer(supportRequest);
        assertEquals("Фраза Тестовое подбадривание предложена к добавлению..", supportResponse.getResponse());
        assertEquals(HttpStatus.CREATED, supportResponse.getStatus());
    }
*/