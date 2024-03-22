package mts.services.help.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DispatcherServletTest {


    @Test
    @DisplayName("Вовзрат корректной фразы из репозитория при вызове /getPhrase")
    void service() throws ServletException, IOException {
/*
//        StringBuilder builder = new StringBuilder();
//        PrintWriter printWriter = new PrintWriter();
        final var request = mock(HttpServletRequest.class);
        final var response = mock(HttpServletResponse.class);
        final var dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.init();
        dispatcherServlet.service(request, response);

        when(request.getRequestURL()).thenReturn(new StringBuffer("/getPhrase"));
        when(request.getMethod()).thenReturn("GET");
//        when(response.getWriter()).thenReturn(printWriter);

*/

//        assertEquals();

    }
}
/*
        final StringWriter stringWriter = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(stringWriter);
        final var request = mock(HttpServletRequest.class);
        when(request.getPathInfo()).thenReturn(new String("getPhrase"));
        when(request.getMethod()).thenReturn("GET");
        final var response = mock(HttpServletResponse.class);
        when(response.getWriter()).thenReturn(printWriter);

        final var dispatcher = new DispatcherServlet();
        dispatcher.init();


        dispatcher.service(request, response);


        assertEquals("""
                {
                    "phrase": "hey!"
                }
                """, stringWriter.toString());

 */

/*

    private HttpServletRequest req;
    private HttpServletResponse resp;
    private DispatcherServlet servlet;
    private CheeringController controller;
    private MappingHandler handler;
    private ApplicationContext context;
    private StringWriter responseWriter;
    private Method controllerMethod;



        context = new ApplicationContext();
        controller = context.getInstance(CheeringController.class);
        handler = new MappingHandlerImp();
        req = mock(HttpServletRequest.class);
        resp = mock(HttpServletResponse.class);
        controllerMethod = mock(Method.class);

        servlet = new DispatcherServlet();

        responseWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(responseWriter);
        when(resp.getWriter()).thenReturn(writer);
        when(req.getPathInfo()).thenReturn("/getPhrase");
 */

/*

        //given
        servlet.init();

        SupportResponse testResponse = new SupportResponse("Тестовое подбадривание", "OK");
        doReturn(testResponse).when(this.controllerMethod).invoke(controller);


        //when
        this.servlet.service(req, resp);

        //then
        verify(controller, times(1)).getPhrase();
        System.out.println(testResponse);
        System.out.println(responseWriter.toString());
        assertEquals(testResponse, responseWriter.toString());

*/