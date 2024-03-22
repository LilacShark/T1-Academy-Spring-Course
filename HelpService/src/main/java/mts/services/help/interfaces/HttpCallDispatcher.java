package mts.services.help.interfaces;

import jakarta.servlet.http.HttpServletResponse;
import mts.services.help.model.Handler;

import java.lang.reflect.InvocationTargetException;

public interface HttpCallDispatcher {
    void dispatch(Handler handler, HttpServletResponse resp);
}

