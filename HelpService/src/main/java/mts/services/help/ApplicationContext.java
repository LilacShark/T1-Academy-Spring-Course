package mts.services.help;

import javassist.tools.reflect.Reflection;
import mts.services.help.config.Configuration;
import mts.services.help.config.Instance;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ApplicationContext {

    private Map<Class<?>, Object> instances = new HashMap<>();

    public ApplicationContext() throws InvocationTargetException, IllegalAccessException {
        Reflections reflections = new Reflections("mts.services.help.config");
        List<?> configurations = reflections.getTypesAnnotatedWith(Configuration.class)
                .stream()
                .map(type -> {
                    try {
                        return type.getDeclaredConstructor().newInstance();
                    } catch (InstantiationException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    } catch (NoSuchMethodException e) {
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
                instances.put(method.getReturnType(), method.invoke(configuration));
            }
            for (Method method : methodsWithParameters) {
                Object[] objects = Arrays.stream(method.getParameters())
                        .map(param -> instances.get(param.getType()))
                        .toArray();
                instances.put(method.getReturnType(), method.invoke(configuration, objects));
            }
        }
    }

    public <T> T getInstance(Class<T> type) {
        return (T) Optional.ofNullable(instances.get(type))
                .orElseThrow();
    }
}
