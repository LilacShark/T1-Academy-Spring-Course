package mts.services.help.interfaces;

import jakarta.servlet.http.HttpServletRequest;
import mts.services.help.ApplicationContext;
import mts.services.help.model.Handler;

public interface MappingProvider {

    void init(ApplicationContext context);

    Handler getMapping(HttpServletRequest req);

}
