package mts.service.help.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import mts.service.help.repository.CheeringInMemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class CheeringServiceImpTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    CheeringInMemRepository repository;

    @Test
    @DisplayName("Сервис возвращает корреткную фразу из репо")
    void getCheeringPhrase() {

    }

    @Test
    @DisplayName("Сервис получает реквест, добавляет фразу в репо и даёт ответ")
    void addCheeringPhrase() {
    }
}