package services;

import mts.service.help.model.CheeringPhrase;
import mts.service.help.repository.CheeringInMemRepository;
import mts.service.help.services.CheeringServiceImp;
import mts.service.help.view.CheeringRequest;
import mts.service.help.view.CheeringResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CheeringServiceImpTest {

    @Mock
    CheeringInMemRepository repository;
    @InjectMocks
    CheeringServiceImp cheeringService;

    @Test
    void getCheeringPhrase() {

        //given
        CheeringPhrase cheeringPhrase = new CheeringPhrase("Тестовое подбадривание");
        when(repository.getCheeringPhrase()).thenReturn(cheeringPhrase);

        //when
        CheeringPhrase serviceCheeringPhrase = this.cheeringService.getCheeringPhrase();

        //then
        verify(repository, times(1)).getCheeringPhrase();
        assertEquals(cheeringPhrase.getPhrase(), serviceCheeringPhrase.getPhrase());
    }

    @Test
    void addCheeringPhrase() {

        //given
        CheeringPhrase phrase = new CheeringPhrase("Тестовое подбадривание");
        CheeringRequest request = new CheeringRequest(phrase);
        when(repository.addCheeringPhrase((any(CheeringPhrase.class)))).thenReturn(true);

        //when
        CheeringResponse response = this.cheeringService.addCheeringPhrase(request);

        //then
        verify(repository, times(1)).addCheeringPhrase(phrase);
        assertEquals("Фраза 'CheeringPhrase{phrase='Тестовое подбадривание'}' добавлена", response.getResponse());
    }

}