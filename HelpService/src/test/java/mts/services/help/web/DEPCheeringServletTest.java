package mts.services.help.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mts.services.help.CheeringManagerImp;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DEPCheeringServletTest {
    private HttpServletRequest req;
    private HttpServletResponse resp;
    private CheeringManagerImp manager;
    private DEP_CheeringServlet servlet;
    private StringWriter responseWriter;

    @BeforeEach
    public void setUp() throws IOException {

        manager = mock(CheeringManagerImp.class);
        req = mock(HttpServletRequest.class);
        resp = mock(HttpServletResponse.class);
        servlet = new DEP_CheeringServlet();
        servlet.setManager(manager);

        responseWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(responseWriter);
        when(resp.getWriter()).thenReturn(writer);

    }

/*
    @Test
    @DisplayName("Вовзрат корректной фразы из репозитория при вызове doGet")
    void handleDoGet() throws ServletException, IOException {
        //given
        String testPhrase = "Тестовое подбадривание";
        doReturn(testPhrase).when(this.manager).depricated_getCheeringPhrase();

        //when
        this.servlet.doGet(req, resp);

        //then
        verify(manager, times(1)).depricated_getCheeringPhrase();
        assertEquals(testPhrase, responseWriter.toString());

    }

 */
/*
    @Test
    @DisplayName("Возврат сообщения об успешном добавлении фразы при вызове doPost")
    void handleDoPost() throws ServletException, IOException {
        //given
        String testPhrase = "Тестовое подбадривание";
        String response = "Добавлена фраза: Тестовое подбадривание";

        doReturn(response).when(this.manager).depricated_addCheeringPhrase(testPhrase);
        doReturn(testPhrase).when(req).getParameter("phrase");

        //when
        this.servlet.doPost(req, resp);

        //then
        verify(manager, times(1)).depricated_addCheeringPhrase(testPhrase);
        assertEquals(response, responseWriter.toString());

    }
*/
}

