package web;

import mts.service.help.interfaces.CheeringService;
import mts.service.help.model.CheeringPhrase;
import mts.service.help.view.CheeringRequest;
import mts.service.help.view.CheeringResponse;
import mts.service.help.web.CheeringController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CheeringControllerTest {

    @Mock
    CheeringService cheeringService;

    @InjectMocks
    CheeringController cheeringController;


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

}
