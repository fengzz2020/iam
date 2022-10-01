package com.fengzz;

import com.fengzz.api.RoleController;
import com.fengzz.api.UserController;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;


/**
 * Hello world!
 *
 * @author Fengzz
 */
public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );

        Server server = new Server(9000);
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setContextPath("/");

        server.setHandler(contextHandler);

        // URL mapping
        contextHandler.addServlet(UserController.class, "/user/*");
        contextHandler.addServlet(RoleController.class, "/role/*");

        // start server
        try {
            init();
            server.start();
            server.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void init() {
        // pre init
    }
}
