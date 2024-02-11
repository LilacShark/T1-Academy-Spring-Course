package mts.services.help.web;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


// В лекции было сказано, что всю логику работы по метаданным перенести из сервлета сюда.
// Если это сделать (пусть даже в прокси) не будет ли это нарушением Single Responsibility?
// Не лучше ли оставить эту логику в новом сервеле?

// Добавить логгирование через прокси

public class MappingHandler {

    private Map<String, Method> urlMapping = new HashMap<>();

//    TODO: сделать сбор маппинга динамическим, чтобы не менять компонент
    public MappingHandler() throws NoSuchMethodException {
        // Возможно тут должны быть методы сервлета
//        urlMapping.put("getPhrase", CheeringManager.class.getMethod("getCheeringPhrase"));
//        urlMapping.put("addPhrase", CheeringManager.class.getMethod("addCheeringPhrase"));
        urlMapping.put("getPhrase", DEP_CheeringServlet.class.getMethod("doGet"));
        urlMapping.put("addPhrase", DEP_CheeringServlet.class.getMethod("doPost"));
    }


}
