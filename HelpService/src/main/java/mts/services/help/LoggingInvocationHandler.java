package mts.services.help;

import jakarta.servlet.http.HttpServletRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class LoggingInvocationHandler implements InvocationHandler {

    private final Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(method.isAnnotationPresent(Logged.class)) {
            HttpServletRequest arg = (HttpServletRequest) args[0];

            System.out.println("==== PROXY LOGGER ==== TIME:" + LocalDateTime.now() + "URL: " + arg.getPathInfo() + " METHOD: " + arg.getMethod());
            return method.invoke(target, args);
        }
        return method.invoke(target, args);
    }
}
