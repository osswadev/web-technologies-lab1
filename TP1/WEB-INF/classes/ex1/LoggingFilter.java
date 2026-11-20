package ex1;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

public class LoggingFilter implements Filter {

    private String prefix = "[LOG]";

    @Override
    public void init(FilterConfig config) throws ServletException {
        String p = config.getInitParameter("logPrefix");
        if (p != null) {
            prefix = p;
        }
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        long start = System.nanoTime();

        System.out.println(prefix + " avant : " + req.getRequestURL());

        chain.doFilter(request, response);

        System.out.println(prefix + " apres : " + req.getRequestURL());

        long end = System.nanoTime();
        System.out.println(prefix + " Temps d'execution : "
                + (end - start) / 1_000_000.0 + " ms");
    }

    @Override
    public void destroy() {
    }
}