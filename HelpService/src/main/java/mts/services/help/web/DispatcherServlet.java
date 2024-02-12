package mts.services.help.web;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mts.services.help.ApplicationContext;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class DispatcherServlet extends HttpServlet {

    private MappingHandler handler;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ApplicationContext context;
        try {
            context = new ApplicationContext();
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        handler = context.getInstance(MappingHandler.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);

    }

}
