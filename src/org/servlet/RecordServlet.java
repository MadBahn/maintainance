package org.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.dao.Record_dao;
import org.factory.BeanFactory;
import org.model._Record;

import java.io.IOException;

@WebServlet(name = "RecordServlet", value = "/record")
public class RecordServlet extends HttpServlet {

    private Record_dao service = BeanFactory.getInstance("Record_impl",Record_dao.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");

        String _id = request.getParameter("_id");

        if(method.equals("del")){
            service.delRecord(_id);
        }
        else{
            String id = request.getParameter("id");
            String date = request.getParameter("date");
            String content = request.getParameter("content");
            String target = request.getParameter("target");

            _Record r_tmp = new _Record();

            r_tmp.setRecord_id(id);
            r_tmp.setRecord_date(date);
            r_tmp.setRecord_content(content);

            if(method.equals("add")){
                String obj_id = request.getParameter("ref_id");
                if(target.equals("rail")){
                    r_tmp.setEquipment_id("");
                    r_tmp.setFacility_id("");
                    r_tmp.setRail_id(obj_id);
                }else if(target.equals("facility")){
                    r_tmp.setEquipment_id(obj_id);
                    r_tmp.setFacility_id("");
                    r_tmp.setRail_id("");
                }else if(target.equals("infrastructure")){
                    r_tmp.setEquipment_id("");
                    r_tmp.setFacility_id(obj_id);
                    r_tmp.setRail_id("");
                }
                service.addRecord(r_tmp);
            }else if(method.equals("edit")){
                service.editRecord(r_tmp,_id);
            }
        }
        response.sendRedirect("report.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
