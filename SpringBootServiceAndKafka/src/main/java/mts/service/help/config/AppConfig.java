package mts.service.help.config;

import mts.service.help.repository.CheeringInMemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CheeringInMemRepository repository() {
        return new CheeringInMemRepository();
    }

//    @Bean
//    public CheeringService serviceImp(CheeringInMemRepository repository) {
//        return new CheeringServiceImp(repository);
//    }

}
