package ru.maksimov;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ru.maksimov.servlet.MirrorServlet;

public class Main {

    public static void main(String[] args) throws Exception {
        MirrorServlet mirrorServlet = new MirrorServlet();
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(mirrorServlet),"/mirror");

        Server server = new Server(8080);
        server.setHandler(handler);
        server.start();
        System.out.println("Server started");
        server.join();


    }
}
