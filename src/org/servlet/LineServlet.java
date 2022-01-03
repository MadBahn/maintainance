package org.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.dao.Rail_dao;
import org.factory.BeanFactory;
import org.model.Rail;

import java.io.IOException;

@WebServlet(name = "LineServlet", value = "/line")
public class LineServlet extends HttpServlet {

    private Rail_dao service = BeanFactory.getInstance("Rail_impl",Rail_dao.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");

        String _id = request.getParameter("id");

        if(method.equals("del")){
            service.delRail(_id);
        }else {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String grade = request.getParameter("grade");//level
            String level = request.getParameter("level");//type
            String gauge = request.getParameter("gauge");
            String length = request.getParameter("length");
            String subgrade = request.getParameter("subgrade");
            String position = request.getParameter("position");
            String elec = request.getParameter("electrification") != null ? "是" : "否";
            String remark = request.getParameter("remark");

            Rail r_tmp = new Rail();

            if (!id.equals("")) {
                r_tmp.setRail_id(id);
                r_tmp.setRail_name(name);
                r_tmp.setRail_grade(grade);
                r_tmp.setRail_type(level);
                r_tmp.setRail_gauge(gauge);
                r_tmp.setRail_length(length);
                r_tmp.setRail_subgrade(subgrade);
                r_tmp.setRail_position(position);
                r_tmp.setRail_electrification(elec);
                r_tmp.setRail_remark(remark);

                if ("add".equals(method)) {
                    service.addRail(r_tmp);
                } else if ("edit".equals(method)) {
                    service.editRail(r_tmp, id);
                }
            }
        }
        response.sendRedirect("line.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }
}
