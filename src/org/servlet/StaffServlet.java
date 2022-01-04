package org.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.dao.impl.Staff_impl;
import org.model.Staff;

import java.io.IOException;

@WebServlet(name = "StaffServlet", value = "/staff")
public class StaffServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Staff_impl si = new Staff_impl();
        String method = request.getParameter("method");

        String _id = request.getParameter("_id");

        if(method.equals("del")){
            si.delStaff(_id);
        }else{
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String account = request.getParameter("account");
            String pwd = request.getParameter("password");
            String pos = request.getParameter("position");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");

            Staff s_tmp = new Staff();

            s_tmp.setStaff_id(id);
            s_tmp.setStaff_name(name);
            s_tmp.setStaff_account(account);
            s_tmp.setStaff_password(pwd);
            s_tmp.setStaff_position(pos);
            s_tmp.setStaff_phone(phone);
            s_tmp.setStaff_email(email);

            si.addStaff(s_tmp);

        }
        response.sendRedirect("./sys/sys_index.jsp");

    }
}
