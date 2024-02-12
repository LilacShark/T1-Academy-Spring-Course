package mts.services.help;

import mts.services.help.config.Configuration;
import mts.services.help.config.Controller;
import mts.services.help.config.Instance;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

public class ApplicationContext {

    private final Map<Class<?>, Object> instances = new HashMap<>();
    private List<?> controllers;

    private static volatile ApplicationContext APPLICATION_CONTEXT_INSTANCE;

    public static ApplicationContext get_APPLICATION_CONTEXT_INSTANCE() {

        if (APPLICATION_CONTEXT_INSTANCE == null) {
            synchronized (ApplicationContext.class) {
                if (APPLICATION_CONTEXT_INSTANCE == null) {
                    try {
                        APPLICATION_CONTEXT_INSTANCE = new ApplicationContext();
                    } catch (InvocationTargetException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        return APPLICATION_CONTEXT_INSTANCE;
    }

    private ApplicationContext() throws InvocationTargetException, IllegalAccessException {
        fillInstances();
        fillControllers();
    }

    private void fillControllers() {
        Reflections reflections = new Reflections("mts.services.help.controllers");
        controllers = reflections.getTypesAnnotatedWith(Controller.class)
                .stream()
                .map(type -> {
                    try {
                        return type.getDeclaredConstructor().newInstance();
                    } catch (InstantiationException | IllegalAccessException
                             | InvocationTargetException | NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
    }

    private void fillInstances() throws InvocationTargetException, IllegalAccessException {
        Reflections reflections = new Reflections("mts.services.help.config");
        List<?> configurations = reflections.getTypesAnnotatedWith(Configuration.class)
                .stream()
                .map(type -> {
                    try {
                        return type.getDeclaredConstructor().newInstance();
                    } catch (InstantiationException | IllegalAccessException
                             | InvocationTargetException | NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();

        for (Object configuration : configurations) {
            List<Method> methods = Arrays.stream(configuration.getClass().getMethods())
                    .filter(method -> method.isAnnotationPresent(Instance.class))
                    .toList();
            List<Method> methodsWithoutParams = methods.stream()
                    .filter(method -> method.getParameters().length == 0)
                    .toList();
            List<Method> methodsWithParameters = methods.stream()
                    .filter(method -> method.getParameters().length > 0)
                    .toList();
            for (Method method : methodsWithoutParams) {
                final var instance = loggingProxyWrapper(method.invoke(configuration));
                instances.put(method.getReturnType(), method.invoke(configuration));
            }

            for (Method method : methodsWithParameters) {
                Object[] objects = Arrays.stream(method.getParameters())
                        .map(param -> instances.get(param.getType()))
                        .toArray();
                final var instance = loggingProxyWrapper(method.invoke(configuration, objects));
                instances.put(method.getReturnType(), method.invoke(configuration, objects));

            }

            for (Method method : methodsWithParameters) {
                Object instance = instances.get(method.getReturnType());
                Field[] declaredFieldsInClass = instance.getClass().getDeclaredFields();
                for (Field fieldInClass : declaredFieldsInClass) {
                    try {
                        String setterName = "set" + fieldInClass.getName().substring(0, 1).toUpperCase() + fieldInClass.getName().substring(1);
                        Method setter = fieldInClass.getDeclaringClass().getMethod(setterName, fieldInClass.getType());
                        setter.invoke(instance, instances.get(fieldInClass.getType()));
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    private Object loggingProxyWrapper(Object object) {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new LoggingInvocationHandler(object)
        );
    }

    public <T> T getInstance(Class<T> type) {
        return (T) Optional.ofNullable(instances.get(type))
                .orElseThrow();
    }

    public List<?> getControllers() {
        return List.copyOf(controllers);
    }
}
