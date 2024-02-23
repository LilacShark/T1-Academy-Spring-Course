package mts.supportbroker.broker;

import mts.supportbroker.config.SupportSubscriber;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubscriberBeanPostProcessor implements BeanPostProcessor {

    protected final static Map<Method, Object> METHOD_2_BEAN = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Arrays.stream(bean.getClass().getMethods())
                .filter(method -> method.isAnnotationPresent(SupportSubscriber.class))
                .forEach(method -> METHOD_2_BEAN.put(method, bean));
        return bean;
    }
}
