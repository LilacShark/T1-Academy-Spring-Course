package mts.services.help.controller;

import mts.services.help.CheeringManager;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MappingHandler {

    private Map<String, Method> urlMapping = new HashMap<>();

//    TODO: сделать сбор маппинга динамическим, чтобы не менять компонент
    public MappingHandler() throws NoSuchMethodException {
        // Возможно тут должны быть методы сервлета
        urlMapping.put("getPhrase", CheeringManager.class.getMethod("depricated_getCheeringPhrase"));
        urlMapping.put("addPhrase", CheeringManager.class.getMethod("addCheeringPhrase"));
//        urlMapping.put("getPhrase", CheeringServlet.class.getMethod("doGet"));
//        urlMapping.put("addPhrase", CheeringServlet.class.getMethod("doPost"));
    }


}
