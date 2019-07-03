package ru.maksimov.servlet;

import org.eclipse.jetty.util.StringUtil;
import ru.maksimov.entities.UserProfile;
import ru.maksimov.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    private final AccountService accountService;

    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserProfile userProfile = new UserProfile()
                .setLogin(req.getParameter("login"))
                .setPassword(req.getParameter("password"));
        if (StringUtil.isBlank(userProfile.getLogin()) || StringUtil.isBlank(userProfile.getPassword())) {
            throw new ServletException("нет соответсвующих параметров");
        };
        accountService.signUp(userProfile);
    }
}
