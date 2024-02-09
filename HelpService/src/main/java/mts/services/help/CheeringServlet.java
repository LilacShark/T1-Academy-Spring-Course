package mts.services.help;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class CheeringServlet extends HttpServlet {

    private CheeringManager manager;
    private ApplicationContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            context = new ApplicationContext();
            System.out.println("CONTEXT");
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
//        this.cheeringServiceImp = context.getInstance(CheeringServiceImp.class);
        this.manager = context.getInstance(CheeringManager.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().append(manager.getCheeringPhrase());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().append(manager.addCheeringPhrase(req.getParameter("phrase")));
    }


    public CheeringServlet() {
    }

    public void setManager(CheeringManager manager) {
        this.manager = manager;
    }
}
