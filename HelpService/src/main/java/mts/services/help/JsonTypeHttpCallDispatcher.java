package mts.services.help;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jfr.ContentType;
import mts.services.help.interfaces.HttpCallDispatcher;
import mts.services.help.model.Handler;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class JsonTypeHttpCallDispatcher implements HttpCallDispatcher {

    ObjectMapper objectMapper;

    public JsonTypeHttpCallDispatcher() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public void dispatch(Handler handler, HttpServletResponse resp) {
        Object result;
        try {
            result = handler.method().invoke(handler.target());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        resp.setContentType("application/json");

        try {
            resp.getWriter().append(objectMapper.writeValueAsString(result));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
