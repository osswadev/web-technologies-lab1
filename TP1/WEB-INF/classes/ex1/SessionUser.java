package ex1;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

public class SessionUser implements HttpSessionBindingListener {

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("[SessionUser] Object added to session");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("[SessionUser] Object removed from session");
    }
}
