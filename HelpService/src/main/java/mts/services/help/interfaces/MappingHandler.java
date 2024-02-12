package mts.services.help.interfaces;

import jakarta.servlet.http.HttpServletRequest;
import mts.services.help.Logged;

import java.lang.reflect.Method;

public interface MappingHandler {

    @Logged
    Method getControllerMethod(HttpServletRequest req);

}
