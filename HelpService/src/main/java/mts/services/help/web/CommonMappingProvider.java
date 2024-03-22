package mts.services.help.web;

import jakarta.servlet.http.HttpServletRequest;
import mts.services.help.ApplicationContext;
import mts.services.help.config.UrlMapping;
import mts.services.help.controllers.CheeringControllerImp;
import mts.services.help.interfaces.MappingProvider;
import mts.services.help.model.Handler;
import mts.services.help.model.HttpMethod;
import mts.services.help.model.Mapping;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonMappingProvider implements MappingProvider {

    private Map<Mapping, Handler> mappingToHandler = new HashMap<>();

    public void init(ApplicationContext context) {
        List<?> controllers = context.getControllers();
        for (Object controller : controllers) {
            Method[] methods = ((CheeringControllerImp) controller).getClass().getDeclaredMethods();
            System.out.println(controller.getClass());
            for (Method method : methods) {
                System.out.println(method.getName());
                if (method.isAnnotationPresent(UrlMapping.class)) {
                    addMapping(controller, method);
                }
            }
        }

//        for (Object controller : controllers) {
//            Arrays.stream(controller.getClass().getMethods())
//                    .filter(method -> method.isAnnotationPresent(UrlMapping.class))
//                    .forEach(method -> addMapping(controller, method));
//        }

        for (Mapping mapping : mappingToHandler.keySet()) {
            System.out.println("=== " + mapping + " " + mappingToHandler.get(mapping));
        }
    }

    private void addMapping(Object controller, Method method) {
        final var mappingAnnotation = method.getAnnotation(UrlMapping.class);
        mappingToHandler.put(
                new Mapping(mappingAnnotation.path(), mappingAnnotation.method()),
                new Handler(controller, method)
        );
    }

    public Handler getMapping(HttpServletRequest req) {
        return mappingToHandler.get(new Mapping(req.getRequestURL().toString(), HttpMethod.valueOf(req.getMethod())));
    }

}
/*
public void init(ApplicationContext context) {
        List<?> controllers = context.getControllers();


        for (Object controller : controllers) {
            Arrays.stream(controller.getClass().getMethods())
                    .filter(method -> method.isAnnotationPresent(UrlMapping.class))
                    .forEach(method -> addMapping(controller, method));
        }

        for (Mapping mapping : mappingToHandler.keySet()) {
            System.out.println("=== " + mapping + " " + mappingToHandler.get(mapping));
        }
    }
 */