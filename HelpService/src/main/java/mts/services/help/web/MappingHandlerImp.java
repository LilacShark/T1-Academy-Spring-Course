package mts.services.help.web;

import jakarta.servlet.http.HttpServletRequest;
import mts.services.help.controllers.CheeringController;
import mts.services.help.interfaces.MappingHandler;
import mts.services.help.view.SupportRequest;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// В лекции было сказано, что всю логику работы по метаданным перенести из сервлета сюда.
// Если это сделать (пусть даже в прокси) не будет ли это нарушением Single Responsibility?
// Не лучше ли оставить эту логику в новом сервеле?

// Добавить логгирование через прокси

public class MappingHandlerImp implements MappingHandler {

    private final Map<String, Method> urlMapping = new HashMap<>();
    private List<?> controllers;

//    TODO: сделать сбор маппинга динамическим, чтобы не менять компонент
//    По какой-то причине появляется зацикливание при сборке, если получить тут ApplicationContext. Даже через синглтон
    public MappingHandlerImp() throws NoSuchMethodException {
//        getAnnotation(PostMapping.class).value();
//        getAnnotation(GetMapping.class).value();

        urlMapping.put("/getPhrase", CheeringController.class.getMethod("getPhrase"));
        urlMapping.put("/addPhrase", CheeringController.class.getMethod("addPhrase", SupportRequest.class));
    }


    public Method getControllerMethod(HttpServletRequest req) {
        System.out.println("==== PROXY LOGGER ==== TIME:" + LocalDateTime.now() + "URL: " + req.getPathInfo() + " METHOD: " + req.getMethod());
        return urlMapping.get(req.getPathInfo());
    }
}
