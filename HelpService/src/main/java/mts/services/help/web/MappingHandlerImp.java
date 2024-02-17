package mts.services.help.web;

import jakarta.servlet.http.HttpServletRequest;
import mts.services.help.ApplicationContext;
import mts.services.help.config.UrlMapping;
import mts.services.help.config.SemiAutoWired;
import mts.services.help.controllers.CheeringControllerImp;
import mts.services.help.interfaces.CheeringController;
import mts.services.help.interfaces.MappingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MappingHandlerImp implements MappingHandler {

    private static final Logger logger = LoggerFactory.getLogger(MappingHandlerImp.class);
    private final Map<String, Method> urlMapping = new HashMap<>();
    private final Map<String, Object> urlControllers = new HashMap<>();

    @SemiAutoWired
    private CheeringController cheeringController;

    public MappingHandlerImp() {
    }

    public Object getControllerClass(HttpServletRequest req) {
        return urlControllers.get(req.getPathInfo());
    }

    public Method getControllerMethod(HttpServletRequest req) {
        System.out.println("==== PROXY LOGGER ==== TIME:" + LocalDateTime.now() + "URL: " + req.getPathInfo() + " METHOD: " + req.getMethod());
        return urlMapping.get(req.getPathInfo());
    }

    public void setCheeringController(CheeringController controller) {
        this.cheeringController = controller;
    }

    public void initHandler(ApplicationContext context) {

        logger.info("====  public void initHandler(ApplicationContext context) {");
        System.out.println("====  public void initHandler(ApplicationContext context) {");

        List<?> controllers = context.getControllers();

        for (Object controller : controllers) {
            Method[] methods = controller.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(UrlMapping.class)) {
                    String value = method.getAnnotation(UrlMapping.class).value();
                    urlControllers.put(value, controller);
                    urlMapping.put(value, method);
                }
            }
        }
        
        for (String s : urlMapping.keySet()) {
            logger.info("====== " + s + "  "+ urlMapping.get(s));
            System.out.println("====== " + s + "  "+ urlMapping.get(s));
        }
    }
}
