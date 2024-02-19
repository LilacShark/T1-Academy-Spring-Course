package mts.actual.services.help.broker;

import mts.actual.services.help.model.CheeringPhrase;
import mts.actual.services.help.view.SupportRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LocalIntPublisherTest {

    @Mock
    LocalIntMessageBroker broker;

    @InjectMocks
    LocalIntPublisher publisher;

    @Test
    void offer() {

        //given
        CheeringPhrase cheeringPhrase = new CheeringPhrase("Тестовое подбадривание");
        SupportRequest supportRequest = new SupportRequest(cheeringPhrase);
        when(broker.offer(cheeringPhrase)).thenReturn(true);

        //when
        String offered = this.publisher.offer(supportRequest);

        //then
        verify(broker, times(1)).offer(cheeringPhrase);
        assertEquals("Фраза " + supportRequest.getCheeringPhrase().getPhrase() + " предложена к добавлению..", offered);

    }
}