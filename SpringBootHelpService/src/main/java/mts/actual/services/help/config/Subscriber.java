package mts.actual.services.help.config;

import org.springframework.scheduling.annotation.Scheduled;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Scheduled
public @interface Subscriber {
    long fixedRate() default -1L;
}
