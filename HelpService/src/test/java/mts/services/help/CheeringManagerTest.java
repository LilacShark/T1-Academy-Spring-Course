package mts.services.help;

import mts.services.help.interfaces.CheeringManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheeringManagerTest {

    @Test
    @DisplayName("Сервис возвращает фразу поддержки")
    public void getPhrase() {
        ApplicationContext context = ApplicationContext.get_APPLICATION_CONTEXT_INSTANCE();
        CheeringManager manager = context.getInstance(CheeringManager.class);
        assertEquals("Подбрадривание для Вас: Тестовое подбадривание",
                manager.provideSupport());
    }

}