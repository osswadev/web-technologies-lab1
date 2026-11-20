//classe de test pour modification et suppression des attributs pour la partie 1.4.2 Tracking Events with Listeners Question 5

package ex1;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TestAttributeListeners")
public class TestAttributeListeners extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        // attributs de l'application
        getServletContext().setAttribute("appData", "Value1");
        getServletContext().setAttribute("appData", "Value2");
        getServletContext().removeAttribute("appData");

        // attributs de la requete
        request.setAttribute("requestData", "Value1");
        request.setAttribute("requestData", "Value2");
        request.removeAttribute("requestData");

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("Tests completed successfully!");
    }
}
