package mts.services.help;

import mts.services.help.controllers.CheeringControllerImp;
import mts.services.help.interfaces.CheeringController;
import mts.services.help.interfaces.CheeringService;
import mts.services.help.interfaces.CheeringManager;
import mts.services.help.interfaces.MappingHandler;
import mts.services.help.repository.CheeringInMemRepository;
import mts.services.help.web.MappingHandlerImp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextTest {

    @Test
    @DisplayName("Контекст возвращает экземпляр класса")
    public void getInstance() throws InvocationTargetException, IllegalAccessException {
        ApplicationContext context = new ApplicationContext();
        assertEquals(CheeringInMemRepository.class,context.getInstance(CheeringInMemRepository.class).getClass());
        assertEquals(CheeringServiceImp.class,context.getInstance(CheeringService.class).getClass());
        assertEquals(CheeringManagerImp.class,context.getInstance(CheeringManager.class).getClass());
        assertEquals(CheeringControllerImp.class,context.getInstance(CheeringController.class).getClass());
        assertEquals(MappingHandlerImp.class,context.getInstance(MappingHandler.class).getClass());

    }


}
