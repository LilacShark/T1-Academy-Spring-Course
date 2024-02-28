package mts.services.help;

import mts.services.help.interfaces.CheeringManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class CheeringManagerTest {

    @Test
    @DisplayName("Сервис возвращает фразу поддержки")
    public void getPhrase() throws InvocationTargetException, IllegalAccessException {
        ApplicationContext context = new ApplicationContext();
        CheeringManager manager = context.getInstance(CheeringManager.class);
        assertEquals("Подбрадривание для Вас: Тестовое подбадривание",
                manager.provideSupport());
    }

}