package mts.services.help;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class CheeringServletTest {

    private CheeringManager manager;
    private HttpServletRequest req;
    private HttpServletResponse resp;
    private CheeringServlet servlet;
    private StringWriter responseWriter;

    @BeforeEach
    public void setUp() throws IOException {

        manager = mock(CheeringManager.class);
        req = mock(HttpServletRequest.class);
        resp = mock(HttpServletResponse.class);
        servlet = new CheeringServlet(manager);
        responseWriter = new StringWriter();

        PrintWriter writer = new PrintWriter(responseWriter);
        when(resp.getWriter()).thenReturn(writer);
//        when(resp.getWriter()).thenReturn(new PrintWriter(responseWriter));
    }


    @Test
    @DisplayName("Вовзрат корректной фразы из репозитория при вызове doGet")
    void handleDoGet() throws ServletException, IOException {
//        MockitoAnnotations.initMocks(this);
        //given
        String testPhrase = "Тестовое подбадривание";
        doReturn(testPhrase).when(this.manager).getCheeringPhrase();

        //when
//        when(resp.getWriter()).thenReturn(writer);

        this.servlet.doGet(req, resp);

        //then
        verify(manager, times(1)).getCheeringPhrase();
        assertEquals(testPhrase, responseWriter.toString());

    }

    @Test
    @DisplayName("Возврат сообщения об успешном добавлении фразы при вызове doPost")
    void handleDoPost() throws ServletException, IOException {
        //given
        String testPhrase = "Тестовое подбадривание";
        String response = "Добавлена фраза: Тестовое подбадривание";

        doReturn(response).when(this.manager).addCheeringPhrase(testPhrase);
        doReturn(testPhrase).when(req).getParameter("phrase");

        //when
        this.servlet.doPost(req, resp);

        //then
        verify(manager, times(1)).addCheeringPhrase(testPhrase);
        assertEquals(response, responseWriter.toString());

    }
}

/*
    //    @Mock
    private CheeringManager manager;
    //    @Mock
    private HttpServletRequest req;
    //    @Mock
    private HttpServletResponse resp;

    //    @InjectMocks
    private CheeringServlet servlet;
 */