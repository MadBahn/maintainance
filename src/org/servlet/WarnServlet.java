package org.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.dao.Warning_dao;
import org.factory.BeanFactory;
import org.model.Warn;

import java.io.IOException;

@WebServlet(name = "WarnServlet", value = "/warn")
public class WarnServlet extends HttpServlet {

    private Warning_dao service = BeanFactory.getInstance("Warn_impl",Warning_dao.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _id = request.getParameter("_id");

        String method = request.getParameter("method");

        if(method.equals("del")){
            service.delWarn(_id);
        }else {
            String id = request.getParameter("id");
            String content = request.getParameter("content");
            String level = request.getParameter("level");
            String validtime = request.getParameter("validtime");
            String date = request.getParameter("date");
            if (!id.equals("")) {
                Warn w_tmp = new Warn();
                w_tmp.setWarn_id(id);
                w_tmp.setWarn_content(content);
                w_tmp.setWarn_grade(level);
                w_tmp.setWarn_validtime(validtime);
                w_tmp.setWarn_date(date);
                if ("add".equals(method)) {
                    service.addWarn(w_tmp);
                } else if ("edit".equals(method)) {
                    if (_id != null)
                        service.editWarn(w_tmp, _id);
                }

            }
        }
        response.sendRedirect("warning.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
