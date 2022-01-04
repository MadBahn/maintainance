package org.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.dao.Mission_dao;
import org.factory.BeanFactory;
import org.model.Mission;

import java.io.IOException;

@WebServlet(name = "MissionServlet", value = "/mission")
public class MissionServlet extends HttpServlet {

    private Mission_dao service = BeanFactory.getInstance("Mission_impl",Mission_dao.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");

        String _id = request.getParameter("_id");
        String id = request.getParameter("id");

        if(method.equals("del")){
            service.delMission(_id);
        }
        else{
            if(!id.equals("")) {
                String content = request.getParameter("content");
                String date = request.getParameter("date");

                Mission m_tmp = new Mission();

                m_tmp.setTask_id(id);
                m_tmp.setTask_content(content);
                m_tmp.setTask_date(date);

                if(method.equals("add")){
                    service.addMission(m_tmp);
                }else if(method.equals("edit")){
                    service.editMission(m_tmp,_id);
                }

            }
        }
        response.sendRedirect("mission.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
