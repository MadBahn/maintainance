package org.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.dao.Infrastructure_dao;
import org.factory.BeanFactory;
import org.model.Infrastructure;

import java.io.IOException;

@WebServlet(name = "InfrastructureServlet", value = "/infrastructure")
public class InfrastructureServlet extends HttpServlet {

    private Infrastructure_dao service = BeanFactory.getInstance("Infr_impl",Infrastructure_dao.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");

        String _id = request.getParameter("_id");

        if(method.equals("del")){
            service.delInfrastructure(_id);
        }
        else{
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String state = request.getParameter("state");
            String type = request.getParameter("type");
            String remark = request.getParameter("remark");

            Infrastructure i_tmp = new Infrastructure();

            i_tmp.setFacility_id(id);
            i_tmp.setFacility_name(name);
            i_tmp.setFacility_state(state);
            i_tmp.setFacility_type(type);
            i_tmp.setFacility_remark(remark);

            if(method.equals("add")){
                service.addInfrastructure(i_tmp);
            }else if(method.equals("edit")){
                service.editInfrastructure(i_tmp,_id);
            }

        }
        response.sendRedirect("infrastructure.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
