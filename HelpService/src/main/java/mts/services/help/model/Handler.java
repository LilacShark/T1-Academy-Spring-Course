package mts.services.help.model;

import java.lang.reflect.Method;

public record Handler(Object target, Method method) {
}
