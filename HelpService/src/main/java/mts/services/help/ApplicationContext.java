package mts.services.help;

import mts.services.help.config.Configuration;
import mts.services.help.config.WebController;
import mts.services.help.config.Instance;
import mts.services.help.config.SemiAutoWired;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class ApplicationContext {

    private final Map<Class<?>, Object> instances = new HashMap<>();
    private List<?> controllers;

    public ApplicationContext() throws InvocationTargetException, IllegalAccessException {
        fillInstances();
        fillControllers();
    }

    private void fillControllers() {
        Reflections reflections = new Reflections("mts.services.help.controllers");
        controllers = reflections.getTypesAnnotatedWith(WebController.class)
                .stream()
                .map(type -> {
                    System.out.println("==== fillControllers " + type);
                    return instances.get(type);
                }).toList();
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

            for (Method method : methods) {
//                final var instance = loggingProxyWrapper(method.invoke(configuration));
                instances.put(method.getReturnType(), method.invoke(configuration));
            }
            for (Class<?> aClass : instances.keySet()) {
                System.out.println("==== fillInstances " + aClass + " " + instances.get(aClass));
            }

            for (Method method : methods) {
                Object instance = instances.get(method.getReturnType());
                Field[] declaredFieldsInClass = instance.getClass().getDeclaredFields();
                for (Field fieldInClass : declaredFieldsInClass) {
                    if (fieldInClass.isAnnotationPresent(SemiAutoWired.class)) {
                        try {
                            String setterName = "set"
                                    + fieldInClass.getName().substring(0, 1).toUpperCase()
                                    + fieldInClass.getName().substring(1);
                            Method setter = fieldInClass.getDeclaringClass().getMethod(setterName, fieldInClass.getType());
                            setter.invoke(instance, instances.get(fieldInClass.getType()));
                        } catch (NoSuchMethodException e) {
                            throw new RuntimeException(e);
                        }
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