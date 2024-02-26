package mts.service.help;

import mts.service.help.interfaces.CheeringService;
import mts.service.help.repository.CheeringInMemRepository;
import mts.service.help.web.CheeringController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@AutoConfigureMockMvc
class ProgramTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    CheeringService cheeringService;

    @Autowired
    CheeringController cheeringController;

    @Autowired
    CheeringInMemRepository repository;

    @Test
    @DisplayName("Минимальный набор бинов создаётся")
    void allBeansCreated() {
        assertThat(cheeringService).isNotNull();
        assertThat(cheeringController).isNotNull();
        assertThat(repository).isNotNull();
    }

}