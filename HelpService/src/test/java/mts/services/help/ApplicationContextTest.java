package mts.services.help;

import mts.services.help.controllers.CheeringControllerImp;
import mts.services.help.interfaces.*;
import mts.services.help.repository.CheeringInMemRepository;
import mts.services.help.web.CommonMappingProvider;
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
        MappingProvider instance = context.getInstance(MappingProvider.class);
        instance.init(context);
        MappingHandler mappingProvider = context.getInstance(MappingHandler.class);
        mappingProvider.initHandler(context);

        assertEquals(CheeringInMemRepository.class,context.getInstance(CheeringInMemRepository.class).getClass());
        assertEquals(CheeringServiceImp.class,context.getInstance(CheeringService.class).getClass());
        assertEquals(CheeringManagerImp.class,context.getInstance(CheeringManager.class).getClass());
        assertEquals(CheeringControllerImp.class,context.getInstance(CheeringController.class).getClass());
        assertEquals(MappingHandlerImp.class,context.getInstance(MappingHandler.class).getClass());
        assertEquals(JsonTypeHttpCallDispatcher.class,context.getInstance(HttpCallDispatcher.class).getClass());
        assertEquals(CommonMappingProvider.class,context.getInstance(MappingProvider.class).getClass());


    }


}
