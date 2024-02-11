package mts.services.help;

import mts.services.help.interfaces.CheeringService;
import mts.services.help.repository.CheeringInMemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextTest {

    @Test
    @DisplayName("Контекст возвращает экземпляр класса")
    public void getInstance() throws InvocationTargetException, IllegalAccessException {
        ApplicationContext context = new ApplicationContext();
        assertEquals(CheeringManager.class,context.getInstance(CheeringManager.class).getClass());
        assertEquals(CheeringServiceImp.class,context.getInstance(CheeringService.class).getClass());
        assertEquals(CheeringInMemRepository.class,context.getInstance(CheeringInMemRepository.class).getClass());
    }
}
