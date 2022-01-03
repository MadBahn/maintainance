package org.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.dao.Facility_dao;
import org.factory.BeanFactory;
import org.model.Facility;

import java.io.IOException;

@WebServlet(name = "FacilityServlet", value = "/facility")
public class FacilityServlet extends HttpServlet {

    private Facility_dao service = BeanFactory.getInstance("Facility_impl",Facility_dao.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _id = request.getParameter("_id");
        String method = request.getParameter("method");

        if(method.equals("del")){
            service.delFacility(_id);
        }
        else{
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            String date = request.getParameter("date");
            String price = request.getParameter("price");

            Facility f_tmp = new Facility();

            f_tmp.setEquipment_id(id);
            f_tmp.setEquipment_name(name);
            f_tmp.setEquipment_type(type);
            f_tmp.setEquipment_date(date);
            f_tmp.setEquipment_price(price);

            if(method.equals("add")){
                service.addFacility(f_tmp);
            }
            else if(method.equals("edit")){
                service.editFacility(f_tmp,_id);
            }
        }
        response.sendRedirect("facility.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
