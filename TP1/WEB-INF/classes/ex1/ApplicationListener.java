package ex1;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        context.setAttribute("appName", "ING1 Web Application");
        System.out.println("[ApplicationListener] Application started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("[ApplicationListener] Application stopped");
    }
}
