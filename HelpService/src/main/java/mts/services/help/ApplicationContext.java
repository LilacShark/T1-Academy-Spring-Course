package mts.services.help;

import mts.services.help.config.Configuration;
import mts.services.help.config.Instance;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ApplicationContext {

    private final Map<Class<?>, Object> instances = new HashMap<>();

    public ApplicationContext() throws InvocationTargetException, IllegalAccessException {
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

        // внедрение через сетторы
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
            //////////////////////// внедрение тут
            for (Method method : methodsWithParameters) {
                Object[] objects = Arrays.stream(method.getParameters())
                        .map(param -> instances.get(param.getType()))
                        .toArray();
                instances.put(method.getReturnType(), method.invoke(configuration, objects));

            }

            for (Method method : methodsWithParameters) {
                System.out.println(method.getReturnType() + " " + instances.get(method.getReturnType()) + " " + instances.get(method.getReturnType()).getClass());

                Object instance = instances.get(method.getReturnType());
                System.out.println(instance);
                Field[] declaredFieldsInClass = instance.getClass().getDeclaredFields();
                for (Field fieldInClass : declaredFieldsInClass) {
                    try {
                        System.out.println(fieldInClass);
                        String setterName = "set" + fieldInClass.getName().substring(0, 1).toUpperCase() + fieldInClass.getName().substring(1);

                        System.out.println(setterName);
                        System.out.println(fieldInClass.getDeclaringClass());

                        Method setter = fieldInClass.getDeclaringClass().getMethod(setterName, fieldInClass.getType());

                        System.out.println(setter.getName());
                        System.out.println(fieldInClass.getDeclaringClass() + " ожидаем " + fieldInClass.getType() + " " + instances.get(fieldInClass.getType()));

                        setter.invoke(instance, instances.get(fieldInClass.getType()));
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

/*

                Field[] declaredFields = invoke.getClass().getDeclaredFields();
                for (Field declaredField : declaredFields) {
                    Class<?> type = declaredField.getType();
                    ;
                    declaredField.
 */
    }

    public <T> T getInstance(Class<T> type) {
        return (T) Optional.ofNullable(instances.get(type))
                .orElseThrow();
    }
}

/*
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
//            /////////////
            for (Method method : methodsWithParameters) {
                Object[] objects = Arrays.stream(method.getParameters())
                        .map(param -> instances.get(param.getType()))
                        .toArray();
                instances.put(method.getReturnType(), method.invoke(configuration, objects));
            }
        }


                Field[] declaredFieldsInClass = method.getClass().getDeclaredFields();
                for (Field fieldsInClass : declaredFieldsInClass) {
                    try {
                        fieldsInClass.getClass().getMethod("set"+fieldsInClass, (Class<?>) instances.get(fieldsInClass.getType()));
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                }



                    try {
                        fieldsInClass.getClass().getMethod("set"+fieldsInClass, (Class<?>) instances.get(fieldsInClass.getType()));
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
 */

/*
            for (Method method : methodsWithParameters) {
                Object[] objects = Arrays.stream(method.getParameters())
                        .map(param -> instances.get(param.getType()))
                        .toArray();
                instances.put(method.getReturnType(), method.invoke(configuration, objects));

                System.out.println(method.getReturnType() + " " + instances.get(method.getReturnType()) + " " + instances.get(method.getReturnType()).getClass());

                Object instance = instances.get(method.getReturnType());
                Field[] declaredFieldsInClass = instance.getClass().getDeclaredFields();
                for (Field fieldInClass : declaredFieldsInClass) {
                    try {
                        String setterName = "set" + fieldInClass.getName().substring(0, 1).toUpperCase() + fieldInClass.getName().substring(1);
//                        System.out.println(setterName);
//                        System.out.println(fieldInClass.getDeclaringClass());
                        Method setter = fieldInClass.getDeclaringClass().getMethod(setterName, fieldInClass.getType());
                        System.out.println(setter.getName());
                        System.out.println(fieldInClass.getDeclaringClass() + " ожидаем " + fieldInClass.getType() + " " + instances.get(fieldInClass.getType()));
                        setter.invoke(fieldInClass.getDeclaringClass(), instances.get(fieldInClass.getType()));
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
 */