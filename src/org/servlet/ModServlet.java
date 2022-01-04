package org.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.dao.impl.Staff_impl;
import org.model.Staff;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ModServlet", value = "/mod")
public class ModServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Staff_impl si = new Staff_impl();

        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String method = request.getParameter("method");
        String pwd = request.getParameter("pwd");

        Staff s_tmp = (Staff) request.getSession().getAttribute("user");
        if(pwd.equals(s_tmp.getStaff_password())) {
            if (method.equals("info")) {
                s_tmp.setStaff_phone(request.getParameter("phone"));
                s_tmp.setStaff_email(request.getParameter("email"));
                si.editStaff(s_tmp,id,pwd);
            } else if (method.equals("pwd")) {
                s_tmp.setStaff_account(request.getParameter("account"));
                s_tmp.setStaff_password(request.getParameter("pwd_r"));
                si.editPwd(s_tmp,id,pwd);
            }
            response.sendRedirect("main.jsp");
        }else {
            response.sendRedirect("account.jsp");
        }
    }
}
