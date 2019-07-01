package ru.maksimov.servlet;


import org.eclipse.jetty.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MirrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Map<String,Object> param = createPageVarMap(req);
       String paramValue = (String) param.get("param");
       if (!StringUtil.isBlank(paramValue)) {
           resp.getWriter().println(param.get("param"));
       }
       resp.setContentType("text/html;charset=utf-8");
       resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private Map<String,Object> createPageVarMap(HttpServletRequest request){
        Map<String,Object> variable = new HashMap<String, Object>();
        String param = request.getParameter("key");
        variable.put("param",param);
        return variable;
    }
}
