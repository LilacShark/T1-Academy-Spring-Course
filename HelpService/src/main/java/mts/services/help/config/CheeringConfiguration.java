package mts.services.help.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import mts.services.help.CheeringManagerImp;
import mts.services.help.JsonTypeHttpCallDispatcher;
import mts.services.help.controllers.CheeringControllerImp;
import mts.services.help.interfaces.*;
import mts.services.help.repository.CheeringInMemRepository;
import mts.services.help.CheeringServiceImp;
import mts.services.help.web.CommonMappingProvider;
import mts.services.help.web.MappingHandlerImp;

@Configuration
public class CheeringConfiguration {

    @Instance
    public CheeringService cheeringService() {
        return new CheeringServiceImp();
    }

    @Instance
    public CheeringManager cheeringManager() {
        return new CheeringManagerImp();
    }

    @Instance
    public CheeringController cheeringController() {
        return new CheeringControllerImp();
    }

    @Instance
    public CheeringInMemRepository repository() {
        return new CheeringInMemRepository();
    }

    @Instance
    public MappingHandler handler() {
        return new MappingHandlerImp();
    };

    @Instance
    public HttpCallDispatcher httpCallDispatcher() {
        return new JsonTypeHttpCallDispatcher();
    }

    @Instance
    public MappingProvider mappingProvider() {
        return new CommonMappingProvider();
    }

}
