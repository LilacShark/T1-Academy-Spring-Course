package mts.supportbroker.broker;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties("inmemory-broker")
public record InMemConfigProperties(boolean enabled) {

}
