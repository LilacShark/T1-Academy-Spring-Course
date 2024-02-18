package mts.actual.services.help;

import mts.actual.services.help.config.SupaLogged;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LoggingBeanPostProcessor implements BeanPostProcessor {

    private final Map<String, Object> beanName2Target = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(SupaLogged.class)) {
            beanName2Target.put(beanName, bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        final var object = beanName2Target.get(beanName);
        if (object != null) {
            System.out.println("Вызван пост-процессор для beanName: " + beanName + " класса: " + object.getClass() + " bean: " + bean);
            return new LoggableSupportServiceModern((CheeringServiceModernImp) bean);
        }
        return bean;
    }

}
