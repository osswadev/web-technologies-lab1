package ex1;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationAttributeListener
        implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("[ApplicationAttributeListener] Added: "
                + event.getName() + " = " + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("[ApplicationAttributeListener] Replaced: "
                + event.getName() + ", old value = " + event.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("[ApplicationAttributeListener] Removed: "
                + event.getName() + " = " + event.getValue());
    }
}
