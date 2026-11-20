package ex1;

import java.util.concurrent.atomic.AtomicInteger;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ActiveSessionListener implements HttpSessionListener {

    private static final AtomicInteger activeSessions = new AtomicInteger(0);

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        int count = activeSessions.incrementAndGet();

        ServletContext context = event.getSession().getServletContext();
        context.setAttribute("activeSessions", count);

        System.out.println("[ActiveSessionListener] Session created. Active sessions: "
                + count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        int count = activeSessions.decrementAndGet();

        ServletContext context = event.getSession().getServletContext();
        context.setAttribute("activeSessions", count);

        System.out.println("[ActiveSessionListener] Session destroyed. Active sessions: "
                + count);
    }
}
