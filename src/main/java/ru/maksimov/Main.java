package ru.maksimov;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ru.maksimov.service.AccountService;
import ru.maksimov.servlet.SignInServlet;
import ru.maksimov.servlet.SignUpServlet;

public class Main {

    public static void main(String[] args) throws Exception {
        AccountService accountService = new AccountService();
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.addServlet(new ServletHolder(new SignInServlet(accountService)),"/signin");
        handler.addServlet(new ServletHolder(new SignUpServlet(accountService)),"/signup");

        Server server = new Server(8080);
        server.setHandler(handler);
        server.start();
        System.out.println("Server started");
        server.join();
    }


}
