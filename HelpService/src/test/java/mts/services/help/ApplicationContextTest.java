package mts.services.help;

import mts.services.help.interfaces.CheeringService;
import mts.services.help.interfaces.CheeringManager;
import mts.services.help.repository.CheeringInMemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextTest {

    @Test
    @DisplayName("Контекст возвращает экземпляр класса")
    public void getInstance() {
        ApplicationContext context = ApplicationContext.get_APPLICATION_CONTEXT_INSTANCE();
        assertEquals(CheeringInMemRepository.class,context.getInstance(CheeringInMemRepository.class).getClass());
        assertEquals(CheeringServiceImp.class,context.getInstance(CheeringService.class).getClass());
        assertEquals(CheeringManagerImp.class,context.getInstance(CheeringManager.class).getClass());
    }
}
