package mts.actual.services.help.web;

import mts.actual.services.help.interfaces.CheeringService;
import mts.actual.services.help.model.CheeringPhrase;
import mts.actual.services.help.view.SupportRequest;
import mts.actual.services.help.view.SupportResponse;
import mts.cheeringbroker.broker.IntPublisher;
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
    @Mock
    IntPublisher<SupportRequest> intPublisher;
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
        SupportRequest supportRequest = new SupportRequest(
                new CheeringPhrase("Тестовое подбадривание"));
        when(intPublisher.offer((any(SupportRequest.class)))).thenReturn("Фраза " + supportRequest.getCheeringPhrase().getPhrase() + " предложена к добавлению..");

        //when
        SupportResponse supportResponse = this.cheeringController.addCheeringPhrase(supportRequest);

        //then
        verify(intPublisher, times(1)).offer(supportRequest);
        assertEquals("Фраза Тестовое подбадривание предложена к добавлению..", supportResponse.getResponse());
        assertEquals(HttpStatus.OK, supportResponse.getStatus());
    }

    @Test
    @DisplayName("Добавление фразы с ошибкой")
    void addCheeringPhrase_ERROR() {

        //given
        SupportRequest supportRequest = new SupportRequest(
                new CheeringPhrase("Тестовое подбадривание"));
        when(intPublisher.offer((any(SupportRequest.class)))).thenReturn("Ошибка");

        //when
        SupportResponse supportResponse = this.cheeringController.addCheeringPhrase(supportRequest);

        //then
        verify(intPublisher, times(1)).offer(supportRequest);
        assertEquals("Ошибка", supportResponse.getResponse());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, supportResponse.getStatus());
    }

}
