package mts.services.help.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mts.services.help.ApplicationContext;
import mts.services.help.controllers.CheeringController;
import mts.services.help.interfaces.MappingHandler;
import mts.services.help.view.SupportResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DispatcherServlet extends HttpServlet {

    private ApplicationContext context;
    private MappingHandler handler;
    private CheeringController controller;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

//        context = ApplicationContext.get_APPLICATION_CONTEXT_INSTANCE();
        try {
            context = new ApplicationContext();
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        handler = context.getInstance(MappingHandler.class);
        controller = context.getInstance(CheeringController.class);

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Method controllerMethod = handler.getControllerMethod(req);
        SupportResponse supportResponse;
        try {
            if (controllerMethod.getParameters().length == 0) {
                supportResponse = (SupportResponse) controllerMethod.invoke(controller);
            } else {
                supportResponse = (SupportResponse) controllerMethod.invoke(controller, req);
            }

        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        objectMapper.writeValue(resp.getWriter(), supportResponse);

        resp.getWriter().flush();
    }

}
