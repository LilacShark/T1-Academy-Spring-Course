package mts.services.help.web;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mts.services.help.ApplicationContext;
import mts.services.help.interfaces.HttpCallDispatcher;
import mts.services.help.interfaces.MappingHandler;
import mts.services.help.interfaces.MappingProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class DispatcherServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    private ApplicationContext context;
    private MappingHandler mappingHandler;
    private MappingProvider mappingProvider;
    private HttpCallDispatcher callDispatcher;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        logger.info("==== INIT START ====");

        try {
            context = new ApplicationContext();
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
//        mappingHandler = context.getInstance(MappingHandler.class);
//        mappingHandler.initHandler(context);

        mappingProvider = context.getInstance(MappingProvider.class);
        mappingProvider.init(context);

        callDispatcher = context.getInstance(HttpCallDispatcher.class);

        logger.info("==== INIT END ====");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        final var handlerMapping = mappingProvider.getMapping(req);
        callDispatcher.dispatch(handlerMapping, resp);
    }

}

/*

        ObjectMapper objectMapper = new ObjectMapper();
        Object controllerClass = handler.getControllerClass(req);
        Method controllerMethod = handler.getControllerMethod(req);
        SupportResponse supportResponse;
        try {
            if (controllerMethod.getParameters().length == 0) {
                supportResponse = (SupportResponse) controllerMethod.invoke(controllerClass);
            } else {
                supportResponse = (SupportResponse) controllerMethod.invoke(controllerClass, req);
            }

        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        objectMapper.writeValue(resp.getWriter(), supportResponse);

        resp.getWriter().flush();
 */