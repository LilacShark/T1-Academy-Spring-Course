package mts.services.help.web;

import jakarta.servlet.http.HttpServletRequest;
import mts.services.help.ApplicationContext;
import mts.services.help.config.UrlMapping;
import mts.services.help.config.SemiAutoWired;
import mts.services.help.controllers.CheeringController;
import mts.services.help.interfaces.MappingHandler;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


public class MappingHandlerImp implements MappingHandler {

    private final Map<String, Method> urlMapping = new HashMap<>();

    @SemiAutoWired
    private CheeringController cheeringController;

    public MappingHandlerImp() {
    }

    public Method getControllerMethod(HttpServletRequest req) {
        System.out.println("==== PROXY LOGGER ==== TIME:" + LocalDateTime.now() + "URL: " + req.getPathInfo() + " METHOD: " + req.getMethod());
        return urlMapping.get(req.getPathInfo());
    }

    public void setCheeringController(CheeringController controller) {
        this.cheeringController = controller;
    }

    public CheeringController getCheeringController() {
        return cheeringController;
    }

    public void initHandler(ApplicationContext context) {
        Method[] methods = cheeringController.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(UrlMapping.class)) {
                String value = method.getAnnotation(UrlMapping.class).value();
                urlMapping.put(value, method);
            }
        }
        System.out.println(urlMapping);
    }
}
