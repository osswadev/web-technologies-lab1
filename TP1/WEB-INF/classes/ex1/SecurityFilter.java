package ex1;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest =
                (HttpServletRequest) request;
        HttpServletResponse httpResponse =
                (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        boolean connected = session != null
                && session.getAttribute("user") != null;

        System.out.println("[SECURITY] avant");

        if (connected) {

            System.out.println("[SECURITY] User authorized");

            chain.doFilter(request, response);

            System.out.println("[SECURITY] apres");

        } else {

            System.out.println("[SECURITY] Access refused");

            httpResponse.sendRedirect(
                    httpRequest.getContextPath() + "/login.html");
        }
    }
}
