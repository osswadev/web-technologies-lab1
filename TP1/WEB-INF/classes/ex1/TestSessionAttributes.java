//classe de test pour modification et suppression des attributs pour la partie 1.4.2 Tracking Events with Listeners Question 4
package ex1;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/TestSessionAttributes")
public class TestSessionAttributes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession(false);

        response.setContentType("text/html;charset=UTF-8");

        if (session == null ||
            session.getAttribute("user") == null) {

            response.getWriter().println(
                "Connectez-vous d'abord avec login.html"
            );
            return;
        }

        // modifier l'attribut existant
        session.setAttribute("user", "Osswa2");

        // suppression de l'attribut
        session.removeAttribute("user");

        response.getWriter().println(
            "Tests completed successfully!"
        );
    }
}
