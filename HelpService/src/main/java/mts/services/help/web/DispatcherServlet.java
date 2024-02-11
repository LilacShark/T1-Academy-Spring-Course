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

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // СДЕЛАТЬ КОНТЕКСТ ЗДЕСЬ
        try {
            ApplicationContext context = new ApplicationContext();
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
        String method = req.getMethod();

        if (method.equals("GET") || method.equals("POST")) {

        }
    }

//    @Override
//    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        super.service(req, res);
//    }


}
