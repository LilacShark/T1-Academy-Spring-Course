package mts.services.help.web;

import jakarta.servlet.http.HttpServletRequest;
import mts.services.help.CheeringController;
import mts.services.help.view.SupportRequest;

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
        urlMapping.put("/getPhrase", CheeringController.class.getMethod("getPhrase"));
        urlMapping.put("/addPhrase", CheeringController.class.getMethod("addPhrase", SupportRequest.class));
//        urlMapping.put("getPhrase", DEP_CheeringServlet.class.getMethod("doGet"));
//        urlMapping.put("addPhrase", DEP_CheeringServlet.class.getMethod("doPost"));
    }


    public Method getControllerMethod(HttpServletRequest req) {
        String pathInfo = req.getPathInfo();
        Method method = urlMapping.get(pathInfo);
        System.out.println("pathInfo = " + pathInfo);
        return method;
    }
}
