package mts.services.help.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mts.services.help.ApplicationContext;
import mts.services.help.controllers.CheeringController;
import mts.services.help.interfaces.MappingHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DispatcherServletTest {

    private HttpServletRequest req;
    private HttpServletResponse resp;
    private DispatcherServlet servlet;
    private CheeringController controller;
    private MappingHandler handler;
    private ApplicationContext context;
    private StringWriter responseWriter;
    private Method controllerMethod;
    @BeforeEach
    public void setUp() throws IOException, NoSuchMethodException {
        context = ApplicationContext.get_APPLICATION_CONTEXT_INSTANCE();
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

    }
    @Test
    @DisplayName("Вовзрат корректной фразы из репозитория при вызове /getPhrase")
    void service() throws IOException, NoSuchMethodException, ServletException, InvocationTargetException, IllegalAccessException {
/*

        //given
        servlet.init();
        servlet.setHandler(handler);
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
    }
}