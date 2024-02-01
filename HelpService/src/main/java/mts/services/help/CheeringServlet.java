package mts.services.help;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CheeringServlet extends HttpServlet {

    private CheeringManager manager;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.manager = new CheeringManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<html><body>");
        resp.getWriter().println(manager.getCheeringPhrase());
        resp.getWriter().println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<html><body>");
        resp.getWriter().println(manager.addCheeringPhrase(req.getParameter("phrase")));
        resp.getWriter().println("</body></html>");
    }


    public CheeringServlet() {
    }

}
