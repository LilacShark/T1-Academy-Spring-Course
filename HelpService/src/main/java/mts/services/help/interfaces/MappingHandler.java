package mts.services.help.interfaces;

import jakarta.servlet.http.HttpServletRequest;
import mts.services.help.ApplicationContext;
import mts.services.help.Logged;
import mts.services.help.controllers.CheeringControllerImp;

import java.lang.reflect.Method;

public interface MappingHandler {

    @Logged
    Method getControllerMethod(HttpServletRequest req);

    void initHandler(ApplicationContext context);

    Object getControllerClass(HttpServletRequest req);

}
