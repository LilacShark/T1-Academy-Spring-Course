package mts.actual.services.help;

import mts.actual.services.help.model.CheeringPhrase;
import mts.actual.services.help.repository.CheeringInMemRepository;
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
        when(repository.addCheeringPhrase((any(CheeringPhrase.class)))).thenReturn(true);

        //when
        String added = this.cheeringService.addCheeringPhrase(phrase);

        //then
        verify(repository, times(1)).addCheeringPhrase(phrase);
        assertEquals("Добавлена фраза: Тестовое подбадривание", added);
    }

}