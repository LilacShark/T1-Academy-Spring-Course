package mts.actual.services.help.broker;

import mts.actual.services.help.CheeringServiceImp;
import mts.actual.services.help.broker.v1.LocalIntMessageBroker;
import mts.actual.services.help.broker.v1.LocalIntSubscriber;
import mts.actual.services.help.model.CheeringPhrase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LocalIntSubscriberTest {

    @Mock
    LocalIntMessageBroker broker;
    @Mock
    CheeringServiceImp serviceImp;
    @InjectMocks
    LocalIntSubscriber subscriber;

    @Test
    void getMessagesFromBroker() {

        //given
        CheeringPhrase cheeringPhrase = new CheeringPhrase("Тестовое подбадривание");
        when(broker.poll()).thenReturn(cheeringPhrase);

        //when
        this.subscriber.getMessagesFromBroker();

        //then
        verify(broker, times(1)).poll();
//        assertEquals(cheeringPhrase.getPhrase(), serviceCheeringPhrase.getPhrase());
    }

    @Test
    void savePhrase() {

        //given
        CheeringPhrase cheeringPhrase = new CheeringPhrase("Тестовое подбадривание");
        when(serviceImp.addCheeringPhrase(cheeringPhrase))
                .thenReturn("Добавлена фраза: " + cheeringPhrase.getPhrase());

        //when
        this.subscriber.savePhrase(cheeringPhrase);

        //then
        verify(serviceImp, times(1)).addCheeringPhrase(cheeringPhrase);
//        assertEquals(cheeringPhrase.getPhrase(), serviceCheeringPhrase.getPhrase());

    }
}