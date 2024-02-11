package mts.services.help.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mts.services.help.ApplicationContext;
import mts.services.help.CheeringManager;
import mts.services.help.view.SupportRequest;
import mts.services.help.view.SupportResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class DEP_CheeringServlet extends HttpServlet {

    private CheeringManager manager;
    private ApplicationContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            context = new ApplicationContext();
            System.out.println("CONTEXT");
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        this.manager = context.getInstance(CheeringManager.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();

//        resp.setContentType("text/plain");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
//        resp.getWriter().append(manager.getCheeringPhrase());

        SupportResponse supportResponse = manager.getCheeringPhrase();
//        mapper.writeValueAsString();
        mapper.writeValue(resp.getWriter(), supportResponse);


        resp.getWriter().flush();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
//        resp.setContentType("text/plain");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        SupportRequest supportRequest = mapper.readValue(req.getReader(), SupportRequest.class);
        SupportResponse supportResponse = manager.addCheeringPhrase(supportRequest);

//        String phrase = req.getParameter("phrase");
//        String response = manager.depricated_addCheeringPhrase(phrase);
//        resp.getWriter().append(response);

        resp.getWriter().append(mapper.writeValueAsString(supportResponse));
        resp.getWriter().flush();
    }


    public DEP_CheeringServlet() {
    }

    public void setManager(CheeringManager manager) {
        this.manager = manager;
    }
}
