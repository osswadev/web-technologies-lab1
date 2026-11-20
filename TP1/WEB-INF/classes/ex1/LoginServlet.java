package ex1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");

        HttpSession session = request.getSession();

        session.setAttribute("user", username);

        session.setAttribute("sessionUser", new SessionUser());

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Login successful</h2>");
        out.println("<p>Welcome, " + username + "!</p>");


        out.println("<form action='ListItems' method='POST'>");
        out.println("<input type='submit' value='Go to items'>");
        out.println("</form>");


        out.println("<form action='RemoveSessionUser' method='POST'>");
        out.println("<input type='submit' value='Remove SessionUser'>");
        out.println("</form>");

        out.println("</body></html>");
    }
}
