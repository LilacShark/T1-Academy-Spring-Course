package mts.services.help.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//1:04:00
//1:09:00 -- добавление маппингов куда-то
class DispatcherServletTest {


    @Test
    @DisplayName("Вовзрат корректной фразы из репозитория при вызове /getPhrase")
    void service() {
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



    }
}


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