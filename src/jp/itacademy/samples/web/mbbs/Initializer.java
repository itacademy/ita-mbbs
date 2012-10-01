package jp.itacademy.samples.web.mbbs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent e) {
        ServletContext ctx = e.getServletContext();
        ctx.removeAttribute("userMap");
        ctx.removeAttribute("handleSet");
        ctx.removeAttribute("messages");
    }

    @Override
    public void contextInitialized(ServletContextEvent e) {
        ServletContext ctx = e.getServletContext();
        ctx.setAttribute("userMap", new HashMap<>());
        ctx.setAttribute("handleSet", new HashSet<>());
        ctx.setAttribute("messages", new ArrayList<>());
    }

}
